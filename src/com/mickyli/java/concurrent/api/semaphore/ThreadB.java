package com.mickyli.java.concurrent.semaphore;

public class ThreadB extends Thread{

	private SemaphoreTest1 s1;
	
	public ThreadB(SemaphoreTest1 s1){
		this.s1 = s1;
	}
	
	public void run(){
		s1.synchronism();
	}
}
