package org.com.algo.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersbyFreq {
	//güzel bir algoritma
	//bucket kullanılmıştır.
	public static String sortCharacters(String s) {
		
		int n=s.length();
		StringBuilder res=new StringBuilder();
		Map<Character,Integer> map=new HashMap<>();
		
		for(int i=0;i<n;i++) {
			Character ch=s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		//elemanların kaç adet olduğunu sırasına göre chArr listesine ekliyoruz.
		//örneğin a harfinden 5 tane varsa chArr[5]={"a"} şeklinde oluşturuluyor.
		@SuppressWarnings("unchecked")
		List<Character>[] chArr=new List[n+1];
		
		for(char ch:map.keySet()) {
			int num=map.get(ch);
			
			if(chArr[num]==null) {
				chArr[num]=new ArrayList<>();
			}
			chArr[num].add(ch);
		}
		//döngüyü tersten çalıştırdığımız için en fazla elemandan en az elemana doğru elemanları sıralamış oluyoruz.
		for(int i=chArr.length-1;i>=0;i--) {
			if(chArr[i]!=null) {
				List<Character> list=chArr[i];
				for(Character ch:list) {
					int f=map.get(ch);
					while(f>0) {
						res.append(ch);
						f--;
					}
				}
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		String name="Merhaba Dünya";
		System.out.println(sortCharacters(name));

	}

}
