package example_4;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ThreadSimple());
        Thread thread2 = new Thread(new ThreadSimple2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Process finished");
    }
}
