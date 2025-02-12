package org.example;

import java.util.concurrent.CountDownLatch;

public class CountDownLatches {
    private CountDownLatch endGate ;
    private CountDownLatch startGate;
    public CountDownLatches(int n){
        this.endGate  = new CountDownLatch(n);
        this.startGate = new CountDownLatch(1);
    }

    public void start(int nThreads , final  Runnable task) throws InterruptedException {

        for (int i = 0 ;i < nThreads ; i++){
            Thread t1 = new Thread(){
                @Override
                public void run(){
                    try {
                        startGate.await();
                        try{
                            task.run();
                        }
                        finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            t1.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}
