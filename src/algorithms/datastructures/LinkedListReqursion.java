package algorithms.datastructures;

public class LinkedListReqursion {
	private class Node{
		String item;
		Node next;
	}
	
	private Node head;
	private int size;
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public int size() {
		return size;
	}
	
	public void add(String item) {
		if(isEmpty()) {
			head=new Node();
			head.item=item;
		}else {
			Node temp;
			for(temp=head;temp.next!=null;temp=temp.next);
			Node n=new Node();
			n.item=item;
			temp.next=n;
		}
		size++;
	}
	
	public void delete() {
		if(isEmpty()) {
			return;
		}
		if(size==1) {
			head=null;
		}else {
			Node temp=head;
			while(temp.next.next!=null) {
				temp=temp.next;
			}
			temp.next=null;
		}
		size--;
	}
	
	//Recursive solution
	public void reverse() {
		head=reverseRec(head);
	}
	
	private Node reverseRec(Node head) {
		if(head==null) {
			return null;
		}
		if(head.next==null) {
			return head;
		}
		Node second=head.next;
		Node rest=reverseRec(second);
		second.next=head;
		head.next=null;
		return rest;
	}
	
	public void yeniRecur() {
		head=yenirecur(head);
	}
		
	private Node yenirecur(Node curr) {
		if(curr==null) {
			return null;
		}
		if(curr.next==null) {
			return curr;
		}
		Node n=curr.next;
		curr.next=null;
		Node son=yenirecur(n);
		n.next=curr;
		
		return son;
	}
	
	
	
	public void show(String baslik) {
		System.out.println(baslik);
		if(!isEmpty()) {
			if(size==1) {
				System.out.println(head.item);
			}else {
				Node temp;
				for(temp=head;temp!=null;temp=temp.next) {
					System.out.println(temp.item);
				}
			}
		}
	}
	
	public void showRec(Node head) {
		if(head==null) {
			return;
		}
		showRec(head.next);
		System.out.println(head.item);
	}
	

	public static void main(String[] args) {
		LinkedListReqursion yenilist=new LinkedListReqursion();
		yenilist.add("ali");
		yenilist.add("hasan");
		yenilist.add("hüseyin");
		yenilist.show("********Normal Liste********");
		System.out.println("*******Recursive Show******");
		yenilist.showRec(yenilist.head);
		yenilist.reverse();
		yenilist.show("********Reversed Liste********");
		yenilist.show("son:");
		yenilist.yeniRecur();
		
		yenilist.show("******Void Recursive*********");
		

	}

}
