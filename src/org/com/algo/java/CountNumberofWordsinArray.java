package org.com.algo.java;

public class CountNumberofWordsinArray {
	
	public static int countWords(String words) {
		String[]liste=words.split(" ");
		for(int i=0;i<liste.length;i++) {
			System.out.println(liste[i]);
		}
		return liste.length;
	}
	
	public static int countWords2(String words2) {
		int countString=1;
		for(int i=0;i<words2.length();i++) {
			if(words2.charAt(i)==' ' && i<words2.length()-1 && words2.charAt(i+1)!=' ') {
				countString++;
			}
		}
		return countString;
	}

	public static void main(String[] args) {
		System.out.println(countWords("Bucak Adem Tolunay Fen Lisesi"));
		System.out.println(countWords2("Bucak Adem Tolunay Fen Lisesi"));
	}

}
