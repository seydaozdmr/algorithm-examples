package org.com.algo.java;

import java.util.Arrays;

public class FindPairstoGivenanArray {
	public static int[] findPairs(int []arr ,int key) {
		int start=0;
		int end=arr.length-1;
		int[]liste=new int[arr.length];
		int j=0;
		while(start<end) {
			if(arr[start]+arr[end]>key) {
				end--;
			}else if(arr[start]+arr[end]<key) {
				start++;
			}else if(arr[start]+arr[end]==key) {
				System.out.println(arr[start]+" "+arr[end]);
				start++;
				end--;
			}
		}
		return liste;
	}

	public static void main(String[] args) {
		int[]arr= {1,2,3,4,5,6,7};
		int[]liste=findPairs(arr,9);
		Arrays.stream(liste).forEach(System.out::println);

	}

}
