package org.com.algo.java;

public class SumElementsRecursion {
	public static int sumRecursion(int[]arr,int n) {
		if(n<=0) {
			return 0;
		}
		//n-1 dizideki son eleman oluyor.
		return sumRecursion(arr,n-1)+arr[n-1];
	}
	
	public static int sumRecursion2(int[]arr,int n) {
		if(n>arr.length-1) {
			return 0;
		}
		return sumRecursion2(arr,n+1)+arr[n];
	}

	public static void main(String[] args) {
		int[]arr= {1,2,3,4,5};
		System.out.println(sumRecursion2(arr, 0));

	}

}
