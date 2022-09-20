package org.youtube.dersler;

public class String_ders {

	public static void main(String[] args) {
		//String s1="Haberler";
		String s2=new String("Haberler");
		
		System.out.println(s2.length());

		System.out.println("0.index: "+s2.charAt(0));
		
		System.out.println(s2.startsWith("Hab"));
		System.out.println(s2.endsWith("ler"));
	}

}
