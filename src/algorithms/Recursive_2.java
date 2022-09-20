package algorithms;

public class Recursive_2 {
	//Verilen bir String ifadeyi recusive olarak tersine çeviren algoritma
	public static String mystery(String s) {
		int N=s.length();
		if(N<=1) return s;
		String a=s.substring(0,N/2);
		String b=s.substring(N/2,N);
		System.out.println("a: "+a+" b: "+b);
		return mystery(b)+mystery(a);
	}

	public static void main(String[] args) {
		String mesaj="Benim Adım Seyda Özdemir";
		String sonuc=mystery(mesaj);
		System.out.println(sonuc);

	}

}
