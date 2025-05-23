package com.laiszig.myrunnable;

import static java.lang.Integer.valueOf;

public class MySharedObject {

    //static variable pointing to instance of MySharedObject

    public static final MySharedObject sharedInstance = new MySharedObject();

    //member variables pointing to two objects on the heap

    public Integer object2 = valueOf(22);
    public Integer object4 = valueOf(44);

    public long member1 = 12345;
    public long member2 = 67890;
}
