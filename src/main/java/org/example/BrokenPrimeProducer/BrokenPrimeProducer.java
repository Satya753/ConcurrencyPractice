package org.example.BrokenPrimeProducer;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimeProducer extends Thread{
    private final BlockingQueue<BigInteger> queue;
    private volatile boolean cancelled = false;

    public BrokenPrimeProducer(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }
    public void run(){
        try{
            BigInteger p = BigInteger.ONE;
            while(!cancelled){
                queue.put(p = p.nextProbablePrime());
            }
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
    public void cancel(){
        cancelled = true;
    }
}
