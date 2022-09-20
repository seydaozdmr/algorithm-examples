package algorithms;

import java.util.Arrays;

public class BinarySearchLevel_1 {

	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		int key=2;
		
		Arrays.sort(arr);
		
		int index=rank(key,arr,0,arr.length-1,0);
		System.out.println();
		System.out.println("Index :"+index);
		
		

	}
	public static int rank(int key,int[] arr,int lo,int hi,int depth) {
		if(depth!=0) {
			System.out.println();
		}
		for(int i=0;i<depth;i++) {
			System.out.println(" ");
		}
		if(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if(key<arr[mid]) {
				return rank(key,arr,lo,mid-1,++depth);
			}else if(key>arr[mid]) {
				return rank(key,arr,mid+1,hi,++depth);
			}else {
				return mid;
			}
		}else {
			return -1;
		}
	}
}
