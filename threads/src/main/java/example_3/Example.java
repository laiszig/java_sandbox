package example_3;

import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Fatorial implements Callable<Long> {

    private final int number;

    public Fatorial(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        long output = 0;

        try {
            output = factorial(number);
        } catch (InterruptedException e) {
            Logger.getLogger(Example.class.getName())
                    .log(Level.SEVERE, null, e);
        }
        Thread.sleep(3000);
        return output;
    }

    private long factorial(int number) throws InterruptedException {
        if(number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while(number >0) {
            result = result * number;
            number--;
        }
        return result;
    }
}

class Example {
    private static final ExecutorService threadpool =
            Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws
            InterruptedException, ExecutionException {

        Fatorial task = new Fatorial(20);
        System.out.println("Sending task...");
        Future<Long> future = threadpool.submit(task);
        System.out.println("Task is submitted");
        while (!future.isDone()) {
            System.out.println("Task not finished yet...");
            Thread.sleep(500);
        }
        System.out.println("Task finished!");
        long factorial = (long) future.get();
        System.out.println("Factorial of 10 is: " + factorial);
        threadpool.shutdown();
    }
}
