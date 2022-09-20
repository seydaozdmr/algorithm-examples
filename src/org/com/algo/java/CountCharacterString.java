package org.com.algo.java;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterString {
	public static void countCharacter(String kelime) {
		Map<Character,Integer> map=new HashMap<>();
		
		for(Character i:kelime.toCharArray()) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i,1);
			}
		}
		System.out.println(map);
	
	}

	public static void main(String[] args) {
		String name="seyda";
		countCharacter(name);

	}

}
