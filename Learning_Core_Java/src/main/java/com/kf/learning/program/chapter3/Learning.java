package com.kf.learning.program.chapter3;

import java.math.BigInteger;

import org.junit.Test;

public class Learning {
	@Test
	public void learning_break() {
		Integer count_1 = 0;
		Integer count_2 = 0;
		while (true) {
			count_1++;
			break;
		}
		System.out.println("count_1:" + count_1);

		// break_this:
		// {
		// break break_this;
		// }

		break_this: while (count_2 < 10) {
			count_2++;
			System.out.println("count_2:" + count_2);
			while (count_2 < 5) {
				count_2 += 2;
				if (count_2 > 5) {
					System.err.println("count_2:" + count_2);
					break break_this;
				}
				System.out.println("count_2:" + count_2);
			}
			if (count_2 > 5) {
				break;
			}
		}
	}
	@Test
	public void bigIntegerTest() {
		BigInteger lotteryOdds= BigInteger.valueOf(1);
		for(int i=1;i<100;i++) {
			lotteryOdds=lotteryOdds.multiply(BigInteger.valueOf((100-i)+1)).divide(BigInteger.valueOf(i));
		}
		System.out.println(lotteryOdds);
	}
}
