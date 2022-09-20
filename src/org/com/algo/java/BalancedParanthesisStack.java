package org.com.algo.java;

import java.util.Stack;

public class BalancedParanthesisStack {

	public static void main(String[] args) {
		String paran="{()}()[]";
		
		Stack<Character> st=new Stack<>();
		
		for(int i=0;i<paran.length();i++) {
			if(paran.charAt(i)=='{' || paran.charAt(i)=='(' || paran.charAt(i)=='[') {
				
				st.push(paran.charAt(i));
			}else if(!st.empty() && (
					(paran.charAt(i)==']' && st.peek()=='[') || 
					(paran.charAt(i)=='}' && st.peek()=='{') ||
					(paran.charAt(i)==')' && st.peek()=='('))){
				st.pop();
			}else {
				st.push(paran.charAt(i));
			}
		}
		
		if(st.empty()) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not Balanced");
		}

	}

}
