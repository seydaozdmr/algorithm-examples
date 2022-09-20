package algorithms;

public class egz {
	public static int [] histogram  (int a[],int M){
		int h[]=new int[M];
		int N=a.length;
		
		for(int i=0;i<N;i++) {
			if(a[i]<M)
				h[a[i]]++;
		}
		return h;
		
	}
	 public static String exR1(int n)
	    {
	        if (n <= 0) return "";
	        System.out.println(n);
	        return exR1(n-3) + n + exR1(n-2) + n;
	    }
	 
	 public static int mystery(int a,int b) {
		 System.out.println("a: "+a+" b: "+b);
		 if(b==0)
			 return 0;
		 if(b%2==0) return mystery(a+a,b/2);
		 
		 return mystery(a+a,b/2)+a;
	 }
	 public static long F(int N) {
		 if (N==0) return 0;
		 if (N==1) return 1;
		 return F(N-1) + F(N-2);
	 }
	 
	public static void main(String[] args) {
		int N=30;
		int M=5;
		int [] a=new int[N];
		for(int i=0;i<N;i++)
			a[i]=StdRandom.uniform(M);
		for (int i = 0; i < N; i++)
			StdOut.printf("%2d", a[i]);
		int [] h=histogram(a,M);
		StdOut.println("\n");
		 for (int i = 0; i < M; i++)
	            StdOut.printf("%4d", h[i]);
		 System.out.println();
		 StdOut.println(exR1(6));
		 
		 System.out.println(mystery(2,3));
		 System.out.println(mystery(3,11));
		 long dizi[]=new long[90];
		 for(int i=0;i<90;i++) {
			 dizi[i]= F(i);
		 }
		 
		 for(int i=0;i<90;i++)
			 StdOut.println(i+ " "+F(i));
	}

}
