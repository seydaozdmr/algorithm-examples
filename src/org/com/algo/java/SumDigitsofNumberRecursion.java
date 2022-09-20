package org.com.algo.java;

public class SumDigitsofNumberRecursion {
	public static int digitSumRecursion(int n) {
		//öncelikle kontrol ediyoruz gelen n sayısı 0 ya da 0'dan küçük mü
		//bu aşağıda çağırdığımız fonksiyonumuzun ulaştığı son nokta oluyor.
		if(n<=0) {
			return 0;
		}
		//önce sayının 10'a bölümünden kalanı buluyoruz. Bu toplamak istediğimiz sayının son rakam değeri oluyor
		int i=n%10;
		//daha sonra sayıyı 10 a bölerek bir basamağı atlamış oluyor.
		n=n/10;
		//elde ettiğimiz sonuçları, önce rakam değerini topluyoruz daha sonra geriye kalanı için fonksiyonu tekrar çağırıyoruz.
		return digitSumRecursion(n)+i;
	}

	public static void main(String[] args) {
		System.out.println(digitSumRecursion(12345));

	}

}
