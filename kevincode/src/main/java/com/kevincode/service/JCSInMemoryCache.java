package com.kevincode.service;

import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.LRUMap;

import java.util.ArrayList;

/**
 * User: kevin.xie<br/>
 * Date: 10/09/2020<br/>
 * Time: 16:19<br/>
 */
public class JCSInMemoryCache<K, T> {

    private long timeToLive;
    private LRUMap JCSCacheMap;

    protected class JCSCacheObject  {
        public long lastAccessed = System.currentTimeMillis();
        public T value;

        protected JCSCacheObject (T value) {
            this.value = value;
        }
    }

    public JCSInMemoryCache(long JCSTimetoLive, final long JCSTimerInterval, int maxItems) {
        this.timeToLive = JCSTimetoLive * 1000;

        JCSCacheMap = new LRUMap(maxItems);

        if (timeToLive > 0 && JCSTimerInterval  > 0) {

            Thread t = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(JCSTimerInterval * 1000);
                        } catch (InterruptedException ex) {
                        }
                        cleanup();
                    }
                }
            });

            t.setDaemon(true);
            t.start();
        }
    }

    public void put(K key, T value) {
        synchronized (JCSCacheMap) {
            JCSCacheMap.put(key, new JCSCacheObject (value));
        }
    }

    @SuppressWarnings("unchecked")
    public T get(K key) {
        synchronized (JCSCacheMap) {
            JCSCacheObject  c = (JCSCacheObject) JCSCacheMap.get(key);

            if (c == null)
                return null;
            else {
                c.lastAccessed = System.currentTimeMillis();
                return c.value;
            }
        }
    }

    public void remove(K key) {
        synchronized (JCSCacheMap) {
            JCSCacheMap.remove(key);
        }
    }

    public int size() {
        synchronized (JCSCacheMap) {
            return JCSCacheMap.size();
        }
    }

    @SuppressWarnings("unchecked")
    public void cleanup() {

        long now = System.currentTimeMillis();
        ArrayList<K> deleteKey = null;

        synchronized (JCSCacheMap) {
            MapIterator itr = JCSCacheMap.mapIterator();

            deleteKey = new ArrayList<K>((JCSCacheMap.size() / 2) + 1);
            K key = null;
            JCSCacheObject c = null;

            while (itr.hasNext()) {
                key = (K) itr.next();
                c = (JCSCacheObject) itr.getValue();

                if (c != null && (now > (timeToLive + c.lastAccessed))) {
                    deleteKey.add(key);
                }
            }
        }

        for (K key : deleteKey) {
            synchronized (JCSCacheMap ) {
                JCSCacheMap.remove(key);
            }

            Thread.yield();
        }
    }
}
