package org.com.algo.java;

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class FindLengthofLongestIncreasingSubarray {
	public static int findLongestSubarray(int[]arr) {
		int maxLength=0;
		
		int count=1;
		for(int i=1;i<arr.length-1;i++) {
			
			if(arr[i-1]<arr[i]) {
				count++;
			}else {
				count=1;
			}
			
			maxLength=Math.max(maxLength, count);
		}
		return maxLength;
	}
	public static void main(String[] args) {
		int [] arr={1,2,6,0,7};
		System.out.println(findLongestSubarray(arr));
		
		
		
		

	}

}
