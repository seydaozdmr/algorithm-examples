package algorithms.datastructures;

import java.util.Iterator;
import java.util.StringJoiner;

import algorithms.StdOut;
@SuppressWarnings("unchecked")
public class QueueDeleteK<Item> implements Iterable <Item> {
	private Item[]array;
	private int size;
	
	
	public QueueDeleteK() {
		array=(Item[]) new Object[1];
		size=0;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	
	public void enqueue(Item item) {
		if(size==array.length) {
			resize(array.length*2);
		}
		array[size]=item;
		size++;
	}
	
	public Item delete(int k) {
		if(isEmpty()) {
			throw new RuntimeException("Kuyruk boş");
		}
		if(k<=0 || size<k) {
			throw new RuntimeException("Geçersiz index");
		}
		Item item=array[k-1];
		moveItemsLeft(k);
		size--;
		
		if(size==array.length/4) {
			resize(array.length/2);
		}
		return item;
	}
	

	private void moveItemsLeft(int k) {
		//bütün elemanları sola kaydırarak istediğimiz index numarasına ait elemanı silmiş oluyoruz.
		for(int i=k;i<size;i++) {
			array[i-1]=array[i];
		}
		array[size-1]=null; //son eleman null olmalı
		
	}

	private void resize(int capacity) {
		Item []temp=(Item[]) new Object[capacity];
		for(int i=0;i<array.length;i++) {
			temp[i]=array[i];
		}
		array=temp;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new GeneralizedQueueIterator();
	}
	
	private class GeneralizedQueueIterator implements Iterator<Item>{
		private int index=0;
		@Override
		public boolean hasNext() {
			return index<size;
		}

		@Override
		public Item next() {
			Item item=array[index];
			index++;
			return item;
		}
		
	}
	
	public static void main(String[] args) {
		QueueDeleteK<Integer> kuyruk =new QueueDeleteK<>();
		kuyruk.enqueue(0);
		kuyruk.enqueue(1);
		kuyruk.enqueue(2);
		kuyruk.enqueue(3);
		kuyruk.enqueue(4);
		
		kuyruk.delete(1);
		kuyruk.delete(3);
		
		StringJoiner generalizedQueueItems = new StringJoiner(" ");
        for (int item : kuyruk) {
            generalizedQueueItems.add(String.valueOf(item));
        }
        
        StdOut.println("Generalized queue items: " + generalizedQueueItems.toString());
        StdOut.println("Expected: 1 2 4");


	}
	

}
