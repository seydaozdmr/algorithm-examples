package udemy_java_kursu;

import java.util.Scanner;

public class Ders_1 {

	public static void main(String[] args) {
		int[]dizi=new int[10];
		for(int i=0;i<dizi.length;i++) {
			dizi[i]=i*i;
		}
		for(int i=0;i<dizi.length;i++) {
			System.out.println(dizi[i]);
		}
		
		String[] aylar=new String[12];
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<aylar.length;i++) {
			System.out.println((i+1)+". ay:");
			aylar[i]=scanner.nextLine();
			
		}
		System.out.println("Hangi aydasınız: ");
		int ay=scanner.nextInt();
		System.out.println(aylar[ay-1]);
		scanner.close();

	}

}
