package com.kf.learning.program.chapter14;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;

import org.junit.Test;

public class Entry {
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	public static final double MAX_AMOUNT = 1000;
	public static final int DELAY = 10;

	@Test
	public void tran() {
		Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < NACCOUNTS; i++) {
			int fromAcount = i;
			Runnable r = () -> {
				try {
					while (true) {
						int toAccount = (int) (bank.size() * Math.random());
						double amount = MAX_AMOUNT * Math.random();
						bank.transfer(fromAcount, toAccount, amount);
						Thread.sleep((int) (DELAY * Math.random()));

					}
				} catch (InterruptedException e) {
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
	}

	@Test
	public void learningAtomic() {
		LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x += y, 0);
		Runnable r = () -> {
			try {
				for (int i = 0; i < 10; i++) {
//					longAccumulator.accumulate(i);
//					System.out.println(Thread.currentThread() + ":" + longAccumulator.get());
					System.out.println(1);
					Thread.sleep(100);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		Thread t1 = new Thread(r);
		t1.start();
//		Thread t2 = new Thread(r);
//		t2.start();
//		Thread t3 = new Thread(r);
//		t3.start();
	}

	@Test
	public void learningThreadLocal() {
		ThreadLocal<StringBuilder> localString = ThreadLocal.withInitial(StringBuilder::new);
		Runnable r = () -> {
			for (int i = 0; i < 10; i++) {
				localString.get().append(Thread.currentThread() + " " + i);
			}
			System.out.println(localString.get().toString());
		};
		Thread t1 = new Thread(r);
		t1.start();
		Thread t2 = new Thread(r);
		t2.start();
		Thread t3 = new Thread(r);
		t3.start();
	}
	
	public void learningAtomicInteger() {
		AtomicInteger aint=new AtomicInteger();
		
	}
}
