package algorithms;

public class MyNodeQueue {
	
	private class Node{
		@SuppressWarnings("unused")
		String item;
		Node next;
	}
	
	private Node first;
	private Node last;
	private int N=0;
	
	public int size() {
		return N;
	}
	private boolean isEmpty() {
		return first==null;
	}
	
	public void enqueue(String item) {
		Node oldlast=last;
		Node last=new Node();
		last.item=item;
		last.next=null;
		if(first==null) {
			first=last;
		}else {
			oldlast.next=last;
		}
		N++;
	}
	
	public Node dequeue() {
		Node temp=first;
		first=first.next;
		N--;
		if(isEmpty()) last=null;
		return temp;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
