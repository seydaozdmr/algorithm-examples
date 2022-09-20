package algorithms.datastructures;

import java.util.Iterator;

public class Queue implements Iterable<String> {
	private String[] items;
	private int n; //size
	private int first;
	private int last;
	
	public Queue(int capacity) {
		items=new String[capacity];
	}
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public int size() {
		return n;
	}
	
	public void resize(int newcapacity) {
		String[]temp=new String[newcapacity];
		for(int i=0;i<temp.length;i++) {
			temp[i]=items[(first+i)%items.length];
		}
		items=temp;
		first=0;
		last=n;
	}
	
	public void enqueue(String item) {
		if(n==items.length) {
			resize(items.length*2);
		}
		//TODO bu ne ola ki
		if(last==items.length) {
			last=0;
		}
		items[last++]=item;
		n++;
		
	}
	public String dequeue() {
		if(isEmpty()) {
			throw new RuntimeException("Kuyruk boş.");
		}else {
			String item=items[first];
			items[first]=null;
			first++;
			if(first==items.length) {
				first=0;
			}
			n--;
			if(n>0 && n==items.length/4) {
				resize(items.length/2);
			}
			System.out.println(item);
			return item;
		}
	}
	public static void main(String[] args) {
		Queue queue=new Queue(5);
		queue.enqueue("ali");
		queue.enqueue("mehmet");
		queue.enqueue("hasan");
		queue.enqueue("hakan");
		queue.enqueue("yılmaz");
		queue.enqueue("muhittin");
		queue.enqueue("ali");
		queue.enqueue("mehmet");
		queue.enqueue("hasan");
		queue.enqueue("hakan");
		queue.enqueue("yılmaz");
		queue.enqueue("muhittin");
		queue.enqueue("ali");
		queue.enqueue("mehmet");
		queue.enqueue("hasan");
		queue.enqueue("hakan");
		queue.enqueue("yılmaz");
		queue.enqueue("muhittin");
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue("hakan");
		queue.enqueue("yılmaz");
		queue.enqueue("muhittin");
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
