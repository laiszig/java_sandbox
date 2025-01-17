# Java Concurrency Models

This repository demonstrates three different concurrency models implemented in Java. Each model implementation is self-contained and showcases a specific approach to handling concurrent tasks, with detailed examples and explanations.

Concurrency in Java allows multiple threads to run simultaneously, enabling efficient use of CPU resources and improving application performance. This repository contains three examples illustrating different concurrency paradigms:
- **Parallel Workers**: Basic producer-consumer pattern using a `BlockingQueue` and `ExecutorService`.
- **Assembly Line**: Jobs move through multiple stages, each handled by separate threads.
- **Functional Parallelism**: Tasks are split and processed using the `ForkJoinPool`.

## Implemented Concurrency Models

### 1. Parallel Workers
- **Description**: A producer creates jobs that are stored in a `BlockingQueue`, and multiple consumer threads (managed by an `ExecutorService`) process these jobs in parallel.
- **Key Features**:
  - Utilizes `BlockingQueue` for thread-safe communication between producer and consumers.
  - Demonstrates the use of `ExecutorService` for managing worker threads.

---

### 2. Assembly Line
- **Description**: A multi-stage pipeline where jobs are processed sequentially through multiple stages. Each stage is backed by a `BlockingQueue` and an `ExecutorService`.
- **Key Features**:
  - Each stage represents a step in the job-processing pipeline.
  - Jobs pass from one stage to the next, simulating an assembly line workflow.

---

### 3. Functional Parallelism
- **Description**: Uses `ForkJoinPool` to recursively split a task into smaller subtasks, process them in parallel, and combine the results.
- **Key Features**:
  - Demonstrates the divide-and-conquer paradigm.
  - Suitable for tasks like summation, searching, and data processing on large datasets.
