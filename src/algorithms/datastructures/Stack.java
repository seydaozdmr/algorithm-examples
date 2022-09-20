package algorithms.datastructures;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	
	private class Node{
		Item item;
		Node next;
	}
	
	private Node head; //first
	private int N; //size
	public boolean isEmpty() {
		return head==null;
	}
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		Node temp=new Node();
		temp.item=item;
		temp.next=head;
		head=temp;
		N++;
	}
	
	public Item pop() {
		if(isEmpty()) {
			throw new RuntimeException("Yığın Boş.");
		}
		Item item=head.item;
		head=head.next;
		N--;
		return item;
	}
	public Item peek() {
		if(isEmpty()) return null;
		
		return head.item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item>{
		private Node current=head;
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public Item next() {
			Item item=current.item;
			current=current.next;
			return item;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
