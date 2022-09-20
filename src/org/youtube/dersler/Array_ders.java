package org.youtube.dersler;

import java.util.Scanner;

public class Array_ders {

	public static void main(String[] args) {
		int[] liste= {10,20,30,40,50};
		for(int eleman:liste) {
			System.out.println(eleman);
		}
		int[]liste2=new int[10];
		for(int i=0;i<10;i++) {
			liste2[i]=i*i;
		}
		for(int eleman:liste2) {
			System.out.println(eleman);
		}
		for(int i=0;i<liste2.length;i++) {
			System.out.println("eleman: "+(liste2[i]+5));
		}
		
		Scanner scanner=new Scanner(System.in);
		
		
		int[]liste3=new int[10];
		for(int i=0;i<liste3.length;i++) {
			liste3[i]=scanner.nextInt();
			if(liste3[i]%2==0) {
				System.out.println(liste3[i]);
			}
		}
		scanner.close();
		
	}

}
