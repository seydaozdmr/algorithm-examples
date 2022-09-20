package algorithms.datastructures;

import java.util.Iterator;
import java.util.StringJoiner;

import algorithms.StdOut;

public class LinkedListQueue<Item> implements Iterable<Item> {
	public class Node{
		Item item;
		Node next;
	}
	private Node last;
	private int size;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(Item item) {
		if(isEmpty()) {
			last=new Node();
			last.item=item;
			last.next=last;
		}else {
			Node temp=new Node();
			temp.item=item;
			if(size==1) {
				last.next=temp;
				temp.next=last;
			}else {
				temp.next=last.next;
				last.next=temp;
			}
			last=temp;
		}
		size++;
	}
	public Item dequeue() {
		if(isEmpty())
			return null;
		
		Item item;
		
		if(size==1) {
			item=last.item;
			last=null;
		}else {
			item=last.item;
			last.next=last.next.next; //kuyruktaki ilk eleman çıkar. last.next ilk elemanı hedef alır.
		}
		size--;
		return item;
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	public class QueueIterator implements Iterator<Item>{
		private Node current;
		int count = 0;
		
		public QueueIterator() {
			if (last != null && size > 1) {
				current = last.next;
			} else {
				current = last;
			}
		}
		
		public Item next() {
			count++;
			
			Item item = current.item;
			current = current.next;
			return item;
		}
		
		public boolean hasNext() {
			return count < size;
		}
	}
	public static void main(String[] args) {
		LinkedListQueue<Integer> kuyruk=new LinkedListQueue<>();
		kuyruk.enqueue(1);
		kuyruk.enqueue(2);
		kuyruk.enqueue(3);
		kuyruk.enqueue(4);
		StringJoiner queueItems = new StringJoiner(" ");
        for (int item : kuyruk) {
            queueItems.add(String.valueOf(item));
        }

        StdOut.println("Queue items: " + queueItems.toString());
        StdOut.println("Expected: 1 2 3 4");
		

	}

}

	
