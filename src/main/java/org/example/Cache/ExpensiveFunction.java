package org.example.Cache;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String , BigInteger> {
    @Override
    public BigInteger compute(String arg) {
       try{
           System.out.println("Doing computation by thread "  + Thread.currentThread().getName());
           Thread.sleep(100000);
       }
       catch (Exception e){
           System.out.println(e);
       }
       return BigInteger.ONE;
    }
}
