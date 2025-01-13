package example_5;

import example_4.ThreadSimple;
import example_4.ThreadSimple2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

    public static void main(String[] args) {

//        ThreadPool pool = new ThreadPool(5);
//
//        pool.submit(new ThreadSimple());
//        pool.submit(new ThreadSimple2());

        ExecutorService executorService = Executors.newFixedThreadPool(10); // if no qty, it can grow indefinitely and allocate any number of tasks
        Future<ThreadSimple> future = executorService.submit(ThreadSimple::new);

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<ThreadSimple2> future2 = executor.submit(() -> new ThreadSimple2());
    }
}
