package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Uploader extends Thread {
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;
    private int speed = 20;
    private int file = 500;

    public Uploader(Semaphore semaphore, CountDownLatch countDownLatch, int speed, int file) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.speed = speed;
        this.file = file;
    }
    public void run() {
        try {
            System.out.println("Загрузка файла на сервер");
            sleep(500/speed);
        } catch (InterruptedException e){

        }
        countDownLatch.countDown();
    }

}
