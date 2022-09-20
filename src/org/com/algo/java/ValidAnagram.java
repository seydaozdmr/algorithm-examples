package org.com.algo.java;

import java.util.Arrays;

public class ValidAnagram {
	public static boolean isAnagram(String a,String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		
		char[] ca=a.toCharArray();
		char[] ba=b.toCharArray();
		
		Arrays.parallelSort(ca);
		Arrays.parallelSort(ba);
		//iki karakter dizisi birbirine eşit mi
		return Arrays.equals(ba, ca);
	}
	
	public static boolean isAnagram2(String str1,String str2) {
		if(str1.length()!=str2.length()) {
			return false;
		}
		//alfabede 29 harf olduğu için 29 int alabilen bir dizi oluşturuyorum.
		int[] contarr=new int[29];
		for(int i=0;i<str1.length();i++) {
			//ilk karakter olan a'yı çıkardığımızda aslında yukarıdaki contarr dizimizin alfabedeki harflerin yerini gösteren
			//sayılara karşılık gelen değerleri bulmuş oluyoruz.
			contarr[str1.charAt(i)-'a']++;
			//önce ekliyoruz sonra çıkarıyoruz. örneğin str1=bat str2=tab önce b'nin sırasını 1 arttırıyoruz sonra t'nin sırasını bir azaltıyoruz.
			contarr[str2.charAt(i)-'a']--;
			//böylece bir denklik kurmaya çalışıyoruz.
		}
		
		for(int j=0;j<contarr.length;j++) {
			//eğer contarr'nin sırasıyla içindeki değerler 0'a eşit değilse denklik yoktur bu iki String dizisinin farklı karakterler tuttuğu anlamına gelir
			if(contarr[j]!=0) {
				return false;
			}
		}
		//eğer denklik varsa anagram olduğunu gösterir
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
