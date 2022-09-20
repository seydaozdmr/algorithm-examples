package org.com.algo.java;

public class ReverseEachWordsofaString {

	public static void main(String[] args) {
		String str="Hello World";
		
		//bir dizi içerisinde ifade edilmek üzere iki ayrı parçaya bölüyoruz ["Hello","World"]
		String[]strs=str.split(" ");
		String result="";
		
		for(int i=0;i<strs.length;i++) {
			String word=reverse(strs[i]);
			result+=word+" ";
		}
		
		System.out.println(result);
		
		
		
	}

	private static String reverse(String str) {
		String newWord="";
		for(int j=str.length()-1;j>=0;j--) {
			newWord=newWord+str.charAt(j);
		}
		return newWord;
	}

}
