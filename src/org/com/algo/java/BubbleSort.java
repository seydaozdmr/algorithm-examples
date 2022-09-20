package org.com.algo.java;

public class BubbleSort {

	public static void main(String[] args) {
		int[]arr= {2,4,6,1,3,8,5,10,3};
				//listenin son hali   	iterasyon yapılmayacaklar 
				// 2,4,1,3,6,5,8,3,10  	10
				// 2,1,3,4,5,6,3,8,10	8,10							
				// 1,2,3,4,5,3,6,8,10	6,8,10
				// 1,2,3,4,3,5,6,8,10	5,6,8,10
				// 1,2,3,3,4,5,6,8,10	4,5,6,8,10
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			System.out.println((i+1)+". iterasyon:");
			for(int x:arr) {
				System.out.print(x+"-> ");
			}
			System.out.println();
		}
		System.out.println("****SONUÇ*****");
		for(int i:arr) {
			System.out.print(i+"-> ");
		}

	}

}
