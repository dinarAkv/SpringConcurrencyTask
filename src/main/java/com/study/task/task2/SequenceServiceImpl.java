package com.study.task.task2;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SequenceServiceImpl implements SequenceService {

    private AtomicReference<BigInteger> sequence;

    public SequenceServiceImpl(BigInteger initialValue) {
        this.sequence = new AtomicReference<>(initialValue);
    }

    public SequenceServiceImpl(int initialValue) {
        String value = Integer.toString(initialValue);
        this.sequence = new AtomicReference<>(new BigInteger(value));
    }

    public SequenceServiceImpl(long initialValue) {
        String value = Long.toString(initialValue);
        this.sequence = new AtomicReference<>(new BigInteger(value));
    }

    public SequenceServiceImpl(String initialValue) {
        this.sequence = new AtomicReference<>(new BigInteger(initialValue));
    }

    @Override
    public BigInteger next() {
        synchronized (SequenceServiceImpl.class) {
            BigInteger currentVal = sequence.get();
            BigInteger incrementedVal = currentVal.add(BigInteger.ONE);
            sequence.set(incrementedVal);
            return incrementedVal;
        }
    }

    @Override
    public BigInteger curval() {
        return sequence.get();
    }
}
