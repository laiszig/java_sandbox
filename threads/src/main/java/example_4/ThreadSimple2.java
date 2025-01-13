package example_4;

public class ThreadSimple2 implements Runnable {

    @Override
    public void run() {
        System.out.println("starting thread 2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("closing thread 2");
    }
}
