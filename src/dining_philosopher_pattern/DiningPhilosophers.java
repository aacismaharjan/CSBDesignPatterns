package dining_philosopher_pattern;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private int id;
    private Semaphore leftFork, rightFork;

    public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking...");
        Thread.sleep((long) (Math.random() * 2000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " is eating...");
        Thread.sleep((long) (Math.random() * 2000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();  // Philosopher thinks before trying to eat

                // Pick up forks in a specific order (to avoid deadlock)
                if (id % 2 == 0) {  // Even philosophers pick up the left fork first
                    leftFork.acquire();
                    System.out.println("Philosopher " + id + " picked up left fork.");
                    rightFork.acquire();
                    System.out.println("Philosopher " + id + " picked up right fork.");
                } else {  // Odd philosophers pick up the right fork first
                    rightFork.acquire();
                    System.out.println("Philosopher " + id + " picked up right fork.");
                    leftFork.acquire();
                    System.out.println("Philosopher " + id + " picked up left fork.");
                }

                eat();  // Eating process

                // Release the forks
                leftFork.release();
                System.out.println("Philosopher " + id + " put down left fork.");
                rightFork.release();
                System.out.println("Philosopher " + id + " put down right fork.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Semaphore[] forks = new Semaphore[numPhilosophers];

        // Initialize semaphores for each fork
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }

        // Create and start philosopher threads
        for (int i = 0; i < numPhilosophers; i++) {
            new Philosopher(i, forks[i], forks[(i + 1) % numPhilosophers]).start();
        }
    }
}
