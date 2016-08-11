package com.mickyli.java.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号
 * 控制线程的数量
 * @author liqian
 *
 */
public class SemaphoreTest1 {
	
	//构造函数，许可,代表同一时间内允许最多几个线程运行acquire()和release()之间的代码
	private Semaphore semaphore = new Semaphore(1);
	
	//同步性，串行执行任务
	public void synchronism(){
		try {
			semaphore.acquire();
			
			System.out.println(Thread.currentThread().getName() + " begin Timer: " + System.currentTimeMillis());
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " end Timer: " + System.currentTimeMillis());
			
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
