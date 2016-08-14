package com.mickyli.java.concurrent.semaphore;

public class ThreadA extends Thread{

	private SemaphoreTest1 s1;
	
	public ThreadA(SemaphoreTest1 s1){
		this.s1 = s1;
	}
	
	public void run(){
		s1.synchronism();
	}
}
