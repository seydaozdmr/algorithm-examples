package algorithms.datastructures;
import algorithms.Queue;
import algorithms.StdOut;

import java.util.Iterator;
import java.util.StringJoiner;

public class ringBuffer<Item> implements Iterable<Item> {
	//Halka kuyruk yapımızda elemanları içersinde tutan Item Generic tipinde ringBuffer dizimiz;
	private Item[]ringBuffer;
	private int size;
	private int first;
	private int last;
	
	//verilerin kuyrukta tutulduğu tampon
	private Queue<Item> producerAuxBuffer;
	private int dataCountToBeConsumed;
	
	@SuppressWarnings("unchecked")
	public ringBuffer(int capacity) {
		//ringBuffer'dan bir nesne ürettiğimiz zaman bir belirtilen capacity miktarı kadar bir dizi oluşturuluyor
		ringBuffer=(Item[]) new Object[capacity];
		size=0;
		this.first=-1;
		last=-1;
		//Bir kuyruk oluşturuluyor
		producerAuxBuffer=new Queue<>();
		dataCountToBeConsumed=0;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	
	public void produce(Item item) {
		if(dataCountToBeConsumed>0) {
			consumeData(item);
			dataCountToBeConsumed--;
		}else {
			if(isEmpty()) {
				ringBuffer[size]=item; //ringBuffer(eğer dizi boşsa) dizisine size sırasında olan elemanı ekler;
				first=0;
				last=0;
				size++;
			}else {
				if(size<ringBuffer.length) {
					if(last==ringBuffer.length-1) {
						last=0;  
					}else {
						last++;
					}
					ringBuffer[last]=item; //ringBuffer dizisinin son elemanına item eklenir;
					size++;
				}else {
					producerAuxBuffer.enqueue(item); //eğer dizi dolu ise eklenmek istenen eleman sona kuyruğa eklenir
				}
			}
		}		
	}
	
	
	
	private void consumeData(Item item) {
	      
	       StdOut.print("Data consumed: " + item);
	}
	
	public Item consume() {
		if(isEmpty()) {
			
			dataCountToBeConsumed++;
			return null;
		}
		
		Item item=ringBuffer[first];
		ringBuffer[first]=null;
		
		if(first==ringBuffer.length-1) {
			first=0;
		}else {
			first++;
		}
		size--;
		
		if(!producerAuxBuffer.isEmpty()) {
			produce(producerAuxBuffer.dequeue());
		}
		return item;
		
	}
	
	
	
	

	public static void main(String[] args) {
		ringBuffer<Integer> ringBuffer=new ringBuffer<>(4);
		ringBuffer.produce(0);
        ringBuffer.produce(1);
        ringBuffer.produce(2);
        ringBuffer.produce(3);
        ringBuffer.produce(4);
        ringBuffer.produce(5);
        
        Integer item1 = ringBuffer.consume();
        if (item1 != null) {
            StdOut.println("Consumed " + item1);
        }
        StdOut.println("Expected: 0\n");
        
        Integer item2 = ringBuffer.consume();
        if (item2 != null) {
            StdOut.println("Consumed " + item2);
        }
        StdOut.println("Expected: 1\n");
        
        ringBuffer.produce(6);
        ringBuffer.produce(7);
        ringBuffer.consume();
        ringBuffer.consume();
        ringBuffer.consume();
        ringBuffer.consume();
        ringBuffer.consume();
        ringBuffer.consume();
        ringBuffer.consume();
        ringBuffer.produce(8);
        ringBuffer.produce(9);
        StringJoiner ringBufferItems = new StringJoiner(" ");
        for (int item : ringBuffer) {
            ringBufferItems.add(String.valueOf(item));
        }

        StdOut.println("Main ring buffer items: " + ringBufferItems.toString());
        StdOut.println("Expected: 2 3 4 5");
	}

	@Override
	public Iterator<Item> iterator() {
		return new RingBufferIterator();
	}
	
	 private class RingBufferIterator implements Iterator<Item> {

	        private int current = first;
	        private int count = 0;

	        @Override
	        public boolean hasNext() {
	            return count < size;
	        }

	        @Override
	        public Item next() {
	            Item item = ringBuffer[current];

	            if (current == ringBuffer.length - 1) {
	                current = 0; //Wrap around
	            } else {
	                current++;
	            }

	            count++;
	            return item;
	        }

	    }

}
