package org.com.algo.java;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringwithoutRepeat {
	//Güzel algoritma
	//Bir String dizisi içerisinde tekrar etmeyen karakterlerden oluşan en büyük alt dizinin uzunluğunu bulan algoritma
	public static int lengthOfLongest(String s) {
		int maxCount=0;
		int i=0;
		int j=0;
		int strLen=s.length();
		
		Set<Character> st=new HashSet<>();
		while(i<strLen && j<strLen) {
			if(!st.contains(s.charAt(j))) {
				st.add(s.charAt(j));
				j++;
				maxCount=Math.max(maxCount, j-i);
			}else {
				st.remove(s.charAt(i));
				i++;
			}
		}
		return maxCount;
	}
	

	public static void main(String[] args) {
		System.out.println(lengthOfLongest("asaeaydaaeds"));

	}

}
