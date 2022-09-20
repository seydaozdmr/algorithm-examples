package org.com.algo.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTripletswithZeroSum_3Sum {
	//Toplamları 0 olan 3'lüler
	public static List<List<Integer>> findTriplets(int[]arr){
		List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			int start=i+1;
			int end=arr.length-1;
			//sıradaki eleman bir önceki ile aynı mı kontrol ediyoruz.
			if(i>0 && arr[i]==arr[i-1]) {
				continue;
			}
			
			while(start<end) {
				//sondan düşündüğümüzde sıradaki eleman ondan sonraki ile aynı mı eğer aynı ise sıradaki elemanı bir azaltıyoruz.
				if(end<arr.length-1 && arr[end]==arr[end+1]) {
					end--;
					continue;
				}
				
				if(arr[i] +arr[start] + arr[end]==0) {
					//eğer üç elemanın toplamı sıfırı veriyorsa bu elemanlardan oluşan bir liste yaratıp result'a ekliyoruz.
					List<Integer> val=Arrays.asList(arr[i],arr[start],arr[end]);
					result.add(val);
					start++;
					end--;
				}else if(arr[i]+arr[start]+arr[end]<0) {
					start++;
				}else {
					end--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[]arr= {-1,0,1,2,-1,-4,3,5,2,1,3,-6,-1,-3,-4,-5};
		List<List<Integer>> liste=findTriplets(arr);
		
		liste.forEach(values->{
			System.out.println(values);
		});

	}

}
