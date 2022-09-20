package org.com.algo.java;

public class Recursive_1 {
	
	public static void Recur(int a) {
		if(a<=100) {
			System.out.println(a);
			Recur(a+1);
		}
	}

	public static void main(String[] args) {
		Recur(0);

	}

}
