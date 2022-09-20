package algorithms.hindi;

import algorithms.StdOut;

public class SearchFirstElement {
	
	public static int binarySearchIterative(int [] arr,int key) {
		int lo=0;
		int hi=arr.length;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			
			if(arr[mid]<key) {
				lo=mid+1;
			}else if(arr[mid]>key ||(mid>0 && arr[mid-1]==key)) {
				hi=mid-1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	public static int binarySearch(int [] arr,int key,int lo,int hi) {
		if(lo>hi) {
			return -1;
		}
		
		int mid=lo+(hi-lo)/2;
		if(arr[mid]<key) {
			return binarySearch(arr,key,mid+1,hi);
		}else if(arr[mid]>key) {
			return binarySearch(arr,key,lo,mid-1);
		}else {
			int possibleSmall=binarySearch(arr,key,lo,mid-1);
			if(possibleSmall==-1) {
				return mid;
			}else {
				return possibleSmall;
			}
		}
		
	}

	public static void main(String[] args) {
		 int[] testArray1 = {3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21};
		 
		 StdOut.println("Binary search: " + binarySearchIterative(testArray1, 20) +
	                " Expected: 1");

	}

}
