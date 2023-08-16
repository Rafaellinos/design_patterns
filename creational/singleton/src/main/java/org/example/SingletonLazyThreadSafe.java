package org.example;

public class SingletonLazyThreadSafe {

    private static SingletonLazyThreadSafe instance;

    private SingletonLazyThreadSafe() {

    }

    private static SingletonLazyThreadSafe getInstance() {
        synchronized (SingletonLazyThreadSafe.class) {
            if (instance == null) {
                System.out.println("some processing thread safe");
                instance = new SingletonLazyThreadSafe();
            }
        }
        return instance;
    }
}
