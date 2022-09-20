package multiThreading;
class MyCounter implements Runnable{
	private int threadNo;
	public MyCounter(int threadNo) {
		this.threadNo=threadNo;
	}
	@Override
	public void run() {
		for(int i=0;i<=9;i++) {
			System.out.println("Eğer i değeri :"+i+" ve thread numarası : "+threadNo);
		}
	}
	
	/*
	@Override
	public void run() {
		countMe();
	}
	public void countMe() {
		for(int i=0;i<=9;i++) {
			try {
				sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Eğer i değeri :"+i+" ve thread numarası : "+threadNo);
		}
	}
	*/
}
public class test1 {

	public static void main(String[] args) {
		/*
		MyCounter counter1=new MyCounter(1);
		MyCounter counter2=new MyCounter(2);
		
		counter1.start();
		System.out.println("*************************");
		counter2.start();
		*/
		Thread thread1=new Thread(new MyCounter(1));
		Thread thread2=new Thread(new MyCounter(2));
		thread1.start();
		thread2.start();
		
	}

}
