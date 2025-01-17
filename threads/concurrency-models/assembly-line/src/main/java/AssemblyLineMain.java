import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class AssemblyLineMain {

    public static void main(String[] args) throws InterruptedException {

        // Step 1: Create BlockingQueues for each stage
        /**
         * Each Stage has its own input and output BlockingQueue.
         * A stage processes jobs from its input queue, performs a transformation, and passes the result to its output queue.
         */
        BlockingQueue<String> stage1Queue = new LinkedBlockingQueue<>();
        BlockingQueue<String> stage2Queue = new LinkedBlockingQueue<>();
        BlockingQueue<String> stage3Queue = new LinkedBlockingQueue<>();

        // Step 2: Create and name stages
        Stage stage1 = new Stage(stage1Queue, stage2Queue, "Stage 1");
        Stage stage2 = new Stage(stage2Queue, stage3Queue, "Stage 2");
        Stage stage3 = new Stage(stage3Queue, null, "Stage 3");

        // Step 3: Create an ExecutorService to run stages
        /**
         * Each Stage runs on a separate thread or thread pool via the ExecutorService.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(stage1);
        executorService.submit(stage2);
        executorService.submit(stage3);

        // Step 4: Feed jobs into the first queue
        /**
         * Jobs are added to the input queue of the first stage (stage1Queue).
         * Each stage processes jobs and passes the result to the next stage.
         */
        for (int i = 0; i < 10; i++) {
            String job = "Job- " + i;
            System.out.println("Adding to Stage 1: " + job);
            stage1Queue.put(job);
        }

        // Step 5: Add "END" signal to stop the assembly line
        /**
         * The special END signal propagates through the assembly line to terminate each stage gracefully.
         * Each stage forwards the END signal to the next queue.
         */
        stage1Queue.put("END");

        // Step 6: Shutdown ExecutorService after processing
        executorService.shutdown();
    }
}
