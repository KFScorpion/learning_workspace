package com.kf.learning.program.chapter2;

import org.junit.Test;

public class Learning {
	@Test
	public void learning_1() {
		String greeting = "welcome to Core Java";
		System.out.println(greeting);
		for (int i = 0; i < greeting.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}
