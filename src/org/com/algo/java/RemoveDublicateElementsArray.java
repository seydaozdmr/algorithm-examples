package org.com.algo.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class RemoveDublicateElementsArray {
	//1.approach sort elements then traverse array so we could compare if elements dublicate
	
	public static void remove1(int[]arr) {
		//sort
		Arrays.parallelSort(arr);
		//for adding variable
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			//eğer dizinin sıradaki elemanı bir sonraki eleman ile aynı değilse bu durumda dizinin sıradaki kısmına bu elemanı ekle
			if(arr[i]!=arr[i+1]) {
				arr[j++]=arr[i];
			}
		}
		//sıraya sonuncu lemanı ekle
		arr[j++]=arr[arr.length-1];
		
		for(int i=0;i<j;i++) {
			System.out.println(arr[i]);
		}
	}
	
	//2.approach using hashmap. count elements and adding for value. we print key values for not showing dublicates
	
	public static void remove2(int[]arr) {
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i],1);
			}
		}
		
		map.forEach((k,v)->{
			System.out.println(k);
		});
		
	}

	public static void main(String[] args) {
		int[]arr= {5,1,2,6,4,4,5};
		remove1(arr);
		

	}

}
