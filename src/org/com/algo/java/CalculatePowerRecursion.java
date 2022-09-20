package org.com.algo.java;

public class CalculatePowerRecursion {
	
	public static int power(int a,int power) {
		int result=1;
		while(power>0) {
			result=a*result;
			power--;
		}
		return result;
	}
	
	public static double powerRecurison(int base,int exponent) {
		if(exponent==0) {
			return 1;
		}else if(exponent>0) {
			return base*powerRecurison(base,exponent-1);
		}else {
			//eğer üs eksi değer ise tersine çevirip üs alırız.
			return 1/powerRecurison(base,-exponent);
		}
	}

	public static void main(String[] args) {
		System.out.println(powerRecurison(2, -3));

	}

}
