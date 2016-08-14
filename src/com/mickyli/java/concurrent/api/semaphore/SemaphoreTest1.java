package com.mickyli.java.concurrent.api.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 控制线程的数量
 * @author liqian
 *
 */
public class SemaphoreTest1 {
	
	private Semaphore semaphore;
	
	/**
	 * 构造函数
	 * 代表同一时间内允许最多permits个线程运行acquire()和release()之间的代码
	 * @param permits 许可,非负整数
	 */
	public SemaphoreTest1(int permits){
		semaphore = new Semaphore(permits);
	}
	
	//同步性，串行执行任务
	public void synchronism(){
		try {
			//获取许可
			semaphore.acquire();
			
			System.out.println(Thread.currentThread().getName() + " begin Timer: " + System.currentTimeMillis());
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName() + " end Timer: " + System.currentTimeMillis());
			
			//释放许可
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
