package algorithms.hindi;

public class LinkedLists5 {
	
	private class LinkNode{
		int item;
		LinkNode next;
	}
	
	private LinkNode head;
	private int size;
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public void push(int item) {
		LinkNode newNode=new LinkNode();
		newNode.item=item;
		newNode.next=head;
		head=newNode;
	}
	public void pushLast(int item) {
		LinkNode newNode=new LinkNode();
		newNode.item=item;
		if(head==null) {
			head=newNode;
		}else {
			LinkNode temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newNode;
		}
	}
	
	public int pop() {
		if(head==null) {
			return -1;
		}else {
			int item=head.item;
			head=head.next;
			return item;
		}
	}
	
	public void show() {
		if(head==null) {
			System.out.println("liste boş");
			return;
		}
		LinkNode current=head;
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}

	public static void main(String[] args) {
		LinkedLists5 liste=new LinkedLists5();
		liste.push(19);
		liste.push(12);
		liste.show();
		liste.pushLast(22);
		liste.show();
		System.out.println(liste.pop());

	}

}
