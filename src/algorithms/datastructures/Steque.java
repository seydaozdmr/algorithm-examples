package algorithms.datastructures;

public class Steque {
	private class Node {
		Integer item;
		Node next;
		Node prev;
	}
	
	private Node first;
	private Node last;
	private int size;
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	
	public void push(Integer item) {
		Node temp=first;
		first=new Node();
		first.item=item;
		first.next=temp;
		
		if(temp!=null) {
			temp.prev=first;
		}else {
			last=first;
		}
		size++;
		
	}
	//pop başlangıçtan çıkartıyor yani son gireni ilk çıkartıyor (LIFO)
	public Integer pop() {
		if(isEmpty()) {
			return -1;
		}
		//Çıkarma işleminden önce çıkan elemanın değerini tutmamız gerekiyor.
		Integer item=first.item;
		first=first.next;
		
		if(first!=null) {
			first.prev=null;
		}else {
			last=null;
		}
		size--;
		return item;
	}
	//kuyruğun sonuna eleman ekliyor.
	public void enqueue(Integer item) {
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.prev=oldlast;
		
		if(oldlast!=null) {
			oldlast.next=last;
		}else {
			first=last;
		}
		size++;
	}
	
	public Integer dequeue() {
		if(isEmpty()) {
			return -1;
		}
		Integer item=last.item;
		Node oldlast=last;
		if(oldlast.prev!=null) {
			last=oldlast.prev;
			last.next=null;
			oldlast.prev=null;
		}else {
			first=null;
			last=null;
		}
		size--;
		return item;
		
	}
	
	

	public static void main(String[] args) {
		Steque liste=new Steque();
		liste.push(1);
		liste.push(2);
		liste.push(3);
		liste.push(4);
		liste.push(5);
		
		System.out.println(liste.pop());
		System.out.println(liste.dequeue());
		System.out.println(liste.dequeue());
		System.out.println(liste.dequeue());
		System.out.println(liste.dequeue());
		System.out.println(liste.dequeue());
		System.out.println(liste.dequeue());
		System.out.println(liste.dequeue());
		System.out.println(liste.dequeue());
	
		

	}

}
