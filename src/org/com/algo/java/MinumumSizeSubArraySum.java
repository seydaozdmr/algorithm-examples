package org.com.algo.java;

public class MinumumSizeSubArraySum {
	
	//Güzel algoritma
	//verilen bir dizide k toplamına eşit ya da büyük en küçük kaç elemanlı alt küme bulunabilir.
	public static int minSubArray(int [] arr,int k) {
		int minLength=Integer.MAX_VALUE;
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum=0;
			for(int j=i;j<arr.length;j++) {
				//istenen k toplamına kadar sırasıyla elemanları topluyoruz.
				sum=sum+arr[j];
				if(sum>=k) {
					minLength=Math.min(minLength,(j-i)+1);
					break;
				}
			}
		}
		return (minLength==Integer.MAX_VALUE)?0:minLength;
	}
	
	public static int minSubArrayLength(int[]arr,int k) {
		int start=0;
		int sum=0;
		int minLength=Integer.MAX_VALUE;
		
		for(int end=0;end<arr.length;end++) {
			sum=sum+arr[end];
			while(sum>=k && start<=end) {
				//minimum'u güncelliyoruz.
				minLength=Math.min(minLength, (end-start)+1);
				//ilk baştan eklenen elemanları toplamdan siliyoruz.
				//aslında bu algoritmada mantık sliding window mantığı ile benzer.
				sum=sum-arr[start++];
			}
		}
		return (minLength==Integer.MAX_VALUE)?0:minLength;
	}

	public static void main(String[] args) {
		int[]arr= {7,2,1,1,6,5};
		System.out.println(minSubArrayLength(arr, 11));

	}

}
