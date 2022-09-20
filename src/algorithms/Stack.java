package algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
	//Düğümün static sınıfı 
	//Bu sınıf içerisinde Item tipinde item değeri. Ki Item herhangi bir tip olabilir. 
	//Ve kendi tipinde Node<Item> next nesnesini yığınlar arasında bağ oluşturmak için kullanıyor.
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	//Stack nesnesini yaratıldığında bir tane boş ilk değer oluşturuyoruz.
	private Node<Item> first;
	private int n;
	
	
	//Yığının constructure metodu
	//Constructure metot ilk first nesnesini initilize ediyor. Yani null olarak ilkliyor.
	public Stack() {
		this.first=null;
		this.n=0;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	public int size() {
		return n;
	}
	
	//Stack yığın yapılarında son eklenen eleman ilk çıkartılıyor. Yani LIFO(Last in First out) mantığına göre çalışıyor.
	//Aşağıdaki push metotunda son eklenen eleman başa ekleniyor.
	//Böylece ilk çıkartılması gereken başta olan elemandır.
	//Bu mantık biraz kafa karıştırabilir. Bunun için herzaman son eklenenin nereye eklendiği ve çıkarılan elemanın nereden çıkartıldığına
	//odaklanmak gerekiyor. Bunun tersi olarak son eklenen eleman en sona ve ilk çıkartılan eleman da sondan çıkartılsaydı aynı yere varacaktık.
	public Item pop() {
		if(isEmpty()) throw new NoSuchElementException("Yığın boş");
		//İlk elemanı tutuyoruz.
		Item item=first.item;
		//İkinci eleman ilk oluyor.
		first=first.next;
		n--;
		//Tuttuğumuz elemanı geri döndürüyoruz. Böylece silinen eleman geri dönüyor.
		return item;
	}
	
	public void push(Item item) {
		Node<Item> oldfirst=first;
		first=new Node<Item>();
		first.item=item;
		first.next=oldfirst;
		n++;
	}
	
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("Yığın boş");
		return first.item;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
	}
		
	@Override
	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}
	
	private class LinkedIterator implements Iterator<Item>{
		private Node<Item> current;
		public LinkedIterator(Node<Item> first) {
			current=first;
		}
		public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }	
}
