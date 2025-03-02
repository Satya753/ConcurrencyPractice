package org.example;

import org.example.Model.ProductInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class PreLoader {
    // prelooading the data
    private final FutureTask<ProductInfo> future = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        @Override
        public ProductInfo call() throws Exception {

            // load from the database;
            Thread.sleep(100);
            ProductInfo productInfo = new ProductInfo("A"  , "1");
            return productInfo;
        }
    });

    private  final Thread thread = new Thread(future);
    public void start(){
        thread.start();
    }

    public ProductInfo get(){
        try{
            return future.get();
        }catch (Exception e){
            System.out.println("Unexpected behavious");
        }
        return null;
    }
}
