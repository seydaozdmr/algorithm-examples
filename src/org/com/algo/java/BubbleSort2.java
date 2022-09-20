package org.com.algo.java;

public class BubbleSort2 {
	public static void bubbleSort1(int[]arr) {
		for(int i=0;i<arr.length-1;i++) {
			//ilk iterasyon tüm dizi bitene kadar tekrar ediyor
			//i=0 olduğu için
			//j dizi bütün diziyi geziyor ve baştan sona kadar sırasıyla elemanları kontrol ediyor
			//sırasıyla küçük elemanlar büyük elemanı yer değiştiriyor.
			//i'nin sayısı arttıkça j'nin gezdiği eleman sayısı azalıyor çünkü gezdiği elemanların büyük olanını sona doğru taşıyor 
			//tekrar kontrol etmesine gerek kalmıyor.
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	//n dizinin boyutu olmak üzere recursion olarak bubble sort uygulaması..
	public static void bubbleSort2(int[]arr,int n) {
		if(n==1) {
			return;
		}
		for(int i=0;i<n-1;i++) {
			if(arr[i]>arr[i+i]) {
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		bubbleSort2(arr, n-1);
	}

	public static void main(String[] args) {
		int[]arr= {22,1,43,54,3};
		bubbleSort1(arr);
		for(int i:arr) {
			System.out.println(i);
		}

	}

}
