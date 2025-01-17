/**
 * The producer creates jobs (Job-1, Job-2, ...) and puts them into the queue using put().
 * The put() method blocks if the queue is full, ensuring proper flow control.
 */
public class Producer implements Runnable{

    private final JobQueue jobQueue;

    public Producer(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String job = "Job-" + i;
            System.out.println("Produced created: " + job);
            try {
                jobQueue.addJob(job);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Producer interrupted");
            }
        }
    }
}
