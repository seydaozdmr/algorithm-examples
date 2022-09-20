package multiThreading;
interface Lamda{
	abstract public void demo(int x,float y);
}
public class test3 {

	public static void main(String[] args) {
		
		Lamda lamda=(int x,float y)->{
			
			System.out.println("The value of x is: "+x+" and y is: "+y);
		};
		lamda.demo(5,10.15f);

	}

}
