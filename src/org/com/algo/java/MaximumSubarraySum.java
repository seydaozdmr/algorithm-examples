package org.com.algo.java;

public class MaximumSubarraySum {
	public static int findMax(int[]arr) {
		int max=arr[0];
		int sum=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(sum<0) {
				sum=arr[i];
			}else {
				sum+=arr[i];
			}
			max=Math.max(sum,max);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
