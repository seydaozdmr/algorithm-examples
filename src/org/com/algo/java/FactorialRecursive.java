package org.com.algo.java;

import java.util.Scanner;

public class FactorialRecursive {
	public static int facto(int n) {
		//recursive i durduran koşul ifadesi. fonksiyonunn her çağırılışında işlem yapmadan önce koşulu kontrol etmesi gerekir.
		if(n==0) {
			return 1;
		}else {
			return n*facto(n-1);
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("number of factorial?");
		int n=in.nextInt();
		
		System.out.println(facto(n));
		in.close();

	}

}
