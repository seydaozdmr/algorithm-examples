package org.com.algo.java;

public class CalculatePowerofNumber {
	
	public static int calculatePower(int sayi,int p) {
		int toplam=1;
		while(p>0) {
			toplam=toplam*sayi;
			p--;
		}
		return toplam;
	}
	public static void main(String[] args) {
		System.out.println(calculatePower(2,3));
	}

}
