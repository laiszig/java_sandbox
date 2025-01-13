package example_1;

public class Main {

    public static void main(String[] args) {

//        Multithreading task1 = new Multithreading();
//        Multithreading task2 = new Multithreading();

//        task1.run(); doesn't start a new thread

//        task1.start();
//        task2.start();

        for (int i = 0; i < 5; i++) {
            Multithreading myThing = new Multithreading(i);
            Thread myThread = new Thread(myThing);
            myThread.start();
        }
    }
}
