package com.mickyli.java.concurrent.semaphore;

public class ThreadC extends Thread{

	private SemaphoreTest1 s1;
	
	public ThreadC(SemaphoreTest1 s1){
		this.s1 = s1;
	}
	
	public void run(){
		s1.synchronism();
	}
}
