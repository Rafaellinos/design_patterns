package org.example;

public class SingletonStaticBlock {

    private static SingletonStaticBlock instance;

    static {
        try {
            instance = new SingletonStaticBlock();
        } catch (Exception e) {
            System.out.println("Some exception occurred, here's what we got" + e.getMessage());
        }
    }

    private SingletonStaticBlock() {
    }

    public static SingletonStaticBlock getInstance() {
        return instance;
    }
}
