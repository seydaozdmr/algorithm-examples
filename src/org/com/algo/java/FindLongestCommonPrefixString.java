package org.com.algo.java;

public class FindLongestCommonPrefixString {
	//Güzel algoritma
	public static String findPrefix(String[]strs) {
		if(strs==null || strs.length==0) {
			return "";
		}
		
		String lcp=strs[0];
		for(int i=1;i<strs.length;i++) {
			String current=strs[i];
			int j=0;
			System.out.println("lcp:"+lcp.length());
			System.out.println("current:"+current.length());
			while(j<current.length() && j<lcp.length() && current.charAt(j)==lcp.charAt(j)) {
				
				j++;
			}
			if(j==0) {
				return "";
			}
			System.out.println(j);
			//0'dan j'ye kadar olan kısım en uzun ortak ön ek oluyor.
			//lcp her defasında bulduğu ön eki kendini eşitliyor. bu da her zaman en küçük ortak ön eki bulmasını sağlıyor.
			lcp=current.substring(0,j);
		}
		return lcp;
	}

	public static void main(String[] args) {
		String[]liste= {"cata","cataering","catblue"};
		System.out.println(findPrefix(liste));

	}

}
