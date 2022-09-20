package org.com.algo.java;

public class ReverseStringRecursive {
	
	public static String reverse(String str) {
		
		//ilk olarak kontrolu gerçekleştiriyoruz.
		//verilen str String'inin boyutu 1'e eşit olana kadar bu fonksiyonu çağırabilirim.
		if(str==null || str.length()<=1) {
			return str;
		}
		//Her defasında verilen string değerin ikinci karakterini alıp fonksiyona parametre olarak veriyorum ve ilk karakteri tutuyorum
		//En son 
		return reverse(str.substring(1))+str.charAt(0);
	}

	public static void main(String[] args) {
		System.out.println(reverse("seyda"));

	}

}
