package org.com.algo.java;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStringusingStack {
	public static String reverse(String n) {
		Stack<Character> st=new Stack<>();
		
		for(int i=0;i<n.length();i++) {
			st.push(n.charAt(i));
		}
		String x="";
		for(int i=0;i<n.length();i++) {
			x+=st.pop();
		}
		
		return x;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Bir kelime yazınız");
		String n=in.nextLine();
		
		System.out.println(reverse(n));
		in.close();
		
		
	}

}
