package producer_consumer_pattern;

public class SharedBuffer {
    private final int[] buffer = new int[5]; // Shared buffer
    private int count = 0; // Number of items in the buffer

    // Producer adds an item to the buffer
    public synchronized void produce(int item) throws InterruptedException {
        while(count == buffer.length) {
            System.out.println("Producer is waiting...");
            wait();  // Wait if buffer is full
        }

        buffer[count] = item;
        count++;
        System.out.println("Produced: " + item);
        notify(); // Notify consumer that an item is available
    }

    // Consumer removes an item from the buffer
    public synchronized int consume() throws InterruptedException {
        while(count == 0) {
            System.out.println("Consumer is waiting...");
            wait(); // Wait if buffer is empty.
        }

        count--;
        int item = buffer[count];
        System.out.println("Consumed: " + item);
        notify(); // Notify producer that space is available in the buffer
        return item;
    }
}


class Producer extends Thread {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            int item = 0;
            while (true) {
                buffer.produce(item);
                item++;
                Thread.sleep(10); // Simulate production time;
            }
        }catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer extends Thread {
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while(true) {
                buffer.consume();
                Thread.sleep(11); // Simulate consumption time
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

