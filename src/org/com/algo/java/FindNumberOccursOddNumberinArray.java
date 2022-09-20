package org.com.algo.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindNumberOccursOddNumberinArray {
	//bir dizi içerisindeki elemanlardan hangileri tek sayı kadar bulunur.
	//1.approach we traverse all array and count the elements, then if it occurs odd times we add an arrayList
	public static void findOccurOdd(int[]arr) {
		List<Integer>liste=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			int count=0;
			for(int j=0;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
			}
			if(count%2!=0) {
				if(!liste.contains(arr[i])) {
					liste.add(arr[i]);
				}
			}
		}
		System.out.println(liste);
	}
	
	//2.approach we creat a map and travers an array, then add elements to map, so map shows which element how many times occurs
	
	public static void findOccurOdd2(int[]arr) {
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		
		map.forEach((k,v)->{
			if(v%2!=0) {
				System.out.println(k);
			}
		});
		
		/*
		 * Another getting method:
		 * for(Map.Entry<Integer,Integer> i: map.entrySet()){
		 * 	if(i.getValue()%2!=0){
		 * 		System.out.println(i.getKey());
		 * 	}
		 * }
		 */
	}
	
	public static void main(String[] args) {
		int []arr= {8,3,6,4,5,6,4,3,5,2,4,4,2,2};
		findOccurOdd(arr);
		findOccurOdd2(arr);

	}

}
