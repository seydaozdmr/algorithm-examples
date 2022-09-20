package multiThreading;
interface Lambda{
	public int topla(int a,int b);
}

public class test2 {

	public static void main(String[] args) {
		
		Lambda lambda2=(int x,int y)->x+y;
		System.out.println(lambda2.topla(5,10));

	}

}
