package org.example.Model;

import java.math.BigInteger;

public class Request {
    public BigInteger num;
    private String requestId;

    public Request(BigInteger num){
        this.num = num;
    }

    public BigInteger getNum() {
        return num;
    }

    public void setNum(BigInteger num) {
        this.num = num;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
