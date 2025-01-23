package org.example.Model;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Response {
    private String userId;
    private AtomicReference<BigInteger[]> factors;

    public Response(){
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFactors(AtomicReference<BigInteger[]> factors) {
        this.factors = factors;
    }
}
