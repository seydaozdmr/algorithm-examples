package org.com.algo.java;

import java.util.Arrays;

public class MaxSubArraySizeofK {
	//güzel bir algoritma
	public static int brutalForce(int[]arr,int k) {
		//ilk olarak maximum toplamı tutan değişken
		int max=0;
		//daha sonra iki tane iç içer döngü
		//dıştaki döngü k elemanından önceki sayı kadar geriden bitmelidir.
		for(int i=0;i<arr.length-k;i++) {
			//her defasında toplam sıfırlanır
			int sum=0;
			//j: i'den başlamak üzere i+k(istenen alt dizi miktarı) sayısına kadar dönüyor.
			//i=0 ve k=3 olduğunu düşünürsek. j,0 dan başlamak üzere 3'e kadar olan sayıları toplar
			for(int j=i;j<i+k;j++) {
				sum+=arr[j];
			}
			//daha sonra max belirlenir.
			max=Math.max(sum,max);
		}
		return max;
	}
	
	public static int getSum(int[]arr,int k) {
		int start=0;
		int sum=0;
		int max=0;
		
		for(int i=0;i<arr.length;i++) {
			//sırasıyla elemanları toplamaya başlarız
			sum=sum+arr[i];
			//k. değerden sonra aşağıdaki if koşulu çalışmaya başlar.
			if(i>=k-1) {
				//k. sayıya geldiğimizde maximum toplam değerini buluruz.
				max=Math.max(sum, max);
				//ilk baştaki sayıyı toplamdan çıkarırırz.
				sum=sum-arr[start];
				start++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[]arr= {2,1,5,1,3,2};
		Arrays.sort(arr);
		System.out.println(brutalForce(arr, 3));
		System.out.println(getSum(arr, 3));
	}

}
