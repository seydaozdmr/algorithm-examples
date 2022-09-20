package algorithms.hindi;

import java.util.NoSuchElementException;

public class Queue {
	
	private class ListNode{
		int item;
		ListNode next;
	}
	
	private ListNode front;
	private ListNode rear;
	private int size;
	
	public Queue() {
		front=null;
		rear=null;
		size=0;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	
	public int first() {
		if(isEmpty()) {
			throw new NoSuchElementException("Kuyruk boş");
		}
		int data=front.item;
		return data;
	}
	
	public int last() {
		if(isEmpty()) {
			throw new NoSuchElementException("Kuyruk boş");
		}
		return rear.item;
	}
	
	public void enqueue(int data) {
		ListNode temp=new ListNode();
		temp.item=data;
		if(isEmpty()) {
			front=temp;
		}else {
			rear.next=temp;	
		}
		rear=temp;
		size++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		int item=front.item;
		front=front.next;
		//en sonunda rear değerini tutan elemanı da silmemiz gerekiyor.
		if(front==null) {
			rear=null;
		}
		size--;
		return item;
	}
	
	public void show() {
		if(isEmpty()) {
			return;
		}
		
		ListNode current=front;
		while(current!=null) {
			System.out.print(current.item+" --> ");
			current=current.next;
		}
		System.out.print("null");
	}
	

	public static void main(String[] args) {
		Queue kuyruk=new Queue();
		kuyruk.enqueue(1);
		kuyruk.enqueue(2);
		kuyruk.enqueue(3);
		kuyruk.enqueue(4);
		kuyruk.enqueue(5);
		kuyruk.enqueue(6);
		kuyruk.show();
		kuyruk.dequeue();
		kuyruk.dequeue();
		kuyruk.dequeue();
		kuyruk.dequeue();
		System.out.println();
		System.out.println(kuyruk.first());
		System.out.println(kuyruk.last());
		kuyruk.show();

	}

}
