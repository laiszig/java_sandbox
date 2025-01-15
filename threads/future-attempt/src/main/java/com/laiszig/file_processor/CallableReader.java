package com.laiszig.file_processor;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableReader {

    public BigInteger execute(List<CallableTask> tasks) {

        BigInteger result = BigInteger.ZERO;

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        List<Future<BigInteger>> futures;

        try {
            futures = cachedPool.invokeAll(tasks);
        } catch (InterruptedException e) {
            // exception handling example
            throw new RuntimeException(e);
        }

        for (Future<BigInteger> future : futures) {
            try {
                result = result.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                // exception handling example
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}
