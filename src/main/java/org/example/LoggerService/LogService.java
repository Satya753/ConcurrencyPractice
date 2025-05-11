package org.example.LoggerService;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class LogService {
    private final BlockingQueue<String> queue;
    private final LoggerThread loggerThread;
    private final PrintWriter printWriter;
    private boolean isShudown;
    private int reservations;

    public LogService(BlockingQueue<String> queue, LoggerThread loggerThread, PrintWriter printWriter) {
        this.queue = queue;
        this.loggerThread = loggerThread;
        this.printWriter = printWriter;
        this.reservations = 0;
    }

    public void start(){
        loggerThread.start();
    }
    public void stop(){
        synchronized (this){
           isShudown = true;
        }
        loggerThread.interrupt();
    }

    public void log(String msg) throws InterruptedException{
        synchronized (this){
            if (isShudown)
                throw new IllegalStateException();
            ++reservations;
        }
        queue.put(msg);
    }
    public class LoggerThread extends Thread{
        public void run(){
            try{
                while (true){
                    try{
                        synchronized (this){
                            if (isShudown && reservations==0)
                                    break;
                        }
                    String msg = queue.take();
                    synchronized (this){
                        reservations--;
                    }
                    printWriter.println(msg);
                } catch(Exception e){

                }

            }

        } finally {
                printWriter.close();
            }
          }
    }
}
