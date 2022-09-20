package algorithms;

public class Mystery {

	public static void main(String[] args) {
		System.out.println(mystery(2,25));
		System.out.println(mystery2(2,25));
	}
	
	private static int mystery(int a, int b) {
		if (b == 0) {
			System.out.println("b == 0:"+a+b);
			return 0;
		}
		if (b % 2 == 0) {
			System.out.println("b % 2==0:"+a+b);
		    return mystery(a + a, b / 2);
        }
		return mystery(a + a, b / 2) + a;
	}
	
	private static int mystery2(int a, int b) {
		if (b == 0) {
		    return 1;
        }
		if (b % 2 == 0) {
		    return mystery2(a * a, b/2);
        }
		return mystery2(a * a, b / 2) * a;
	}

}
