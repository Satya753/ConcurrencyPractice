package org.example;

import org.example.Model.Request;
import org.example.Model.Response;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class UnsafeCachingFactorizer {
    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();
    /*
    why this is not a thread safe

     */

    public Response makeCall(Request request){
        BigInteger i = request.getNum();
        Response response = new Response();
        if (lastNumber.equals(i)){
            response.setFactors(lastFactors);

        }
        else{
            // over here 2 threads might be acessing having 2 different integers while the first may set lastNumber and other thread
            // might set lastfactors
            /*

            this has to be done on single atomic transaction
             */
            AtomicReference<BigInteger[] > factors = computeFactors(request.getNum());
            lastNumber.set(request.getNum());
            lastFactors.set(factors.get());
            response.setFactors(factors);
        }
        return  response;

    }

    public AtomicReference<BigInteger[]> computeFactors(BigInteger integer){
        AtomicReference<BigInteger[]> factors = new AtomicReference<>(
                IntStream.range(1, integer.intValue())
                        .filter(i -> integer.intValue() % i == 0)
                        .mapToObj(BigInteger::valueOf)
                        .toArray(BigInteger[]::new)
        );
        return  factors;
    }
    public void getLastFactor(){
        System.out.println(lastNumber.get());
        for (BigInteger bigInteger : lastFactors.get()){
            System.out.println(bigInteger.toString(10));
        }
    }
}
