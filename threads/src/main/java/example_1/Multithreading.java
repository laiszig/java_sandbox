package example_1;

//public class Multithreading extends Thread{
public class Multithreading implements Runnable{

    private final int threadNumber;
    public Multithreading(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " from thread " + threadNumber);
//            if (threadNumber == 3) {          // Other threads won't stop - even if it's the main thread
//                throw new RuntimeException();
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
