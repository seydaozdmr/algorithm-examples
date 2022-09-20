package algorithms;


public class MyNodeStack {
	public class Node{
		String item;
		Node next;
	}
	private Node head;
	private int N=0;
	
	public int size() {
		return N;
	}
	public boolean isEmpty() {
		return head==null;
	}
	
	public void addFirst(String item) {
		Node n=new Node();
		n.item=item;
		if(head==null) {
			head=n;
			N++;
		}else {
			Node temp=head;
			head=n;
			n.next=temp;
			N++;
		}
	}
	
	public void addLast(String item) {
		Node n=new Node();
		n.item=item;
		n.next=null;
		
		if(head==null) {
			head=n;
		}else {
			Node temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=n;
		}
	}
	
	public Node deleteAtFirst() {
		Node temp=head; //ilk elemanı temp'te tutuyoruz
		head=head.next;//ilk elemanı ilk elemanının next'i yapıyoruz.
		N--;
		return temp;//temp'te tutulan ilk elemanı geri döndürüyoruz.
	}
	
	

	public static void main(String[] args) {
		MyNodeStack mynode=new MyNodeStack();
		mynode.addFirst("to");
		mynode.addFirst("be");
		mynode.addFirst("or");
		
		System.out.println(mynode.head.item);
		System.out.println(mynode.head.next.item);
		System.out.println(mynode.head.next.next.item);
		
		System.out.println(mynode.size());
		System.out.println(mynode.isEmpty());
		
	}

}
