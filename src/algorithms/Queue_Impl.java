package algorithms;

public class Queue_Impl {
	public static int[] kuyrukolustur() {
		In in=new In();
		Queue<Integer> kuyruk=new Queue<Integer>();
		while(!in.isEmpty()) {
			kuyruk.enqueue(in.readInt());
		}
		int N=kuyruk.size();
		int[] a=new int[N];
		for(int i=0;i<N;i++) {
			a[i]=kuyruk.dequeue();
			
		}
		return a;
	}

	public static void main(String[] args) {
		int[] x=kuyrukolustur();
		for(int i:x) {
			System.out.println(i);
		}
		
		
	}

}
