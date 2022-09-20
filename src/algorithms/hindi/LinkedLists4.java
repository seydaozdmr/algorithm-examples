package algorithms.hindi;

public class LinkedLists4 {
	private ListNode head;
	
	private static class ListNode{
		private int item;
		private ListNode next;
		
		private ListNode(int data) {
			this.item=data;
			this.next=null;
		}
	}
	public void add(int item) {
		ListNode temp=new ListNode(item);
		temp.next=head;
		head=temp;
	}
	
	public void deleteNode(int key) {
		ListNode current=head;
		ListNode temp=null;
		if(current!=null && current.item==key) {
			head=current.next;
			return;
		}
		while(current!=null && current.item==key) {
			temp=current;
			current=current.next;
		}
		if(current==null) {
			return;
		}
		temp.next=current.next;
	}
	
	public void addLast(int item) {
		ListNode newNode=new ListNode(item);
		if(head==null) {
			head=newNode;
			return;
		}
		ListNode current=head;
	
		while(current.next!=null) {
			current=current.next;
		}
		current.next=newNode;
	}
	public int removeFirst() {
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
		}
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}
	
	public int length() {
		if(head==null) {
			return -1;
		}
		int count=0;
		ListNode current=head;
		while(current!=null) {
			count++;
			current=current.next;
		}
		return count;
	}

	public static void main(String[] args) {
		LinkedLists4 liste=new LinkedLists4();
		liste.head=new ListNode(5);
		ListNode second=new ListNode(6);
		liste.head.next=second;
		System.out.println(liste.length());
		liste.add(15);
		System.out.println(liste.length());
		liste.show();
		liste.addLast(25);
		liste.show();

	}

}
