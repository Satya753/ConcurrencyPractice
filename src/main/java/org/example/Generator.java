package org.example;



public class Generator {
    private int nextValue;
    public Generator(){
        this.nextValue = 0;
    }
    public synchronized int getNext(){
        return nextValue++;
    }

    public int getNextValue(){
        return this.nextValue;
    }
}

