package algorithms;

public class IntegerToBinaryString {

	public static void main(String[] args) {
		int N=50;
		String b="";
		for(int i=N;i>0;i/=2) {
			b=(i%2)+b;
			System.out.println(b);
			
		}
		System.out.println("sonuc: "+b);
		
		int [][] sayilar=new int[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				sayilar[i][j]=(i+1)*2;
			}
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				System.out.println(sayilar[i][j]);
			}
		}
		
		
	}

}
