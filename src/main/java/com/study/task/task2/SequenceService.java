package com.study.task.task2;

import java.math.BigInteger;

public interface SequenceService {
    /**
     * Return next value and increment sequence.
     * @return - next value.
     */
    BigInteger next();

    /**
     * Return current value of sequence.
     * @return - current value of sequence.
     */
    BigInteger curval();
}
