package org.com.algo.java;

public class RemoveDublicates {

	public static void main(String[] args) {
		//find dublicates given an array
		int []arr= {1,2,2,3,4,4,5,6,6,7};
		
		int []temp=new int[arr.length];
		
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				temp[j]=arr[i];
				j++;
			}
		}
		temp[j++]=arr[arr.length-1];
		for(int i:temp) {
			System.out.println(i);
		}
	}

}
