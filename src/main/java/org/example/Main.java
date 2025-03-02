package org.example;


import com.sun.net.httpserver.HttpExchange;
import com.sun.source.tree.SynchronizedTree;
import org.example.Model.Request;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        ImproperPublication improperPublication = new ImproperPublication();
        improperPublication.run();

         */


        /*
        Chapter - 4
        Compound action
        Causing out of bound exception .
        1.Take client side locking
        2.


        List< String > list = new ArrayList<>(List.of("A" , "B" , "C" , "D"));
        CompounAction compounAction = new CompounAction();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                try {
                    synchronized (list) {
                        System.out.println(compounAction.getLast(list));
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };


         */
        Thread t2 = new Thread(){
            @Override
            public void run(){
                System.out.println("Executed this consumer");
            }
        };

      //  t2.start();
        //t1.start();
        /*

        Set< Integer > st = new HashSet<>();
        String t = new String();

        for (int i = 0 ;i < 10 ; i++){
            st.add(i);
        }
        System.out.println("This is concurrent exception " + st);
        SynchronousQueue queue = new SynchronousQueue();
        queue.offer(t2);
        System.out.println(queue.size());
        Thread first = (Thread)queue.poll();
        first.start();
        */
        /*

        Testing latches countdown latches
         */

        /*
        CountDownLatches countDownLatches = new CountDownLatches(10);
        countDownLatches.start(10 , new Task());
        *

         */

        PreLoader preLoader = new PreLoader();
        preLoader.start();
        System.out.println(preLoader.get().getProductId());

    }
}