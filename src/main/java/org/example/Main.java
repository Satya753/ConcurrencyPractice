package org.example;


import com.sun.net.httpserver.HttpExchange;
import com.sun.source.tree.SynchronizedTree;
import org.example.Model.Request;

import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.SynchronousQueue;

public class Main {
    private static int number;
    private static  boolean ready;
    private static class ReaderThread extends Thread{
        @Override
        public void run(){
            while(!ready)
                    Thread.yield();
            System.out.println(number);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String , Integer> mp = new ConcurrentHashMap<>();
        UnsafeCachingFactorizer unsafeCachingFactorizer = new UnsafeCachingFactorizer();

        /*
        Thread t1 = new Thread(){

            @Override
            public void run(){
                while(!ready)
                    Thread.yield();
                System.out.println(number);

            }
        };

        new ReaderThread().start();
        number = 42;
        ready = true;
        *
         */
        ImproperPublication improperPublication = new ImproperPublication();
        improperPublication.run();



    }
}