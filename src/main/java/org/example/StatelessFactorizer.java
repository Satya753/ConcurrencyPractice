package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.Request;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class StatelessFactorizer implements HttpHandler {


    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // this is stateless as there are no fields and doesn't excess other variables /state from other parts of the program
        InputStream inputStream = exchange.getRequestBody();
        Integer t = computeFactors(23);


    }
    private int computeFactors(int n){
        int res = 0;
        for (int i = 1 ; i*i < n ; i++){
            if (n%i==0)
                res =res + n/i + i;
        }
        return res;
    }
}
