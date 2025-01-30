package org.example.Model;

import java.math.BigInteger;

public class SafeResponse {
    private BigInteger[] factors;
    private String requestId;

    public SafeResponse(BigInteger[] factors) {
        this.factors = factors;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public BigInteger[] getFactors() {
        return factors;
    }

    public void setFactors(BigInteger[] factors) {
        this.factors = factors;
    }
}
