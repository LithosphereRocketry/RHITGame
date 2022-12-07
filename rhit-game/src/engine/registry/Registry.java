package com.cleotroph.oldroads.engine.registry;

import com.cleotroph.oldroads.engine.log.LOGGING;

import java.util.HashMap;

public class Registry<K, T> {
    boolean finalized = false;
    HashMap<K, T> entries;
    public Registry(){
        entries = new HashMap<K, T>();
    }
    public void lock(){
        finalized = true;
        LOGGING.logI("Registry<"+", "+">", "Registered " + entries.size() + " items.");
    }
    public void register(T entry, K id){
        if(!finalized){
            entries.put(id, entry);
        }else{
            // TODO: Throw illegal modification exception
            //throw new Exception();
            LOGGING.logE("Registry","illegalModification");
            System.exit(1);
        }
    }
    public T get(K id){
        return entries.get(id);
    }
}
