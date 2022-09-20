package questionsonarrays;

class Node{
	public int data;
	public Node next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	
}

public class ReversaLinkedList {
	
	private Node head;
	
	public Node insertAtHead(Node head,int data) {
		if(head==null) {
			head=new Node(data);
		}
		return head;
	}
	
	public Node reverseLinkedList(Node head) {
		Node prev=null;
		//next ilk başta head oluyor
		Node next=head;
		Node temp=null;
		
		while(next!=null) {
			//temp head.next oluyor.
			temp=next.next;
			//next'in next değer prev oluyor yani null
			next.next=prev;
			
			//prev head oluyor.
			prev=next;
			//next de head'in gösterdiği sonraki eleman oluyor.
			next=temp;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
