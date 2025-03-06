package reader_writer_pattern;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    private String data = "Initial Data";
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static String getTimestamp() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss:SSS a"));
    }


    // Reader Method
    public void readData(String readerName) {
        lock.readLock().lock(); // Acquire read lock
        try {
            System.out.println("["+ readerName.toUpperCase() + "]" + " is reading: " + "["  + data + "]"+ "[" + getTimestamp() + "]");
            Thread.sleep(50); // Simulate read time
        }catch(InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock(); // Release read lock
        }
    }

    // Writer Method
    public void writeData(String writerName, String newData) {
        lock.writeLock().lock(); // Acquire write lock
        try {
            System.out.println("["+ writerName.toUpperCase() + "]" + " is writing : " + "["+ newData + "]" + "[" + getTimestamp() + "]");
            Thread.sleep(50); // Simulate write time
            data = newData;
            System.out.println("["+ writerName.toUpperCase() + "]" + " has finished writing. "+ "[" + getTimestamp() + "]");
        }catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock(); // Release write lock
        }
    }
}
