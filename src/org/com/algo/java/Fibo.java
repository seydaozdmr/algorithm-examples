package org.com.algo.java;

import java.util.Scanner;

public class Fibo {

	public static void main(String[] args) {
		int a=0;
		int b=1;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("kaç tane fibonachi dizisi oluşturmak istiyorsunuz?");
		int n=sc.nextInt();
		
		System.out.print(n+" fibonachi serisi: "+a+" "+b+" ");
		int temp=0;
		for(int i=2;i<n;i++) {
			temp=a+b;
			System.out.print(temp+" ");
			a=b;
			b=temp;
		}
		
		sc.close();

	}

}
