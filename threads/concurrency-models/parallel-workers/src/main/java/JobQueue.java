import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A BlockingQueue is a thread-safe queue that supports operations like put() (adds elements, blocks if full)
 * and take() (removes elements, blocks if empty).
 * This acts as the shared resource between the producer and workers.
 */
public class JobQueue {

    private final BlockingQueue<String> queue;

    public JobQueue() {
        this.queue = new LinkedBlockingQueue<>();
    }

    public void addJob(String job) throws InterruptedException {
         queue.put(job);
    }

    public String takeJob() throws InterruptedException {
        return queue.take();
    }
}
