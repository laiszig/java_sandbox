package com.laiszig.myrunnable;

import static java.lang.Integer.valueOf;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        methodOne();
    }

    private void methodOne() {
        int localVariable1 = 45;

        MySharedObject localVariable2 = MySharedObject.sharedInstance;

        //... do more with local variables

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = valueOf(99);

        //... do more with local variables
    }

}
