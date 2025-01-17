/**
 * Each worker thread continuously fetches a job from the queue using takeJob() and processes it.
 * The takeJob() method blocks if the queue is empty, ensuring that workers only proceed when there’s work available.
 */
public class Worker implements Runnable{

    private final JobQueue jobQueue;


    public Worker(JobQueue jobQueue) {
        this.jobQueue = jobQueue;
    }

    @Override
    public void run() {
        while(true) {
            String job = null;
            try {
                job = jobQueue.takeJob();
                System.out.println(Thread.currentThread().getName() + " processing: " + job);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(Thread.currentThread().getName() + " interrupted");
                break;
            }
        }
    }
}
