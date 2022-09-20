package algorithms.hindi;

import java.util.Scanner;

public class StringPalindrome {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String s=sc.nextLine();
		String reverse="";
		for(int i=s.length()-1;i>=0;i--) {
			reverse=reverse+s.charAt(i);
		}
		
		if(s.equals(reverse)) {
			System.out.println("Girilen dizi palindrome'dur.");
		}else {
			System.out.println("Girilen dizi palindrome değildir!");
		}
		

	}

}
