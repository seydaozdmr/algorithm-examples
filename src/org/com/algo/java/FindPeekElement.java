package org.com.algo.java;

public class FindPeekElement {
	
	public static int findPeek(int[]arr) {
		int peek=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>peek) {
				peek=arr[i];
			}
		}
		return peek;
	}
	
	public static int findPeek2(int []arr) {
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]>arr[i+1]) {
				return arr[i];
			}
		}
		return arr[arr.length-1];
	}
	
	public static int findPeek3(int []arr) {
		int n=arr.length;
		int start=0;
		int end=n-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			if((mid==0 || arr[mid-1]<=arr[mid]) && (mid==n-1 || arr[mid]>=arr[mid+1])) {
				return arr[mid];
				
			}else if(mid>0 && arr[mid-1]>arr[mid]) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return -1;
	}
	

	public static void main(String[] args) {
		int[]arr= {8,7,6,5,4,1,9};
		System.out.println(findPeek(arr));
		System.out.println(findPeek2(arr));
		System.out.println(findPeek3(arr));
	}

}
