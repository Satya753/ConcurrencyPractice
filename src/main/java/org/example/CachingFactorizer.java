package org.example;

import org.example.Model.Request;
import org.example.Model.SafeResponse;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class CachingFactorizer {

    private volatile int hits;
    private BigInteger lastnum;
    private BigInteger[]  lastFactors;
    public SafeResponse getFactors(Request request){

        if (request.getNum().equals(lastnum)){
            synchronized (this){
                hits++;
            }
            return new SafeResponse(lastFactors);
        }
        else{
            lastFactors = computeFactors(request.getNum());
            synchronized (this){
                lastnum = request.getNum();
                lastFactors = computeFactors(request.getNum());
            }
            return new SafeResponse(lastFactors);
        }
        
    }

    public BigInteger[] computeFactors(BigInteger num){
        BigInteger[] factors = IntStream.range(1 , num.intValue()).filter(i->num.intValue()%i==0).mapToObj(BigInteger::valueOf).toArray(BigInteger[]::new);
        return factors;
    }
}
