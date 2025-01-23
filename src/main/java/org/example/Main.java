package org.example;


import com.sun.net.httpserver.HttpExchange;
import org.example.Model.Request;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        UnsafeCachingFactorizer unsafeCachingFactorizer = new UnsafeCachingFactorizer();

        Thread t1 = new Thread(){

            @Override
            public void run(){
                unsafeCachingFactorizer.makeCall(new Request(new BigInteger(String.valueOf(30))));

            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                unsafeCachingFactorizer.makeCall(new Request(new BigInteger(String.valueOf(50))));
            }

        };
        t1.start();
        t2.start();
        Thread.sleep(1000);

        unsafeCachingFactorizer.getLastFactor();
    }
}