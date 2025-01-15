package com.laiszig.returnvaluesafter.runnable;

public class RunnableExample implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello");
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new RunnableExample());
        thread.start();
        thread.join();
    }
}