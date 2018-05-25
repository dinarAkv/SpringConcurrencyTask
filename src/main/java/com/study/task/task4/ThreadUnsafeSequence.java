package com.study.task.task4;

public class ThreadUnsafeSequence {

    private long counter;

    public ThreadUnsafeSequence(long counter) {
        this.counter = counter;
    }

    public long next() {
        counter++;
        return counter;
    }

    public long curval() {
        return  counter;
    }
}
