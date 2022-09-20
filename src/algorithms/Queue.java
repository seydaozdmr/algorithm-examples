package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue <Item> implements Iterable<Item> {
	//Queue yapısında yeni eleman sona ekleniyor, ve sıradaki ilk eleman ilk çıkarılıyor. FIFO (first in first out) mantığı ile.
	private Node<Item> first;
	private Node<Item> last;
	private int n;
	
	//Node static sınıfı <Item> tipinde bir item değeri tutuyor. Ki Item herhangi bir tip olabilir. 
	//Node static metodu içerisinde kendi türünden Node<Item> next nesnesini tutuyor. Bu nesne kuyruğu oluştururken sıradaki elemanla
	//olan bağın oluşturulmasına yarıyor.
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	//Kuyruk oluşturulurken ilk ve son düğümler oluşturuluyor. Ve bunların üzerinde işlem yapılabilmesi için sürekli tutuluyor.
	public Queue() {
		this.first=null;
		this.last=null;
		this.n=0;
	}
	
	public boolean isEmpty() {
		return first ==null;
	}
	
	public int size() {
		return n;
	}
	
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("Kuyruk boş");
		return first.item;
	}
	
	//Adds the item to this queue
	public void enqueue(Item item) {
		Node<Item> oldlast=last;
		last=new Node<Item>();
		last.item=item;
		last.next=null;
		if(isEmpty()) first=last;
		//Bu şekilde son elemanı sürekli tutmuş oluyoruz.
		else oldlast.next=last;
		//n eleman sayısı
		n++;
	}
	//Eleman çıkartılırken kuyuktaki ilk eleman önce çıkartılıyor. 
	//Daha sonra ilk eleman ilk elemanın next'i oluyor.
	public Item dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Kuyruk boş");
		//kuyruğun ilk değeri tutuluyor.
		Item item =first.item;
		//kuyruğun yeni ilk değeri ilk değerin next'i olan 2.değer oluyor.
		first=first.next;
		//n eleman sayısı 1 azaltılıyor.
		n--;
		if(isEmpty()) last=null; //eğer kuyruk boşalmış ise last=null olarak boş atanıyor.
		//item değerinde tutulan ilk elemanın item değeri geri döndürülüyor.
		return item;
	}
	
	public String toString() {
		StringBuilder s=new StringBuilder();
		//this oluşturulan Queue nesnesi.
		for(Item item:this) {
			s.append(item);
			s.append(" ");
		}
		return s.toString();
	}	
	
	@Override
	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}
	
	//Kuyruk elemanları üzerinde gezinmemize yarayan iterator nesnesi.
	public class LinkedIterator implements Iterator<Item>{
		private Node<Item> current;
		
		public LinkedIterator(Node<Item> first) {
			current=first;
		}
		public boolean hasNext() {
			return current!=null;
		}
		public void remove() {
			throw new UnsupportedOperationException();  
		}
		
		public Item next() {
			if(!hasNext()) throw new  NoSuchElementException();
			Item item=current.item;
			current=current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		Queue<String> queue = new Queue<String>();
		while(!StdIn.isEmpty()) {
			String item=StdIn.readString();
			if(!item.equals("-"))
				queue.enqueue(item);
			else if(!queue.isEmpty())
				StdOut.print(queue.dequeue()+" ");
			for(String i : queue) {
				System.out.println(i);	
			}
		}
		StdOut.println("(" + queue.size() + " left on queue)");
	}



}
