package example_3;

import java.util.Random;
import java.util.concurrent.*;

// classe que implementa a interface Callable e retorna um numero aleatorio
class TesteCallableInterface implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random rand = new Random();
        Thread.sleep(3000);
        return rand.nextInt(100);
    }
}

class Main {

    private static final ExecutorService threadpool =
            Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException,
            ExecutionException {
        TesteCallableInterface task = new TesteCallableInterface();
        System.out.println("Processing task ...");
        Future<Integer> future = threadpool.submit(task);
        while (!future.isDone()) {
            System.out.println("Task still not processed!");
            Thread.sleep(500); // sleep for 500 millisecond before checking again
        }
        System.out.println("Task complete!");
        long factorial = (long) future.get();
        System.out.println("Generated number: " + factorial);
        threadpool.shutdown();
    }
}
