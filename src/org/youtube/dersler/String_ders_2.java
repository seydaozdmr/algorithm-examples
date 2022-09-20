package org.youtube.dersler;

import java.util.ArrayList;

public class String_ders_2 {

	public static void main(String[] args) {
		String cumle="aaabbbcccddddfffffeeeee";
		ArrayList<String>liste=new ArrayList<>();
		
		int say=0;
		
		for(int i=0;i<cumle.length();i++) {
			if(i!=0 && cumle.charAt(i)!=cumle.charAt(i-1)) {
				liste.add(cumle.substring(say,i));
				say=i;
				//System.out.println(i);
			}else if((i+1)==cumle.length()) {
				liste.add(cumle.substring(say,i+1));
			}
		}
		System.out.println(liste);
	}

}
