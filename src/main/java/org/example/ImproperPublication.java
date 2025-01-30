package org.example;


import org.example.Model.Holder;

public class ImproperPublication implements  Runnable{
    public static  Holder holder ;
    public void initialize() throws InterruptedException {
        holder = new Holder(12);
    }
    @Override
    public void run() {

            Thread initialize = new Thread(){
                @Override
                public void  run(){
                    try {
                        initialize();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };

        Thread t1 = new Thread(){
            @Override
            public void run(){
                holder.assertSanityCheck();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                holder.assertSanityCheck();
            }
        };
        initialize.start();
        t1.start();
        t2.start();

    }
}
