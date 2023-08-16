package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("Eager initialization");
        SingletonEagerInitialization eagerInitialization = SingletonEagerInitialization.getInstance();
        SingletonEagerInitialization eagerInitialization1 = SingletonEagerInitialization.getInstance();
        System.out.println(eagerInitialization1);
        System.out.println(eagerInitialization);
        System.out.println();

        System.out.println("Static block initialization");
        SingletonStaticBlock singletonStaticBlock = SingletonStaticBlock.getInstance();
        SingletonStaticBlock singletonStaticBlock1 = SingletonStaticBlock.getInstance();
        System.out.println(singletonStaticBlock1);
        System.out.println(singletonStaticBlock);
        System.out.println();

        System.out.println("Lazy initialization");
        SingletonLazy singletonLazy = SingletonLazy.getInstance();
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        System.out.println(singletonLazy);
        System.out.println(singletonLazy1);
        System.out.println();

        System.out.println("Bill Pugh initialization");
        SingletonBillPugh singletonBillPugh = SingletonBillPugh.getInstance();
        SingletonBillPugh singletonBillPugh1 = SingletonBillPugh.getInstance();
        System.out.println(singletonBillPugh1);
        System.out.println(singletonBillPugh);
        System.out.println();

    }
}
