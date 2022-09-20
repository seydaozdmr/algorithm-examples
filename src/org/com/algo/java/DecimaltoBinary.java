package org.com.algo.java;

public class DecimaltoBinary {
	
	public static void decimalToBinary(int num) {
		int []arr=new int[20];
		int count=0;
		
		while(num>0) {
			arr[count]=num%2;
			count++;
			num=num/2;
		}
		for(int i=count-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
		
	}

	public static void main(String[] args) {
		decimalToBinary(13);

	}

}
