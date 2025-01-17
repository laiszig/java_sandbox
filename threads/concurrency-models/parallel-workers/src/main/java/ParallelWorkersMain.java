import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelWorkersMain {

    public static void main(String[] args) throws InterruptedException {

        // Step 1: Create the shared job queue
        JobQueue jobQueue = new JobQueue();

        // Step 2: Create the producer
        Producer producer = new Producer(jobQueue);

        // Step 3: Create worker threads
        int numberOfWorkers = 4;
        /**
         * ExecutorService manages a pool of worker threads that will process jobs in parallel.
         * Executors.newFixedThreadPool(int n) creates a thread pool with a fixed number of threads.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfWorkers);
        /**
         * We submit worker tasks to the ExecutorService. These tasks will run in parallel, pulling jobs from the queue.
         */
        for (int i = 0; i < numberOfWorkers; i++) {
            executorService.submit(new Worker(jobQueue));
        }

        // Step 4: Start the producer in a separate thread
        Thread producerThread = new Thread(producer);
        producerThread.start();

        // Wait for producer to finish
        producerThread.join();

        // Step 5: Shutdown workers gracefully
        /**
         * After the producer finishes adding jobs, the ExecutorService is shut down.
         * shutdownNow() interrupts all running threads and signals them to stop.
         * awaitTermination() waits for the threads to complete within a timeout period, ensuring a clean shutdown.
         */
        executorService.shutdown(); //Interrupt worker threads
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("All workers stopped.");
    }
}
