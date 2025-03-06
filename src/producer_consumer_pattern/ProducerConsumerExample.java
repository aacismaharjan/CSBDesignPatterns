package producer_consumer_pattern;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Create producer and consumer threads
        Thread producerThread = new Producer(buffer);
        Thread consumerThread = new Consumer(buffer);

        producerThread.start();
        consumerThread.start();
    }
}