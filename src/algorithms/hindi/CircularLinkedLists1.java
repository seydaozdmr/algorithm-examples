package algorithms.hindi;

import java.util.NoSuchElementException;

public class CircularLinkedLists1 {
	private class LinkNode{
		int item;
		LinkNode next;
	}
	
	private LinkNode last;
	private int size;
	
	public CircularLinkedLists1() {
		last=null;
		size=0;
	}
	
	public void add(int data) {
		LinkNode newNode=new LinkNode();
		newNode.item=data;
		if(last==null) {
			last=newNode;
			
		}else {
			newNode.next=last.next;
			
		}
		last.next=newNode;
		size++;
	}
	
	public void addLast(int data) {
		LinkNode temp=new LinkNode();
		temp.item=data;
		if(last==null) {
			last=temp;
			last.next=last;
		}else {
			temp.next=last.next;
			last.next=temp;
			last=temp;
		}
		size++;	
	}
	
	public void show() {
		if(last==null) {
			System.out.println("Liste boş");
			return;
		}else {
			LinkNode current=last.next;
			while(current!=last) {
				System.out.println(current.item);
				current=current.next;
			}
			System.out.println(current.item);
		}
	}
	
	public int removeLast() {
		if(last==null) {
			System.out.println("liste boş");
			return -1;
		}
		int item = last.item;
		LinkNode current = last.next;
		if(current==last) {
			last=null;
		}else {
			while (current.next != last) {
				current = current.next;
			}
			current.next = last.next;
			last.next=null;
			last = current;
		}
		return item;
	}
	
	public int removeFirst() {
		if(last==null) {
			throw new NoSuchElementException(); //hata 
		}
		LinkNode temp=last.next;
		int item=temp.item;
		if(temp==last) {
			last=null;
		}else {
			last.next=temp.next;
		}
		temp.next=null; //we can pass this step
		size--;
		return item;
	}
	
	public boolean isLoop() {
		LinkNode fastNode=last;
		LinkNode slowNode=last;
		while(fastNode!=null &&fastNode.next!=null) {
			slowNode=slowNode.next;
			fastNode=fastNode.next.next;
			if(slowNode==fastNode) {
				return true;
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		CircularLinkedLists1 liste=new CircularLinkedLists1();
		liste.addLast(5);
		liste.addLast(6);
		liste.addLast(7);
		liste.show();
		System.out.println("döngü var mı:"+liste.isLoop());
		
		
		System.out.println("silinen eleman: "+liste.removeFirst());
		System.out.println("silinen eleman: "+liste.removeFirst());
		System.out.println("silinen eleman: "+liste.removeFirst());
		
		liste.show();
		System.out.println("döngü var mı:"+liste.isLoop());
		
		liste.addLast(5);
		liste.addLast(6);
		liste.addLast(7);
		liste.show();
		System.out.println("silinen eleman: "+liste.removeLast());
		System.out.println("silinen eleman: "+liste.removeLast());
		System.out.println("silinen eleman: "+liste.removeLast());
		System.out.println("silinen eleman: "+liste.removeLast());
	}

}
