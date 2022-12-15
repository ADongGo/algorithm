package com.adong.base.blockingQueue;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author beiting
 * @Description BlockingQueueDemo
 * @Date 2022-12-14 5:23 PM
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        new Thread(() -> {
            try {
                while(true) {
                    queue.produce(UUID.randomUUID().toString());
                    System.out.println("produce finish");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
        new Thread(() -> {
            try {
                while(true) {
                    System.out.println("consume " + queue.consume());
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }).start();
        Thread.currentThread().join();
    }
}
