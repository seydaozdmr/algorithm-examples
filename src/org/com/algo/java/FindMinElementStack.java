package org.com.algo.java;

import java.util.Stack;

public class FindMinElementStack {
	private Stack<Integer> st=new Stack<>();
	private Stack<Integer> minSt=new Stack<>();
	
	public void push(int data) {
		int min=data;
		if(!minSt.isEmpty() && min>minSt.peek()) {
			min=minSt.peek();
		}
		//st'ye data'yı ekliyoruz minSt'ye eğer minSt'nin en üstteki değeri min değerinden küçükse min değerini minSt'nin en üstteki değeri yapıyoruz
		//ve tekrar ekliyoruz.
		st.push(data);
		minSt.push(min);
	}
	
	public void pop() {
		st.pop();
		minSt.pop();
	}
	
	public int getMinimum() {
		return minSt.peek();
	}

	public static void main(String[] args) {
		FindMinElementStack find=new FindMinElementStack();
		
		find.push(3);
		find.push(2);
		find.push(1);
		find.push(9);
		find.push(2);
		
		System.out.println(find.st);
		System.out.println(find.minSt);
		System.out.println(find.getMinimum());
		
		find.pop();
		find.pop();
		
		System.out.println(find.st);
		System.out.println(find.minSt);
		System.out.println(find.getMinimum());
	}

}
