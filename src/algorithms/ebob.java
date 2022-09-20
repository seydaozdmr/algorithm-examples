package algorithms;

public class ebob {


	public static int ebb(int p,int q) {
		System.out.println("q: "+q+" p: "+p);
		//Bölümden kalan olmayana kadar yani tam bölünene kadar devam ediyor. Böylece en büyük ortak bölen bulunuyor.
		if(q==0) return p;
		//Bölümden kalanı r'ye atıyor.
		int r=p%q;
		//q'yu başa alıyor böylece küçük sayı büyüğü bölmeye bölmeye çalışıyor.
		return ebb(q,r);
	}
	public static void main(String[] args) {
		System.out.println(ebb(1111111,1234567));
		// 3 sayıyı sıralayan algoritma
		int a = 5;
		int b = 99;
		int c = 10;
		int t = 0;
		
		if (a > b) { t = a; a = b; b = t; }
		if (a > c) { t = a; a = c; c = t; }
		if (b > c) { t = b; b = c; c = t; }
		
		StdOut.println("a: " + a);
		StdOut.println("b: " + b);
		StdOut.println("c: " + c);
		
		System.out.println(ebb(30,100));

	}

}
