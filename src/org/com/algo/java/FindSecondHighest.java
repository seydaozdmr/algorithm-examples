package org.com.algo.java;

public class FindSecondHighest {
	
	public static int FindSecond(int[]arr) {
		int highest=Integer.MIN_VALUE;
		int secondhighest=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>highest) {
				secondhighest=highest;
				highest=arr[i];
			}
			if(arr[i]!=highest && arr[i]>secondhighest) {
				secondhighest=arr[i];
			}
		}
		return secondhighest;
	}

	public static void main(String[] args) {
		int[]arr= {1,2,3,4,7,5};
		System.out.println(FindSecond(arr));

	}

}
