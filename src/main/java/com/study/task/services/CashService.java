package com.study.task.services;


public interface CashService {

    /**
     * Function return value from file by key using cache.
     * @param key - key of entry.
     * @return - value of entry.
     */
    String getValue(String key);
}
