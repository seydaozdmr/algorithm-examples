package algorithms.datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringJoiner;


import algorithms.StdOut;

public class MoveToFront<Item> implements Iterable<Item>  {
	private class Node{
		Item item;
		Node next;
	}
	
	private Node first;
	private int size;
	
	private Set<Item> varOlanKarakterler;
	
	public MoveToFront() {
		varOlanKarakterler=new HashSet<>();
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	

	public void insert(Item item) {
		//Eğer eklemeye çalıştığımız karakter varOlanKarakterler isimli HashSet'te bulunuyorsa karakteri bağlı listeden sil.
		if(varOlanKarakterler.contains(item)) {
			delete(item);
		}
		Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		
		varOlanKarakterler.add(item);
		size++;
	}
	

	private void delete(Item item) {
		if(isEmpty()) {
			return;
		}
		Node current=first;
		
		if(current.item.equals(item)) {
			first= current.next;
			size--;
		}else {
			for(current=first;current.next!=null;current=current.next) {
				if(current.next.item.equals(item)) {
					break;
				}
			}
			
			if(current.next!=null) {
				current.next=current.next.next;
				size--;
			}
		}
		
	}

	public static void main(String[] args) {
		MoveToFront<Character> moveToFront=new MoveToFront<>();

		moveToFront.insert('a');
		moveToFront.insert('b');
		moveToFront.insert('c');
		moveToFront.insert('d');
		moveToFront.insert('c');
		moveToFront.insert('d');
		moveToFront.insert('z');

		StringJoiner list = new StringJoiner(" ");

		for (char character : moveToFront) {
			list.add(String.valueOf(character));
		}

		StdOut.println("Characters: " + list.toString());
		// StdOut.println("Expected: z d c b a");

	}

	@Override
	public Iterator<Item> iterator() {
		return new MoveToFrontIterator();
	}
	
	private class MoveToFrontIterator implements Iterator<Item> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
	

}
