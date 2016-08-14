package com.mickyli.java.concurrent.api.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CycliBarrierTest1 extends Thread{
	/** 
     * CyclicBarrier和CountDownLatch不同，CyclicBarrier是当await 的数量达到了设置的数量后， 
     * 才继续往下执行 
     */  
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);  
    private int id;  
  
    public CycliBarrierTest1(int id) {  
        this.id = id;  
    }  
  
    public static void main(String[] args) {  
        long start = System.currentTimeMillis();  
        int i = 0;  
        while (i < 10) {  
            i++;  
            new CycliBarrierTest1(i).start();  
        }  
        System.out.println("use time:" + (System.currentTimeMillis() - start));  
    }  
  
    public void run() {  
        try {  
            System.out.println("----start:" + id);  
            cyclicBarrier.await(1000, TimeUnit.MILLISECONDS);  
            System.out.println("----start__:" + id);  
        } catch (InterruptedException e1) {  
            e1.printStackTrace();  
        } catch (BrokenBarrierException e) {  
            e.printStackTrace();  
        } catch (TimeoutException e) {  
            e.printStackTrace();  
        }  
        try {  
            Thread.sleep(100);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("----end:" + id);  
    }  
}
