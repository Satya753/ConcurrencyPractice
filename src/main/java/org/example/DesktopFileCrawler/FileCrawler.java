package org.example.DesktopFileCrawler;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

public class FileCrawler implements Runnable{
    private final BlockingQueue<File> fileQueue;
    private  final FileFilter fileFilter;
    private  final File root;
    public FileCrawler(BlockingQueue<File> fileQueue , FileFilter fileFilter , File file){
        this.fileFilter = fileFilter;
        this.fileQueue = fileQueue;
        this.root = file;
    }
    @Override
    public void run() {
        try{
            crawl(root);
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
    private void crawl(File root) throws InterruptedException{
        File[] entries = root.listFiles(fileFilter);
        if (entries!=null){
            for (File entry : entries){
                if (entry.isDirectory())
                    crawl(entry);
                else
                    fileQueue.put(entry);

            }

        }
    }
}
