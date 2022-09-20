package org.com.algo.java;

import java.util.Stack;

public class FindMaxElementStack {
	//iki tane Stack oluşturuyoruz.
	private Stack<Integer> st=new Stack<>();
	private Stack<Integer> maxst=new Stack<>();
	//eleman eklerken maxst stack'inin en üstündeki elemandan büyük ise max yeni elemanımız oluyor.
	//değilse max maxst stack'ının en üstteki elemanı oluyor.
	//normal st stack'ini data ekleniyor,
	//maxst stack'ina bulunan en büyük değer ekleniyor.
	public void push(int data) {
		int max=data;
		if(!maxst.isEmpty() && max<maxst.peek()) {
			max=maxst.peek();
		}
		st.push(data);
		maxst.push(max);
	}
	
	public void pop() {
		st.pop();
		maxst.pop();
	}
	
	public int getmax() {
		return maxst.peek();
	}

	public static void main(String[] args) {
		FindMaxElementStack find = new FindMaxElementStack();

		find.push(3);
		find.push(2);
		find.push(1);
		find.push(9);
		find.push(2);
		find.push(8);

		System.out.println(find.st);
		System.out.println(find.maxst);
		System.out.println(find.getmax());

		find.pop();
		find.pop();

		System.out.println(find.st);
		System.out.println(find.maxst);
		System.out.println(find.getmax());

	}

}
