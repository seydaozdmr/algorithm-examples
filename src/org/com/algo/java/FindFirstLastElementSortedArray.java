package org.com.algo.java;

public class FindFirstLastElementSortedArray {
	
	public static int findFirst(int arr[],int target) {
		int start=0;
		int end=arr.length-1;
		int index=-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==target) {
				index=mid;
				end=mid-1;
			}else if(arr[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return index;
	}
	
	public static int findLast(int arr[],int target) {
		int start=0;
		int end=arr.length-1;
		int index=-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==target) {
				index=mid;
				start=mid+1;
			}else if(arr[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
