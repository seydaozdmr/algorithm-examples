package org.com.datastructures.seyda;

import java.util.Iterator;
import java.util.NoSuchElementException;

import algorithms.StdIn;
import algorithms.StdOut;

public class Bag<Item> implements Iterable<Item> {
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
		
	private Node<Item> head;
	private int n;//number of elements
	
	public Bag() {
		//bag'den bir nesne yarattığımızda head değerini null olarak atıyoruz. 
		this.head=null;
		this.n=0;
	}
	
	public boolean isEmpty() {
		return head==null; // ilk değer boş ise isEmpty true değer döndürür.
	}
	
	public int size() {
		return n;
	}
	
	public void add(Item item) {
		System.out.println("item: "+item);
		//x' head'de bulunan eleman
		Node<Item> x=head;
		//head yeni bir item
		head=new Node<Item>();
		//yeni elemanın item değeri yeni eklenen item değeri
		head.item=item;
		//yeni elemanın next değeri önce head'de bulunan değer
		head.next=x;
		this.n++;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new LinkedIterator(head);
	}
	
	private class LinkedIterator implements Iterator<Item>{
		private Node<Item> current;
		public LinkedIterator(Node<Item> head) {
			//current iteratörün başladığını değer ki bu head oluyor.
			current=head;
		}
		
		public boolean hasNext() {
			//current null olmadığı sürece hasNext() true değer döndürür
			return current!=null;
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
		public Item next() { //Item değer döndüren next metodu
			if(!hasNext()) throw new NoSuchElementException();
			//hasNext true ise: item current.item 
			Item item=current.item;
			//gezen current nesnemizde current'in next'ine geçiyor.
			current=current.next;
			//item değeri geri döndürülüyor.
			return item;
		}
	}
	
	
	 public static void main(String[] args) {
	        Bag<String> bag = new Bag<String>();
	        while (!StdIn.isEmpty()) {
	            String item = StdIn.readString();
	            bag.add(item);
	        }

	        StdOut.println("size of bag = " + bag.size());
	        for (String s : bag) {
	            StdOut.println(s);
	        }
	    }

}
