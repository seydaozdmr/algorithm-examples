package algorithms;

public class Suffle_Algo {

	public static void main(String[] args) {
		double [] a= {1,2.3,4.5,4,2,5,6.7,7.8,10};
		suffle(a);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}

	}
	public static void suffle(double[] a) {
		int n=a.length;
		for(int i=0;i<n;i++) {
			int rnd=i+StdRandom.uniform(n-i);
			double temp=a[i];
			a[i]=a[rnd];
			a[rnd]=temp;
		}
	}

}
