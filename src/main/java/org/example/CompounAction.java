package org.example;

import java.util.List;

public class CompounAction {
    // this causes out of bound exception
    // if synchronized not used

    public   String getLast(List< String > list) throws InterruptedException {
        int idx = list.size() - 1;
        System.out.println(list.size());
        Thread.sleep(1000);
        System.out.println(idx  + "-- " + list.size());
        return list.get(idx);
    }

    public   String removeLast(List < String > list) throws InterruptedException {
        int idx = list.size() - 1;
        System.out.println(idx  + " " + list.size());
        String t = list.remove(idx);
        return t;
    }
}
