package org.example;

public class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("Executing a thread");
    }
}
