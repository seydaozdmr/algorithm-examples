package algorithms;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	
	
	@SuppressWarnings("unchecked")
	private Item a[] =(Item[]) new Object[1];
	private int N=0; //size
	
	public int size() {
		return N;
	}
	
	public void push(Item item) {
		if(N>=a.length) resize(2*a.length);
		a[N++]=item; //N değerini arttırıyoruz.
	}
	
	private void resize(int max) {
		@SuppressWarnings("unchecked")
		Item [] temp=(Item[]) new Object[max];
		for(int i=0;i<a.length;i++) {
			temp[i]=a[i];
		}
		a=temp;
	}
	
	public Item pop(){
		Item item=a[--N];
		a[N]=null;//for Garbage collector
		if(N>0 && N==a.length/4) resize(a.length/2);
		return item;
	}
	
	

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i=N;
		@Override
		public boolean hasNext() {
			return i>0;
		}

		@Override
		public Item next() {
			return a[--i];
		}
		public void remove() {		}
		
	}
	

	public static void main(String[] args) {
		ResizingArrayStack<String> yigin=new ResizingArrayStack<String>();
		
		yigin.push("10");
		yigin.push("11");
		yigin.push("12");
		yigin.push("13");
		yigin.push("14");
		for(String i:yigin) {
			System.out.println(i);
		}
		
		System.out.println(yigin.size());
		
		

	}

}

	
