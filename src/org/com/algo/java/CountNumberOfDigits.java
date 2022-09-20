package org.com.algo.java;

public class CountNumberOfDigits {
	public static int count(int number) {
		int c=0;
		while(number>0) {
			number=number/10;
			c++;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(count(1234));

	}

}
