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

    }
}
