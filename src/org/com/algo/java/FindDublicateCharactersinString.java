package org.com.algo.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDublicateCharactersinString {
	//we can use hashmap for finding dublicate characters in String
	
	public static void printDublicate(String str) {
		Map<Character,Integer> map=new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			Character ch=str.charAt(i);
			
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		
		map.forEach((k,v)->{
			if(v>1) {
				System.out.println(k+" harfinden: "+v);
			}
		});
	}
	//Set approach
	public static void printDub(String srt) {
		Set<Character> st=new HashSet<>();
		
		for(int i=0;i<srt.length();i++) {
			Character ct=srt.charAt(i);
			if(st.contains(ct)) {
				System.out.println(ct);
			}else {
				st.add(ct);
			}
		}
	}

	public static void main(String[] args) {
		printDublicate("Uçuşa geçtiki");

	}

}
