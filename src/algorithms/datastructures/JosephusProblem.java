package algorithms.datastructures;
import algorithms.Queue;
import algorithms.StdOut;
public class JosephusProblem {
	public static void JosephusProblem(int kisisirasi,int kisisayisi) {
		Queue<Integer> kuyruk=new Queue<>();
		for(int i=0;i<kisisayisi;i++) {
			kuyruk.enqueue(i);
		}
		
		while(kisisayisi>0) {
			for(int i=1;i<kisisirasi;i++) {
				kuyruk.enqueue(kuyruk.dequeue());
			}
			StdOut.print(kuyruk.dequeue() + " ");

            kisisirasi--;
			
		}
	}

	public static void main(String[] args) {
		int kisisirasi =2;
		int kisisayisi=7;
		StdOut.println("Order in which people are eliminated:");
        JosephusProblem(kisisirasi, kisisayisi);


	}

}
