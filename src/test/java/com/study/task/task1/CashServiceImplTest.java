package com.study.task.task1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;


public class CashServiceImplTest {

    private final int READ_ITERATIONS = 1000000;
    private final int THREAD_NUMBERS = 100;

    private CashService cashService = new CashServiceImpl("keyVal.txt");
    private Map<String, String> expectedCacheVals = new HashMap<>();
    private AtomicInteger finishedThreadCounter = new AtomicInteger(0);


    /**
     * Method generate random list of key/value pairs, fix them in
     * in {@link #expectedCacheVals} and write in target file.
     */
    private void writeGeneratedWordsInFile() {
        EntrysGenerator entrysGenerator = new EntrysGenerator();
        String[][] entries =
                entrysGenerator.generateAndWriteInFile(5, 30, "keyVal.txt");
        Arrays.stream(entries).forEach(entry -> expectedCacheVals.put(entry[0], entry[1]));
    }


    private void threadTask() {
        Set<String> keySet = expectedCacheVals.keySet();
        int requestCounter = 0;
        while (requestCounter <= READ_ITERATIONS) {
            keySet.forEach(key -> {
                String value = cashService.getValue(key);
                assertEquals(value, expectedCacheVals.get(key));
            });

            requestCounter += keySet.size();
        }
        this.finishedThreadCounter.incrementAndGet();

        System.out.println("end thread." + finishedThreadCounter.get());
        if (finishedThreadCounter.get() == THREAD_NUMBERS) {
            synchronized (this) {
                System.out.println("end all threads.");
                this.notify();
            }
        }

    }

    @Before
    public void prepareToTest() {
        writeGeneratedWordsInFile();
    }

    @Test
    public void testCashService() {
        for (int i = 0; i < THREAD_NUMBERS; i++) {
            new Thread(this::threadTask).start();
        }

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}