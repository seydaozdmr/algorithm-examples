package algorithms;

import java.util.Arrays;

public class EqualKeys {

	public static int rank(int key,int[]arr) {
		return rank(key,arr,0,arr.length-1);
	}
	
	
	private static int rank(int key, int[] arr, int lo, int hi) {
		if (lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if(key<arr[mid]) {
				System.out.println("lo mid:"+mid);
				return rank(key,arr,lo,mid-1);
			}
			else if(key>arr[mid]) {
				System.out.println("hi mid:"+mid);
				int rightIndex=rank(key,arr,mid+1,hi);
				System.out.println("right:"+rightIndex);
				if(rightIndex==-1) {
					return mid+1;
				}else {
					return rightIndex;
				}
			}else {
				int leftIndex=rank(key,arr,lo,mid-1);
				System.out.println("left:"+leftIndex);
				if(leftIndex==-1) {
					return mid;
				}else {
					return leftIndex;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] array = {1,2,4,4,5,6,6,7,7,7,8,8,8,8,8,8,8,15,10,11,12,14};
		System.out.println(array.length);
		Arrays.sort(array);
		System.out.println(rank(7,array));

	}

}
