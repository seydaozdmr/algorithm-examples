package algorithms;

public class Recursive_1 {
	public static String rx_1(int n) {
		//if kontrolu return'dan önce olmalıdır. Aksi takdirde rx_1(-3) gibi bir yola girebiliriz.
		if(n<=0) return " ";
		return rx_1(n-3)+n+rx_1(n-2)+n;
	}

	public static void main(String[] args) {
		System.out.println(rx_1(6));

	}

}
