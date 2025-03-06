# Inter Thread Communication
- Crucial for synchronizing threads and managing shared resources.
- Producer-Consumer problem is a classic example where the Producer threads adds items to a shared buffer, and the Consumer thread removes items from the same buffer.
- Threads need to communicate with each other to ensure that the buffer does not overflow or underflow
- In Java inter-thread communication is achieved using the wait(), notify(), and notifyAll() methods. 

## wait() 
A thread calls this method when it wants to release the lock and go to sleep until another thread sends a notification. 

## notify()
This method wakes up one thread that is waiting on the object's monitor. 

## notifyAll()
This wakes up all the threads that are waiting on the object's monitor.


## Producer-Consumer using Inter-Thread Communication
- The `Producer` thread produces items and adds them to the buffer.
- The `Consumer` thread consumes items from the buffer.
- Both the producer and consumer threads use `wait()` and `notify()` to synchronize and communicate with each other.