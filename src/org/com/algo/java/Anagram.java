package org.com.algo.java;

import java.util.Arrays;

public class Anagram {
	//1.approach making char arrays then compare each other.
	public static boolean isAnagram(String a,String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		char[] a1= a.toCharArray();
		char[] b1= b.toCharArray();
		Arrays.parallelSort(a1);
		Arrays.parallelSort(b1);
		for(int i=0;i<a1.length;i++) {
			if(a1[i]!=b1[i]) {
				return false;
			}
		}
		return true;
	}
	//2.approach making arrays and sort, then convert to string both and compare with .equals() method.
	public static void isAnagram2(String a,String b) {
		char[] arr1=a.toCharArray();
		char[] arr2=b.toCharArray();
		
		Arrays.parallelSort(arr1);
		Arrays.parallelSort(arr2);
		
		String sorted1=new String(arr1);
		String sorted2=new String(arr2);
		
		if(sorted1.equals(sorted2)) {
			System.out.println("Anagram");
		}else {
			System.out.println("Not Anagram");
		}
	}
	
	//3.approach counting characters both of Strings
	
	public static boolean isAnagram3(String a,String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		
		int []count=new int[256];
		
		for(int i=0;i<a.length();i++) {
			//a ve b stringing bulunan karakterleri sayılması
			count[a.charAt(i)]++;
			
			count[b.charAt(i)]--;
		}
		
		for(int j=0;j<count.length;j++) {
			if(count[j]!=0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		isAnagram2("tab","bat");

	}
	
	//3. approach 

}
