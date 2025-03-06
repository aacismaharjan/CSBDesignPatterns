# Sleeping Barber Problem in Java
The Sleeping Barber Problem is a classic synchronization problem that involves a barber, a barber chair, and a waiting room with a limited number of chairs. The problem demonstrates process synchronization and is often implemented using semaphores and threads

## Problem Statement
- There is one barber and N waiting chairs.
- Customers arrive randomly.
- If the barber is free, the customer get a haircut.
- If the barber is busy, customers sit in the waiting area.
- If no chairs are available, the customer leaves.
- If no customers are present, the barber sleeps until a customer arrives.

## Implementation Using Java & Semaphores
We use
- Semaphore: To control access to shared resources
- Lock and Condition: For thread synchronization
- ExecutorService: For managing threads