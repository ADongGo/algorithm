package com.adong.base.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author beiting
 * @Description ArrayBlockingQueue
 * @Date 2022-12-14 4:24 PM
 */
public class ArrayBlockingQueue<E> {

    private final int captial;

    private final Object[] items;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition notNull;

    private final Condition notEmpty;

    private int putIndex;

    private int takeIndex;

    private int count;

    public ArrayBlockingQueue(int captial) {
        this.captial = captial;
        this.notNull = lock.newCondition();
        this.notEmpty = lock.newCondition();
        this.items = new Object[captial];
    }

    public void produce(E e) throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while(count == captial)
                notEmpty.await();
            put(e);
        } finally {
            lock.unlock();
        }
    }

    public E consume() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            while(count == 0)
                notNull.await();
            return take();
        } finally {
            lock.unlock();
        }
    }

    private void put(E e) {
        if(putIndex == captial)
            putIndex = 0;
        items[putIndex++] = e;
        count++;
        notNull.signal();
    }

    private E take() {
        if(takeIndex == captial)
            takeIndex = 0;
        count--;
        notEmpty.signal();
        return (E) items[takeIndex++];
    }

}
