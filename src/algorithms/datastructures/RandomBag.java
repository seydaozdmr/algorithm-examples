package algorithms.datastructures;

import java.util.Iterator;
import java.util.StringJoiner;

import algorithms.StdOut;
import algorithms.StdRandom;

public class RandomBag<Item> implements Iterable<Item> {
	private Item[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public RandomBag() {
		array=(Item[]) new Object[1];
		size=0;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	public void add(Item item) {
		if(size()==array.length) {
			resize(array.length*2);
		}
		array[size]=item;
		size++;
	}
	
	

	private void resize(int capacity) {
		@SuppressWarnings("unchecked")
		Item[] temp=(Item[]) new Object[capacity];
		for(int i=0;i<array.length;i++) {
			temp[i]=array[i];
		}
		array=temp;		
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new RandomBagIterator();
	}
	
	private class RandomBagIterator implements Iterator<Item>{
		int index;
		Item[] arrayCopy;
		
		@SuppressWarnings("unchecked")
		public RandomBagIterator() {
			index=0;
			arrayCopy=(Item[]) new Object[size];
			for(int i=0;i<size;i++) {
				arrayCopy[i]=array[i];
			}
			sortArrayCopy();
		}

		private void sortArrayCopy() {
			for(int i=0;i<size;i++) {
				int randomIndex=StdRandom.uniform(0,size-1);
				//swap
				Item temp=arrayCopy[i];
				arrayCopy[i]=arrayCopy[randomIndex];
				arrayCopy[randomIndex]=temp;
			}
			
		}

		@Override
		public boolean hasNext() {
			return index<size();
		}

		@Override
		public Item next() {
			Item item=arrayCopy[index];
			index++;
			return item;
		}
		
	}

	
	
	public static void main(String[] args) {
		RandomBag<Integer> canta=new RandomBag<>();
		canta.add(1);
		canta.add(2);
		canta.add(3);
		canta.add(4);
		canta.add(5);
		
		StdOut.print("Random bag items: ");
		
		StringJoiner rastgeleCanta=new StringJoiner(" ");
		for(int i:canta) {
			rastgeleCanta.add(String.valueOf(i));
		}
		System.out.println(rastgeleCanta);

	}

	
}
