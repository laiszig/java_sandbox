import java.util.concurrent.BlockingQueue;

public class Stage implements Runnable {

    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;
    private final String stageName;

    public Stage(BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue, String stageName) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
        this.stageName = stageName;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String job = inputQueue.take();
                if (job.equals("END")) {
                    System.out.println(stageName + " received END signal. Stopping...");
                    if (outputQueue != null) {
                        outputQueue.put("END");
                    }
                    break;
                }

                // Process the job
                System.out.println(stageName + " processing: " + job);
                Thread.sleep(3000);
                String processedJob = job + " -> " + stageName;

//                String processedJob = job + " -> Processed by " + stageName;
                if (outputQueue != null) {
                    outputQueue.put(processedJob); // Pass processed job to the next queue
                } else {
                    System.out.println(stageName + " finished final job: " + processedJob);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(stageName + " interrupted");
        }

    }
}
