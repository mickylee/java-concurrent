package com.mickyli.java.concurrent.api.semaphore;

public class Run {

	public static void main(String[] args) {
		
		SemaphoreTest1 s1 = new SemaphoreTest1(1);
		//SemaphoreTest1 s1 = new SemaphoreTest1(2);
		
		ThreadA a = new ThreadA(s1);
		a.setName("A");
		ThreadB b = new ThreadB(s1);
		b.setName("B");
		ThreadC c = new ThreadC(s1);
		c.setName("C");
		
		a.start();
		b.start();
		c.start();
	}

}
