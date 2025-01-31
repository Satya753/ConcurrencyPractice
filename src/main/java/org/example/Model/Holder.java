package org.example.Model;

public class Holder {
    private int n;
    public Holder(int n) throws InterruptedException {
        Thread.sleep(10);
        this.n = n;

    }
    public void assertSanityCheck(){
        if (n!=n)
            throw new AssertionError("This statement is false");
    }
}
