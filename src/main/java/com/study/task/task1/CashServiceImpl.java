package com.study.task.task1;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class CashServiceImpl implements CashService {

    private final int UPDATE_CACHE_MAX_REQUESTS = 100;
    private Map<String, String> cache = new HashMap<>(5);
    private AtomicInteger cacheRequestCounter = new AtomicInteger(0);
    private String fileName;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public CashServiceImpl() {
    }

    public CashServiceImpl(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Function get all entries from file.
     * @return - list of entries. Each entry is array of key, value pair.
     * element -> [key, value].
     */
    private List<String[]> readFromFile() {
        String currentLine;
        ArrayList<String[]> entries = new ArrayList<>();
        try(FileReader fr = new FileReader(this.fileName);
            BufferedReader br = new BufferedReader(fr)) {

            while ((currentLine = br.readLine()) != null) {
                String[] keyVal = currentLine.split("-");
                entries.add(keyVal);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return entries;
    }

    @Override
    public String getValue(String key) {
        String value = getValueFromCache(key);
        cacheRequestCounter.incrementAndGet();
        return value;
    }

    /**
     * Method extract value by key from cache.
     * If cache obsolete, cache update
     * @param key - key of key/value pair.
     * @return - value from cache by key.
     */
    private String getValueFromCache(String key) {

        if (cacheRequestCounter.get() == UPDATE_CACHE_MAX_REQUESTS) {
            cacheRequestCounter.set(0);
            List<String[]> entries = readFromFile();
            updateCache(entries);
        }

        if (cacheRequestCounter.get() == 0) {
            List<String[]> entries = readFromFile();
            updateCache(entries);
        }

        return readCache(key);
    }

    /**
     * Update whole cache with new entries.
     * @param entries - new entries for cache.
     *                  entry -> [key, value]
     */
    private void updateCache(List<String[]> entries) {
        try {
            writeLock.tryLock(2, TimeUnit.MINUTES);
            entries.forEach(entry -> cache.put(entry[0], entry[1]));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Method get value by key from cache.
     * @param key - key of entry.
     * @return - value of entry from cache.
     */
    private String readCache(String key) {
        try {
            readLock.tryLock(2, TimeUnit.MINUTES);
            return cache.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            readLock.unlock();
        }
    }
}
