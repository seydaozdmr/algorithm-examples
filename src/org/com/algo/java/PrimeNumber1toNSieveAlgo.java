package org.com.algo.java;

public class PrimeNumber1toNSieveAlgo {
	
	public static void checkPrime(int num) {
		boolean prime[]=new boolean[num+1];
		
		for(int i=2;i<=num;i++) {
			//bütün sayılar true olarak işaretleniyor
			prime[i]=true;
		}
		
		for(int i=2;i<Math.sqrt(num);i++) {
			System.out.println("i : "+i);
			//2'den başlamak üzere prime boolean dizisinini i. elemanı(2) true mu?
			//3*3=9 3*5=15
			//geriye kalanlar asal oluyor
			if(prime[i]) {
				
				for(int j=i;j*i<=num;j++) {
					//2*2=4
					//2*3=6
					//2*4=8
					//2*5=10
					//2*6=12
					//2*7=14
					//2*8=16
					//2*9=18
					//2*10=20
					//sayıları sırasıyla asal değil yani false olarak işaretleniyor.
					prime[i*j]=false;
				}
			}
		}
		
		for(int i=2;i<num;i++) {
			if(prime[i]) {
				System.out.println(i+" asal sayıdır." );
			}
		}
	}

	public static void main(String[] args) {
		checkPrime(100);

	}

}
