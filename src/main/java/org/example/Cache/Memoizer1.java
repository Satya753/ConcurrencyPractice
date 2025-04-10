package org.example.Cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class Memoizer1 <A , V> implements  Computable<A , V>{
    private final Map< A ,  Future<V> > cache = new ConcurrentHashMap<>();
    private final Computable<A , V> c;
    public Memoizer1(Computable<A , V> c){
        this.c = c;
    }
    @Override
    public  V compute(A arg) throws Exception {
        while(true){
            Future< V > f = (Future<V>) cache.get(arg);

            if (f==null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                       return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.put(arg , ft);
                if (f==null)
                {
                    f = ft;
                    ft.run();
                }
            }
            try{
                return f.get();
            }catch (CancellationException | InterruptedException e){
                cache.remove(arg , f);
            }catch (ExecutionException e){
                throw  new Exception("exception occured");
            }
        }
    }
}
