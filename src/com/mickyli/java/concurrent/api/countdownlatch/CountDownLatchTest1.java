package com.mickyli.java.concurrent.api.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 extends Thread{
	/** 
     * CountDownLatch 是并发包中提供的一个可用于控制多个线程同时开始某个动作的类，其 
     * 采用的方式为减计数的方式，当计数减至零时位于latch.await()后的代码才会被执行。 
     */  
    private static CountDownLatch latch = new CountDownLatch(10);  
  
    public static void main(String[] args) {  
        long start = System.currentTimeMillis();  
        int i = 0;  
        while (i < 10) {  
            i++;  
            new CountDownLatchTest1().start();  
        }  
        try {  
            latch.await();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("use time:" + (System.currentTimeMillis() - start));  
    }  
  
    public void run() {  
        System.out.println("...");  
        try {  
            Thread.sleep(100);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        latch.countDown();  
    }  
}
