package sleeping_barber_pattern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class BarberShop {
    static final int MAX_WAITING_CUSTOMERS = 5;
    static Semaphore mutex = new Semaphore(1);  // For mutual exclusion
    static Semaphore customerSemaphore = new Semaphore(0);  // Customers waiting for the barber
    static Semaphore barberSemaphore = new Semaphore(0);  // Barber waiting for a customer
    static Queue<Customer> waitingRoom = new LinkedList<>();

    static class Barber extends Thread {
        public void run() {
            while (true) {
                try {
                    customerSemaphore.acquire();  // Wait for a customer
                    mutex.acquire();  // Ensure mutual exclusion while accessing waiting room
                    Customer customer = waitingRoom.poll();  // Get the next customer
                    System.out.println("Barber is cutting hair of customer " + customer.getId());
                    mutex.release();
                    Thread.sleep(3000);  // Simulating hair cutting time
                    barberSemaphore.release();  // Notify customer that their haircut is done
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Customer extends Thread {
        private int id;

        public Customer(int id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void run() {
            try {
                mutex.acquire();  // Ensure mutual exclusion while accessing waiting room
                if (waitingRoom.size() < MAX_WAITING_CUSTOMERS) {
                    waitingRoom.add(this);  // Add customer to the waiting room
                    System.out.println("Customer " + id + " is waiting.");
                    customerSemaphore.release();  // Notify barber that a customer is waiting
                    mutex.release();
                    barberSemaphore.acquire();  // Wait for the barber to finish the haircut
                    System.out.println("Customer " + id + " has finished the haircut.");
                } else {
                    mutex.release();
                    System.out.println("Customer " + id + " leaves as the waiting room is full.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Barber barber = new Barber();
        barber.start();

        // Create some customer threads
        for (int i = 1; i <= 10; i++) {
            Customer customer = new Customer(i);
            customer.start();
            Thread.sleep(1000);  // Simulate new customers arriving at intervals
        }
    }
}
