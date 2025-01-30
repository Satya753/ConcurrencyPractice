package org.example;


import com.sun.net.httpserver.HttpExchange;
import org.example.Model.Request;

import java.math.BigInteger;

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