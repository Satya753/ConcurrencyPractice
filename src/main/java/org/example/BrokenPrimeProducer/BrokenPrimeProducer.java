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
                // when the queue get's filled up the producer will be in blocked state and it will never get out of the put state
                // so this case will not work when consumer call the cancel function
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
