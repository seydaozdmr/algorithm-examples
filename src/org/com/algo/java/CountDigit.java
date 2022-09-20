package org.com.algo.java;

public class CountDigit {
	public static int count(int num) {
		if(num==0) {
			return 0;
		}
		return 1+count(num/10);
	}

	public static void main(String[] args) {
		System.out.println(count(12345));

	}

}
