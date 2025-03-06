package design_pattern.reader_writer_pattern;

import java.util.ArrayList;

public class ReaderWriterDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        ArrayList<Thread> readers = new ArrayList<>();
        ArrayList<Thread> writers = new ArrayList<>();

        // Create 100 reader threads
        for (int i = 0; i <= 10; i++) {
            Thread reader = new Thread(() -> resource.readData(Thread.currentThread().getName()), "Reader-" + i);
            Thread writer = new Thread(() -> resource.writeData(Thread.currentThread().getName(), "Updated Data by " + Thread.currentThread().getName()), "Writer-" + i);
            readers.add(reader);
            writers.add(writer);
        }

        for (int i = 0; i <= 10; i++) {
            readers.get(i).start();
            writers.get(i).start();
        }


    }
}












//package design_pattern.reader_writer_pattern;
//
//public class ReaderWriterDemo {
//    public static void main(String[] args) {
//        SharedResource resource = new SharedResource();
//
//        // Create reader threads
//        Runnable readerTask = () -> resource.readData(Thread.currentThread().getName());
//
//
//        // Create writer threads
//        Runnable writerTask = () -> resource.writeData(Thread.currentThread().getName(), "Updated Data by " + Thread.currentThread().getName());
//
//
//        Thread reader1 = new Thread(readerTask, "Reader-1");
//        Thread reader2 = new Thread(readerTask, "Reader-2");
//        Thread reader3 = new Thread(readerTask, "reader-3");
//        Thread writer1 = new Thread(writerTask, "Writer-1");
//
//
//        // Start threads
//
//        reader1.start();
//        writer1.start();
//        reader2.start();
//        reader3.start();
//    }
//}
