package org.com.algo.java;

public class SumofEven1to100Recursive {
	public static int sumEven(int start,int end) {
		if(end<=start) {
			return 0;
		}
		return sumEven(start,end%2==0?end-2:end-1)+end;
		
	}

	public static void main(String[] args) {
		System.out.println(sumEven(1,5));

	}

}
