package org.com.algo.java;

public class SumofDigitNumbers {

	public static void main(String[] args) {
		int number=1988;
		
		int toplam=0;
		
		while(number>0) {
			toplam=toplam+number%10;
			number=number/10;
		}
		System.out.println(toplam);
	}

}
