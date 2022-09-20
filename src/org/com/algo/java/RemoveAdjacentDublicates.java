package org.com.algo.java;

import java.util.Stack;

public class RemoveAdjacentDublicates {
	public static String removeAdjacentDublicate(String str) {
		Stack<Character> st=new Stack<>();
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<str.length();i++) {
			//eğer stack boş değilse ve sıradaki karakter en üstteki karakter ile aynı ise en üstteki karakteri çıkarıyoruz.
			if(!st.isEmpty() && st.peek()==str.charAt(i)) {
				st.pop();
			}else {
				st.push(str.charAt(i));
			}
		}
		for(Character ch:st) {
			sb.append(ch);
		}
		return sb.toString();
		
	}

	public static void main(String[] args) {
		String str="caaabbbc";
		String result=removeAdjacentDublicate(str);
		System.out.println(result);

	}

}
