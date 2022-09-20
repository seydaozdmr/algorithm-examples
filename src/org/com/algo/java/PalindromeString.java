package org.com.algo.java;

public class PalindromeString {

	public static void main(String[] args) {
		String str="Hello";
		
		int start=0;
		int end=str.length()-1;
		boolean palindrome=true;
		while(start<end) {
			if(str.charAt(start)!=str.charAt(end)) {
				palindrome=false;
				break;
			}
			start++;
			end--;
		}
		
		if(palindrome) {
			System.out.println("palindrome");
		}else {
			System.out.println("not palindrome");
		}

	}

}
