package algorithms.datastructures;
import java.util.StringJoiner;

import algorithms.Queue;
import algorithms.StdOut;
public class CopyQueue<Item> extends Queue<Item> {
	
	public CopyQueue(Queue<Item> queue) {
		for(Item item:queue) {
			enqueue(item);//yukarda miras alınan Queue sınıfının metodu uygulanıyor.
		}
	}

	public static void main(String[] args) {
		Queue<Integer> orginalQueue=new Queue<>();
		orginalQueue.enqueue(1);
		orginalQueue.enqueue(2);
		orginalQueue.enqueue(3);
		orginalQueue.enqueue(4);
		orginalQueue.enqueue(5);
		//queueCopy yeni nesnemiz oluyor, bu nesne Queue sınıfı extends edildiği için Queue sınıfının tüm özellikleri ile birlikte oluşturuluyor.
		CopyQueue<Integer> queueCopy=new CopyQueue<>(orginalQueue);
		
		queueCopy.enqueue(4);
		queueCopy.enqueue(99);
		
		queueCopy.dequeue();
		queueCopy.dequeue();
		StringJoiner originalQueueItems = new StringJoiner(" ");
        for (int item : orginalQueue) {
            originalQueueItems.add(String.valueOf(item));
        }
        
        StdOut.println("Original Queue: " + originalQueueItems.toString());
        StdOut.println();

        StringJoiner copyQueueItems = new StringJoiner(" ");
        for (int item : queueCopy) {
            copyQueueItems.add(String.valueOf(item));
        }
        StdOut.println("Copy Queue: " + copyQueueItems.toString());
	}

}
