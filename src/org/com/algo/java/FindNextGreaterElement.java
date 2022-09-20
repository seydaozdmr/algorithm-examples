package org.com.algo.java;

import java.util.Stack;

public class FindNextGreaterElement {
	public static void findNextGreater(int[]arr) {
		//stack tanımlıyoruz
		Stack<Integer>st=new Stack<>();
		
		//dizi içinde geziniyoruz
		for(int i=0;i<arr.length;i++) {
			//Başlangıçta stack boş ise ilk elemanı ekliyoruz
			if(st.isEmpty()) {
				st.push(arr[i]);
			}else {
				//stack boş değilse ve sıradaki eleman stack'ın en üstteki elemandan büyük ise 
				//sırasıyla üstteki elemanı pop() siliyoruz.
				while(!st.isEmpty() && arr[i]>st.peek()) {
					System.out.println(st.peek()+" => "+arr[i]);
					st.pop();
				}
				//sırada eğer küçük bir eleman varsa eklemeye devam ediyoruz.
				st.push(arr[i]);
				
			}
		}
		while(!st.isEmpty()) {
			System.out.println("siradaki elemandan sonraki büyük eleman "+st.peek()+" is "+null);
			st.pop();
		}
	}

	public static void main(String[] args) {
		int []arr= {4,2,6,8,1,0};
		findNextGreater(arr);
	}

}
