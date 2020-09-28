package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        CountDownLatch countDownLatch = new CountDownLatch(10 + 2);
        new Uploader(semaphore, countDownLatch, 20, 500).start();

        for (int i = 1; i < 11; i++) {
            new Downloader(countDownLatch, semaphore, 100, i).start();

        } try {
            while (countDownLatch.getCount() > 1) {
                Thread.sleep(100);
            }
            Thread.sleep(1000);
            System.out.println("Файл удален с сервера");
            countDownLatch.countDown();
        } catch (InterruptedException i) {

        }
    }
}

