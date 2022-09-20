package org.com.algo.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {
	public static int[] twoSum(int []arr,int key) {
		//1.HashMap'i oluşturuyoruz
		Map<Integer,Integer> map=new HashMap<>();
		//2.HashMap'in içerisinde Key olarak değerleri Value olarak index numaralarını ekliyorum
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], i);
		}
		
		for(int i=0;i<arr.length;i++) {
			//3.aradığımız toplam değerini oluşturabilmek için sıradaki değerle HashMap içerisindeki değeri aramak
			//için numToFind değişkenini oluşturuyoruz.
			int numToFind=key-arr[i];
			//4.toplamları aradığımız değere eşit olan ikilileri bulmaya çalışıyoruz.
			if(map.containsKey(numToFind) && map.get(numToFind)!=i) {
				return new int[] {i,map.get(numToFind)};
			}
			
		}
		throw new IllegalArgumentException("Aradığınız toplam çifti bulunamadı.");
	}

	public static void main(String[] args) {
		int[]arr= {2,7,11,15};
		int target=18;
		
		System.out.println("HashMap yöntemi ile: "+Arrays.toString(twoSum(arr,target)));

	}

}
