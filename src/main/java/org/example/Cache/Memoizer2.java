package org.example.Cache;

import java.util.HashMap;
import java.util.Map;

public class Memoizer2 <A , V > implements  Computable<A , V > {
    private final Map< A , V> cache = new HashMap<>();
    private final Computable<A , V> c;
    public Memoizer2(Computable<A , V> c){
        this.c = c;
    }
    @Override
    public synchronized V compute(A arg) throws Exception {
        if (!cache.containsKey(arg))
            cache.put(arg  , c.compute(arg));
        return cache.get(arg);

    }
}
