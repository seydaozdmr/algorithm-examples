package algorithms;

public class Logaritma {
	public static int lg(int n) {
		int logInt=0;
		while(n>0) {
			logInt++;
			n/=2;
			System.out.println("n:"+n);
		}
		return logInt-1;
	}
	public static void main(String[] args) {
		System.out.println(lg(20));

	}

}
