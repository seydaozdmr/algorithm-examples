package org.com.algo.java;

import java.util.HashMap;
import java.util.Map;

public class FindFrequencyinString {

	public static void main(String[] args) {
		String name="Seyda Özdemir";
		
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<name.length();i++) {
			if(map.containsKey(name.charAt(i))) {
				map.put(name.charAt(i), map.get(name.charAt(i))+1);
			}else {
				map.put(name.charAt(i), 1);
			}
		}
		System.out.println(map);
		map.forEach((k,v)->{
			System.out.println(k + "-> "+v);
		});

	}

}
