package example_5;

/**
 * This ThreadPool class is a simplified implementation of a thread pool.
 * A thread pool is a collection of worker threads that efficiently execute tasks submitted to the pool.
 */
public class ThreadPool {

    private int coreSize; // number of threads in a pool
    private boolean stop = false; // flag signaling the threads to stop processing tasks
    private LinkedBlockingQueues<Runnable> tasks = new LinkedBlockingQueues<>(); // LinkedBlockingQueue acting as the task queue where submitted tasks
                                                                                 // are stored until a worker thread picks them up for execution.
    private Thread[] threads; // An array of thread objects representing the worker threads in the pool

    public ThreadPool(int coreSize) {
        this.coreSize = coreSize;
        threads = new Thread[coreSize]; // initializes the thread array with the specified size
        for (int i = 0; i < coreSize; i++) {
            // creates and starts each worker thread by associating it with a Worker instance
            threads[i] = new Thread(new Worker("thread" + i));
            threads[i].start();
        }
    }

    // Allows tasks (implementations of Runnable) to be submitted to the thread pool.
    public boolean submit(Runnable command) {
        // Adds task to the tasks queue using add() method of LinkedBlockingQueue
        return tasks.add(command); // returns true if successful
    }

    // stops the thread pool
    public void shutdown() {
        stop = true; // set flag to true signaling threads to stop processing tasks
    }

    // Represents a worker thread that continuously picks tasks from the task queue and executes them.
    private class Worker implements Runnable {
        public String name;

        // Initializes the name of the worker thread for identification in the logs.
        public Worker(String name) {
            this.name = name;
        }

        // Continuously fetches and executes tasks from the queue until the stop flag is set to true.
        @Override
        public void run() {
            while(!stop) {
                Runnable command = tasks.take(); // Fetches the next task from the tasks queue using take() - (blocking call, waits if the queue is empty).
                System.out.println(name + " starting to run, start_time " + System.currentTimeMillis()/1000); // Logs the start time of the task
                command.run(); // Executes it using command.run()
                System.out.println(name + " finished, endtime " + System.currentTimeMillis()/1000); // Logs the end time after execution.
            }
        }
    }
    
}

/*
Task Submission:
- Tasks are submitted to the pool using the submit() method, which adds them to the tasks queue.

Thread Execution:
- Each worker thread continuously retrieves tasks from the tasks queue and executes them.

Blocking Queue:
- The LinkedBlockingQueue ensures thread-safe task addition and retrieval.
- The take() method blocks worker threads if the queue is empty, efficiently waiting for new tasks.

Shutdown:
- The shutdown() method sets the stop flag, causing the worker threads to exit their loops once all tasks are completed.

Logging:
- Each worker thread logs its start and end times for task execution, providing visibility into task processing.
*/