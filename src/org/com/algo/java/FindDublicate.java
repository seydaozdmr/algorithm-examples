package org.com.algo.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindDublicate {
	//1. approach brutal force
	public static void dub(int []arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println(arr [i]);
					break;
				}
			}
		}
	
	}
	//2. Hashmap K,V olarak elemanların bulunma sayısını hesaplıyoruz. Daha sonra 1'den fazla değeri olan keyleri yazdırıyoruz.
	public static void dub2(int []arr) {
		HashMap<Integer,Integer>map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			//mep içerisinde sıradaki arr[i] elemanı key olarak bulunuyor mu?
			if(map.containsKey(arr[i])) {
				//eğer varsa onun karşılığındaki value değerini 1 arttırıyoruz.
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				//yoksa Hashmap'te key olarak atıyoruz ve karşısına gelen değeri de 1 olarak atıyoruz.
				map.put(arr[i], 1);
			}
		}
		//Hashmap içerisinde foreach ile iterasyon gerçekleştiriyoruz.
		map.forEach((k,v)->{
			if(v>1) {
				System.out.println(k);
			}
		});
		/*
		 * another alternative using set:
		 * Set<Map.Entry<Integer,Integer>> entry = map.entrySet();
		 * for(Map.Entry<Integer,Integer> ent.entry){
		 * 		if(ent.getValue()>1){
		 * 			System.out.println(ent.getKey());
		 * }			
		 * }
		 */
	}
	
	//3. Approach using Set
	
	public static void dub3(int[]arr) {
		Set<Integer> arrSet=new HashSet<>();
		for(int i:arr) {
			if(arrSet.add(i)==false) {
				System.out.println(i);
			}
		}
	}
	
	

	public static void main(String[] args) {
		int[]arr= {2,5,3,1,8,7,5,3};
		dub(arr);
		dub2(arr);
		dub3(arr);
	}

}
