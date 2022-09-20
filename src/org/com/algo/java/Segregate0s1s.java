package org.com.algo.java;

public class Segregate0s1s {
	public static void Segregate(int []arr) {
		int j=0;
		for(int i=0;i<arr.length;i++) {
			//gezilen değer 0 ise onu başa taşı
			//0'ları saymış oluyoruz ve saydığımız kadar array'in başlangıç kısmına 0 ekliyoruz.
			if(arr[i]==0) {
				arr[j++]=arr[i];
			}
		}
		
		for(int i=j;j<arr.length;j++) {
			//kalanları 1 yapıyoruz.
			arr[j++]=1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
