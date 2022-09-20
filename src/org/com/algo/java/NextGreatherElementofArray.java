package org.com.algo.java;

import java.util.Stack;

public class NextGreatherElementofArray {
/*
 * Array={3,4,10,5,14,1}
 * 3=>4 (next greater element of 3 is 4
 * 4=>10
 * 10=>14
 * 5=>14
 * 14=>null
 * 1=>null
 */
	//this approach's time complexity is O(n^2)
	public static void nextGreather(int[]arr) {
		int greater;
		for(int i=0;i<arr.length;i++) {
			greater=-1;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					greater=arr[j];
					break;
				}
			}
			System.out.println("Next greater element of "+arr[i]+" is "+greater);
		}
	}
	
	//stack approach
	
	public static void nextGreater(int []arr) {
		Stack<Integer> st=new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			if(st.isEmpty()) {
				st.push(arr[i]);
			}else {
				if(st.peek()<arr[i]) {
					int n=st.pop();
					System.out.println(n+"=>"+arr[i]);
					st.push(arr[i]);
				}else {
					st.push(arr[i]);
				}
			}
		}
	}
	
	public static void nextGreater2(int []arr) {
		Stack<Integer> st=new Stack<>();
		//pushing the first element in stack
		st.push(arr[0]);
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>st.peek()) {
				int n=st.pop();
				System.out.println("next greater element of"+n+" is "+arr[i]);
				while(n<arr[i] && !st.isEmpty()) {
					n=st.pop();
					System.out.println("next greater element of"+n+" is "+arr[i]);
				}
				st.push(arr[i]);
				
			}else {
				st.push(arr[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		int []arr={3,4,10,5,14,1};
		nextGreather(arr);
		System.out.println();
		nextGreater(arr);
		System.out.println();
		nextGreater2(arr);
	}

}
