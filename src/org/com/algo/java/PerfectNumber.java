package org.com.algo.java;

public class PerfectNumber {
	public static void isPerfect(int x) {
		int toplam=0;
		for(int i=1;i<x;i++) {
			if(x%i==0) {
				toplam+=i;
			}
		}
		if(toplam==x) {
			System.out.println("Perfect Number!");
		}else {
			System.out.println("Not Perfect!");
		}
	}

	public static void main(String[] args) {
		isPerfect(30);

	}

}
