package org.com.algo.java;

import java.util.Scanner;
//reverse an array by recursive
public class ReverseRecursive {
	
	public static void reverse(int[]arr,int start,int end) {
		if(start>=end) {
			return;
		}
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		reverse(arr, start+1, end-1);
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Give size of array");
		int n=sc.nextInt();
		
		int[]arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=(int)(Math.random()*10);
			//System.out.println(arr[i]);
		}
		
		for(int i:arr) {
			System.out.print(i+" -> ");
		}
		System.out.println("");
		reverse(arr,0,arr.length-1);
		
		for(int i:arr) {
			System.out.print(i+ " -> ");
		}
		sc.close();
	}

}
