package org.com.algo.java;

class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data=data;
		this.next=null;
	}
}
public class FindLengthLinkList {
	
	private Node head;
	
	public Node add(int data) {
		Node temp=new Node(data);
		if(head==null) {
			head=temp;
		}else {
			temp.next=head;
			head=temp;
		}
		return head;
	}
	
	public int printLength() {
		int count=0;
		
		Node temp=head;
		
		while(temp!=null) {
			temp=temp.next;
			count++;
		}
		return count;
	}
	
	public void print() {
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	//recursive
	public int printLengthRecursive(Node node) {
		if(node==null) {
			return 0;
		}else {
			return 1+printLengthRecursive(node.next);
		}
	}
	
	//search
	public void search(int key) {
		Node temp=head;
		boolean bulundu=false;
		while(temp!=null) {
			if(temp.data==key) {
				bulundu=true;
			}			
			temp=temp.next;
		}
		if(bulundu) {
			System.out.println("Aranan eleman bulundu.");
		}else {
			System.out.println("Aranan eleman bulunamadı");
		}
	}
	
	public boolean recursiveSearch(Node head,int value) {
		if(head==null) {
			return false;
		}
		
		if(head.data==value) {
			return true;
		}
		
		return recursiveSearch(head.next,value);
	}
	
	public static void main(String[] args) {
		FindLengthLinkList liste=new FindLengthLinkList();
		liste.add(5);
		liste.add(4);
		liste.add(3);
		liste.add(2);
		System.out.println(liste.printLength());
		liste.print();
		System.out.println(liste.printLengthRecursive(liste.head));
		liste.search(5);
	}

}
