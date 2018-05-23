package com.study.task.services.task2;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class SequenceServiceImplTest {

    private final int REQUESTS_NUM_FOR_THREAD = 1000;
    private final int THREADS_NUM = 100;
    private final BigInteger EXPECTED_SEQUENCE_VAL =
            new BigInteger(Integer.toString(REQUESTS_NUM_FOR_THREAD * THREADS_NUM));

    private SequenceService sequenceService = new SequenceServiceImpl(0);
    private AtomicInteger finishedThreadsNum = new AtomicInteger(0);


    private void threadTask() {
        int requestsCounter = 0;
        while (requestsCounter < REQUESTS_NUM_FOR_THREAD) {
            sequenceService.next();
            requestsCounter++;
        }

        synchronized (this) {
            this.notify();
        }
    }

    @Before
    public void prepareToTest() {

    }

    @Test
    public void testSequenceService() {
        new Thread(this::threadTask).start();

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("end");
    }
}