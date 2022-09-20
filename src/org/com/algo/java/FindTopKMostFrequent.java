package org.com.algo.java;

import java.util.*;

public class FindTopKMostFrequent {
	//Bu alıştırmada bir dizide k sayısından farklı sayıda bulunan elemanları bulmaya çalışıyoruz.
	//Bu yaklaşım bana ait.26.05.2020
	//int tipinde dizi döndürecek şekilde çözebilirim
	//ya da List<Integer> interface kullanarak ArrayList Döndürebilirim.
	//en sık görülen 2 eleman ya da en sık görülen 3 eleman
	public static int[] kMost(int[]arr,int k) {
		if(arr.length==1 && k==1) {
			return new int[] {1};
		}
		int[] temp=new int[arr.length];
		Set<Integer> mySet=new HashSet<>();
		int count=1;
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i-1]==arr[i]) {
				count++;
			}
			
//			if(count>=k && arr[i]!=temp[i-1]) {
//				temp[i-1]=arr[i];
//				count=1;
//			}
			if(count>=k){
				mySet.add(arr[i]);
				count=1;
			}

			if(arr[i-1]!=arr[i]) {
				count=1;
			}
		}
		int c=0;
		for(int e:mySet)
			temp[c++]=e;
		return Arrays.copyOf(temp,mySet.size());
	}
	public static int[] kMost3(int[]arr,int k) {
		Map<Integer,Integer> myMap=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			myMap.merge(arr[i],1,Integer::sum);
		}
		int[] elems=new int[k];
		List<Integer> integers=new ArrayList<>();
		for(Integer integer:myMap.values()){
			integers.add(integer);
		}
		Collections.sort(integers);
		Collections.reverse(integers);
		for(int i=0;i<k;i++){
			int elem=integers.get(i);
			for(Integer e:myMap.keySet()){
				if(myMap.get(e)==elem){
					elems[i]=e;
					myMap.remove(e);
					break;
				}
			}
		}
		return elems;
	}

	
	public static List<Integer> kMost2(int []arr,int k){
		List<Integer> liste=new ArrayList<>();
		int j=1;
		int count=1;
		for(int i=0;i<arr.length-1;i++) {
			
			if(arr[i]==arr[i+1]) {
				count++;
			}
			
			if(count>=k && !liste.contains(arr[i])) {
				liste.add(arr[i]);
				j=j+1;
				count=0;
			}
			if(arr[i]!=arr[i+1]) {
				count=0;
			}
		}
		return liste;
	}

	public static void main(String[] args) {
		int[]arr= {1,2};
		int[]result=kMost(arr,2);
		int [] result2= kMost3(arr,2);
		for(int i:result) {
			if(i!=0) {
				System.out.println(i);
			}
		}
		
		List<Integer>sonuc=kMost2(arr, 3);
		sonuc.forEach(elem->{
			//System.out.println(elem);
		});

	}

}
