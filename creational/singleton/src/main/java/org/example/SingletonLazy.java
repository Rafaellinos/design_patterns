package org.example;

public class SingletonLazy {

    private SingletonLazy() {
    }

    private static SingletonLazy singletonLazy;

    public static SingletonLazy getInstance() {
        if (singletonLazy == null) {
            // some process involving the creation
            System.out.println("Executing some process");
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
