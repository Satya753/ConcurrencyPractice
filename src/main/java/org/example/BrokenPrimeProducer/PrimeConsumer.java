package org.example.BrokenPrimeProducer;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeConsumer extends Thread{
    private BlockingQueue<BigInteger> primes;

    public PrimeConsumer(BlockingQueue<BigInteger> primes){
        this.primes = primes;
    }
    public boolean needMorePrime(){

        return true;
    }
    public void consumer(BigInteger bigInteger){
        System.out.println(bigInteger.toString());
    }
    public void consumerPrimes() throws InterruptedException{
        BrokenPrimeProducer brokenPrimeProducer = new BrokenPrimeProducer(this.primes);
        brokenPrimeProducer.start();
        try{
            while(needMorePrime()){
                consumer(this.primes.take());
            }

        }finally {
            brokenPrimeProducer.cancel();
        }
    }
}
