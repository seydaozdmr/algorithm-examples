package algorithms.hindi;



public class LinkedLists3 {
	
	private class ListNode{
		private int item;
		private ListNode next;
		
		public ListNode(int item) {
			this.item=item;
			this.next=null;
		}
	}
	
	private ListNode head;
	
	public void insertAtBeginning(int item) {
		ListNode temp=new ListNode(item);
		temp.next=head;
		head=temp;
	}
	
	public void printLinkedLists() {
		if(head==null) {
			System.out.println("liste boş");
		}
		
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}
	
	public ListNode getMiddle() {
		if(head==null) {
			return null;
		}
		
		ListNode slowNode=head;
		ListNode fastNode=head;
		
		while(fastNode!=null && fastNode.next!=null) {
			slowNode=slowNode.next;
			fastNode=fastNode.next.next;
		}
		return slowNode;
	}
	//Removes if list was sorted
	public void removeSortedDublicates() {
		if(head==null) {
			return;
		}
		ListNode current=head;
		while(current!=null && current.next!=null) {
			if(current.item==current.next.item) {
				current.next=current.next.next;
			}else {
				current=current.next;
			}
		}
	}
	
	public void removeKey(int key) {
		if(head==null) {
			return;
		}
		ListNode current=head;
		ListNode temp=null;
		if(current!=null && current.item==key) {
			head=current.next;
			return;
		}
		while(current!=null && current.item!=key) {
			temp=current;
			current=current.next;
		}
		if(current==null) {return;}
		temp.next=current.next;
	}
	
	public void insertNode(int data) {
		ListNode temp=new ListNode(data);
		if(head==null) {
			head=temp;
			System.out.println("liste boş");
		}
		ListNode current=head;
		ListNode newTemp=null;
		while(current!=null && current.item<temp.item) {
			newTemp=current;
			current=current.next;
		}
		temp.next=current;
		newTemp.next=temp;
	}
	
	public static void main(String[] args) {
		LinkedLists3 list=new LinkedLists3();
		list.insertAtBeginning(16);
		list.insertAtBeginning(10);
		list.insertAtBeginning(8);
		list.insertAtBeginning(1);
		
		list.printLinkedLists();
		
		list.insertNode(9);
		System.out.println("**********");
		list.printLinkedLists();
		
	}
}
