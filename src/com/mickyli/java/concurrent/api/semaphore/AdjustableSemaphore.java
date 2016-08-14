package com.mickyli.java.concurrent.api.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 动态增加减少信号量
 * @author liqian
 *
 */
public class AdjustableSemaphore {
	private final ResizeableSemaphore semaphore = new ResizeableSemaphore();

	private int maxPermits = 0;

	public AdjustableSemaphore() {

	}

	synchronized void setMaxPermits(int newMax) {

		if (newMax < 1) {

			throw new IllegalArgumentException(
					"Semaphore size must be at least 1," + " was " + newMax);
		}

		int delta = newMax - this.maxPermits;
		
		if (delta == 0) {
			return;
		} else if (delta > 0) {
			this.semaphore.release(delta);
		} else {
			delta *= -1;
			this.semaphore.reducePermits(delta);
		}

		this.maxPermits = newMax;

	}

	public int availablePermits() {
		return this.semaphore.availablePermits();
	}

	public void release() {
		this.semaphore.release();
	}

	public boolean tryAcquire() {
		return this.semaphore.tryAcquire();
	}

	private static final class ResizeableSemaphore extends Semaphore {
		ResizeableSemaphore() {
			super(0);
		}

		@Override
		protected void reducePermits(int reduction) {
			super.reducePermits(reduction);
		}

	}
}
