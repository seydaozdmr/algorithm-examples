package algorithms.hindi;

import java.util.NoSuchElementException;

public class DoubleLinkedList1 {
	//instance variables head,tail
	private LinkNode head;
	private LinkNode tail;
	private int size;
	//inner class  - LinkNode represent
	private class LinkNode{
		int item;
		LinkNode next;
		LinkNode prev;
		//constructure
		private LinkNode(int data) {
			this.item=data;
			this.next=null;
			this.prev=null;
		}
	}
	
	public DoubleLinkedList1() {
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	
	public void show() {
		LinkNode current=head;
		if(head==null) {
			System.out.println("Liste boş");
		}
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}
	public void showReverse() {
		LinkNode current=tail;
		if(head==null) {
			System.out.println("liste boş");
		}
		while(current!=null) {
			System.out.println(current.item);
			current=current.prev;
		}
	}
	
	//DoubleLinkedList eleman eklemek //adding new item
	public void add(int item) {
		LinkNode current=new LinkNode(item);
		//Eğer en başta head boş ise eklenen ilk eleman tail olarak eklenir.
		if(head==null) {
			tail=current;
		}else {
			//eğer en az bir eleman varsa ki o aşağıda head olarak atanıyor, yeni eklediğimiz eleman head'in prev yani önceki değeri oluyor.
			head.prev=current;
		}
		//yeni eklenen elemanın next değeri head'i gösteriyor
		current.next=head;
		//head en sonunda yeni eklenen eleman oluyor.
		head=current;
		size++;
	}
	
	public void addLast(int item) {
		LinkNode current=new LinkNode(item);
		if(head==null) {
			head=current;
		}else {
			tail.next=current;
			//eğer hiç bir eleman yoksa bu ifadeyi aşağıya yazarsak current.prev yani ilk node'un önceki nodu kuyruk değerimiz olur.
			//Bizim istediğimiz eklemek istediğimiz son eleman kuyruğun sonuna eklensin ve prev değeri kuyruğu göstersin
			current.prev=tail;
		}
		tail=current;
		size++;
	}
	public LinkNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		//geri değer olarak dönecek temp Node'u.
		LinkNode temp=head;
		//head==tail eğer linklist'imiz tek elemana mı sahip.
		if(head==tail) {
			//ilk önce tek elemana mı sahibiz ona bakıyoruz.
			tail=null;
		}else {
			//öndeki Node'un önceki değerini tutan prev değerini null yapıyoruz.
			head.next.prev=null;
		}
		head=head.next;
		//temp head'i tutuyordu, head -> head.next değerine atansa bile, geride bir bağlantı kaldı.
		//temp.next=null diyerek bu bağlantı koparılıyor.
		temp.next=null;
		size--;
		return temp;
	}
	
	public LinkNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		LinkNode temp=tail;
		if(head==tail) {
			head=null;
		}else {
			//son elemanın önceki elemanının next'ini null yapıyoruz yani sol elemanla olan bağını koparıyoruz.
			tail.prev.next=null;
		}
		//sondan bir önceki elemanı son eleman yapıyoruz.
		tail=tail.prev;
		//silinen son elemanın önceki elemanla olan bağını koparıyoruz.
		temp.prev=null;
		size--;
		return temp;
	}

	public static void main(String[] args) {
		DoubleLinkedList1 liste=new DoubleLinkedList1();
		liste.add(1);
		liste.add(2);
		liste.add(3);
		liste.add(4);
		liste.add(5);
		liste.show();
		liste.showReverse();
		
		liste.addLast(6);
		System.out.println("*******");
		liste.show();
		liste.deleteFirst();
		System.out.println("*******");
		liste.show();

	}

}
