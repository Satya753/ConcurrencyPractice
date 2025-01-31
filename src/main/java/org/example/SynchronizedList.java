package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedList <T>{
    ///  the below is not a thread safe implementation as inside the putifabasent the operations are independent of each other
    /// while 2 objects can read and write at the same time
    public List< T> list = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean putIfAbsent(T x){
        boolean absent = !list.contains(x);
        if (absent)
            list.add(x);
        return absent;

    }
    // client side locking implemented for thread safety
    public boolean putIfAbsentClientLocking(T x){
        synchronized (list){
            boolean absent = !list.contains(x);
            if (absent)
                list.add(x);
            return absent;
        }
    }
}
