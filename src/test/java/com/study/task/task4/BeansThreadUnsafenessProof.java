package com.study.task.task4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*"})
public class BeansThreadUnsafenessProof {

    private final int REQUESTS_NUM_FOR_THREAD = 1000000000;
    private final int THREADS_NUM = 1000;
    private final long EXPECTED_SEQUENCE_VAL = REQUESTS_NUM_FOR_THREAD * THREADS_NUM;
    private AtomicInteger finishedThreadsNum = new AtomicInteger(0);

    @Autowired
    public ThreadUnsafeSequence sequence;

    private void threadTask() {
        int requestsCounter = 0;
        while (requestsCounter < REQUESTS_NUM_FOR_THREAD) {
            sequence.next();
            requestsCounter++;
        }
        System.out.println("end thread: " + finishedThreadsNum.get());
        System.out.println("curval: " + sequence.curval());
        finishedThreadsNum.incrementAndGet();

        if (finishedThreadsNum.get() == THREADS_NUM) {
            synchronized (this) {
                this.notify();
            }
        }
    }

    @Test
    public void testThreadUnsafenessSpringBeans() {
        for (int i = 0; i < THREADS_NUM; i++) {
            new Thread(this::threadTask).start();
        }

        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertTrue(sequence.curval() != EXPECTED_SEQUENCE_VAL);
    }
}
