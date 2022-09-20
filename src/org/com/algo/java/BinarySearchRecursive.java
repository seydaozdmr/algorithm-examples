package org.com.algo.java;

import java.util.Arrays;

public class BinarySearchRecursive {
	public static void binarySearch(int []arr,int key,int start,int end) {
		//ilk başta kontrol yapıyoruz. çağıdığımız binarySearch fonksiyonu için eğer başlangıç değeri bitiş değerini 
		//geçmiş ise recursive işlemini bitirir.
		if(start>end) {
			return;
		}
		int mid=(start+end)/2;
		
		if(arr[mid]==key) {
			System.out.println(mid);
			return;
		}else if(arr[mid]<key){
			binarySearch(arr,key,mid+1,end);
		}else {
			binarySearch(arr,key,0,mid-1);
		}
	}

	public static void main(String[] args) {
		int [] arr= {1,23,2,22,11,4,33,21,4,3};
		Arrays.sort(arr);
		binarySearch(arr,3,0,arr.length-1);

	}

}
