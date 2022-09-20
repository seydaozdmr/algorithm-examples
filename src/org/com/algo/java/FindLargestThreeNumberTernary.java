package org.com.algo.java;

public class FindLargestThreeNumberTernary {

	public static void main(String[] args) {
		int a=20;
		int b=45;
		int c=39;
		
		int result=(a>b && b>c)?a:(a<b && b>c)?b:c;
		int result2=(a>b)?(a>c?a:c):(b>c?b:c);
		System.out.println(result);
		System.out.println(result2);
	}

}
