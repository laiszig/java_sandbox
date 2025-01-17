### Parallel Workers Concurrency Model
#### How It Works
- ParallelWorkersMain creates the shared JobQueue and starts a single Producer thread.
- It then starts a fixed number of worker threads via an ExecutorService.
- The Producer adds jobs to the queue, and workers fetch and process them.
- After the producer finishes, the system shuts down the workers gracefully.