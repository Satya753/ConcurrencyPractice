package org.example.DesktopFileCrawler;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class Indexer implements Runnable{
    private final BlockingQueue<File> queue;
    public Indexer(BlockingQueue<File> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        //    indexFile(queue.take());

    }
}
