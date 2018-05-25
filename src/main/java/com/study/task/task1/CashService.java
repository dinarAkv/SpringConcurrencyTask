package com.study.task.task1;


public interface CashService {
    /**
     * Method return value from file by key using cache.
     * @param key - key of entry.
     * @return - value of entry.
     */
    String getValue(String key);
}
