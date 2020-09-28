package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    private CountDownLatch countDownLatch;
    private Semaphore semaphore;
    private int speed = 100;
    private int downloaderNum;

    public Downloader(CountDownLatch countDownLatch, Semaphore semaphore, int speed, int downloaderNum) {
        this.countDownLatch = countDownLatch;
        this.semaphore = semaphore;
        this.speed = speed;
        this.downloaderNum = downloaderNum;
    }

    public void run(){
        try {
            semaphore.acquire();
            System.out.println(downloaderNum+" начал скачивание файла");
            sleep(3000);
            System.out.println(downloaderNum+" завершил скачивание файла");
            semaphore.release();
            countDownLatch.countDown();
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
