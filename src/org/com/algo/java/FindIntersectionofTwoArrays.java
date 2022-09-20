package org.com.algo.java;

import java.util.HashSet;

public class FindIntersectionofTwoArrays {
	
	//find intersection of two arrays
	//1.approach time complexcity O(nm)
	public static void findIntersec(int[]arr1,int[]arr2) {
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j])
					System.out.println(arr1[i]);
			}
		}
	}
	public static void findIntersec2(int []arr1,int[]arr2) {
		int i=0;
		int j=0;
		
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				i++;
			}else if(arr1[i]>arr2[j]) {
				j++;
			}else {
				System.out.println(arr1[i]);
				i++;
				j++;
			}
		}
	}
	
	public static void findIntersec3(int[]arr1,int[]arr2) {
		HashSet<Integer> set1=new HashSet<>();
		
		for(int i:arr1) {
			set1.add(i);
		}
		for(int i:arr2) {
			if(set1.contains(i)) {
				System.out.println(i);
			}
		}
	}
	
	
	

	public static void main(String[] args) {
		int [] arr1= {2,3,6,7,9,11};
		int [] arr2= {4,6,8,9,12};
		
		findIntersec2(arr1,arr2);
		findIntersec3(arr1,arr2);
	}

}
