package example_5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Using Synchronized to create a lock and avoid two threads to alter a variable at the same time.
 * @param <E>
 */
public class LinkedBlockingQueues<E> { // class uses generics, any type can be specified at runtime

    private Object lock; // monitor for synchronization - ensures thread-safe access to the queue
    private Queue<E> queue; // stores the elements of the queue

    public LinkedBlockingQueues() {
        // Initializes the queue as a LinkedList and creates the lock object.
        queue = new LinkedList<>();
        lock = new Object();
    }

    // Adds an element to the queue
    public boolean add(E e) {
        // synchronized ensures only one thread can modify the queue at a time
        synchronized (lock) {
            queue.add(e); // add element to the queue
            lock.notify(); // wake up any thread waiting on the lock (via take()), signaling that the queue is no longer empty
            return true; // always return true
        }
    }

    // Removes and returns the first element of the queue. If the queue is empty, the calling thread waits until an element becomes available.
    public E take() {
        // The method synchronizes on the lock object to safely check and modify the queue.
        synchronized (lock) {
            // If the queue is empty, the thread enters a while loop, waiting (lock.wait()) for a signal (via lock.notify()).
            while(queue.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Once an element is available, it removes the first element from the queue using poll() (which retrieves and removes the head of the queue).
            return queue.poll();
        }
    }

    // Returns the current size of the queue
    public synchronized int size() {
        // Uses the synchronized keyword on the method itself to ensure thread-safe access to the queue size.
        return queue.size();
    }

}

/*
Thread Safety:
- The add() and take() methods use synchronization on the lock object to prevent concurrent modifications to the queue.
- The size() method is synchronized to ensure consistency when checking the queue's size.

Blocking Behavior:
- The take() method blocks (waits) if the queue is empty, resuming only when another thread adds an element to the queue and calls lock.notify().

Efficiency:
- The use of LinkedList as the backing structure provides efficient insertion and removal of elements.
*/
