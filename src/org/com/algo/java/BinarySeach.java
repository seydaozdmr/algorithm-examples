package org.com.algo.java;

import java.util.Arrays;

public class BinarySeach {
	public static int binarySeach(int[]arr,int key) {
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==key) {
				return mid;
			}else if(arr[mid]<key) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int [] arr= {1,2,5,7,2,4,6,7,8,5,34,34};
		Arrays.parallelSort(arr);
		
		System.out.println(binarySeach(arr,4));

	}

}
