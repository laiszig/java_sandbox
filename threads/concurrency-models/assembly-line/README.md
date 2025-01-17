## Assembly Line
#### AKA Event-Driven System
#### AKA Reactive System
This implementation simulates an assembly line where each step is a separate stage in processing. 
Each stage uses its own BlockingQueue to hold intermediate results, and a thread or thread pool processes jobs from one queue and passes them to the next queue.

Each stage has:
- An input BlockingQueue (where jobs come from).
- An output BlockingQueue (where processed jobs go).
- A Worker that processes jobs and passes them to the next stage.

- AssemblyLineMain: Orchestrates the assembly line, setting up stages, connecting queues, and starting the workers.

### Advantages of This Implementation
- Scalability: Additional stages can be added easily by chaining queues.
- Separation of Concerns: Each stage processes independently, adhering to the single-responsibility principle.
- Flexibility: The implementation can be extended for distributed systems by replacing queues with message brokers like JMS or RabbitMQ if needed.