package algorithms.datastructures;

import algorithms.StdOut;
import algorithms.StdRandom;
@SuppressWarnings("unchecked")
public class RandomQueue {
	//RandomQ inner class olarak tanımlanıyor. <Item> Generic olarak tanımlanıyor.
	public class RandomQ<Item>{
		private Item[] items;
		private int size;
		
		public RandomQ() {
			items=(Item[]) new Object[1];
			size=0;
		}
		
		public boolean isEmpty() {
			return size==0;
		}
		
		public int size() {
			return size;
		}
		//yeni eleman en sona ekleniyor...
		public void enqueue(Item item) {
			if(size==items.length) {
				resize(items.length*2);
			}
			//eklenen son eleman sona ekleniyor
			items[size]=item;
			size++;
		}
		//Elemanları çıkartırken liste içerisinden rastgele bir eleman seçiyor,
		//Bu elemanın index değerine son eleman atanıyor,
		//Son eleman siliniyor
		//Rastgele seçilen eleman geri değer olarak döndürülüyor.
		public Item dequeue() {
			if(isEmpty()) {
				throw new RuntimeException("Kuyruk boş");
			}
			
			int randomIndex=StdRandom.uniform(0,size);
			
			Item randomItem=items[randomIndex];
			
			items[randomIndex]=items[size-1]; //rastgele seçilen elemanın değeri son elemanın değeri oluyor.
			
			items[size-1]=null; //son eleman siliniyor.
			size--;
			
			if(size>0 && size==items.length/4) {
				resize(items.length/2);
			}
			return randomItem;
		}
		
		public Item sample() {
			if(isEmpty()) {
				throw new RuntimeException("kuyruk boş...");
			}
			//Rastgele bir eleman seçiliyor.
			int randomIndex=StdRandom.uniform(0,size);
			return items[randomIndex];
		}
		
		private void resize(int capacity) {
			Item []temp=(Item[]) new Object[capacity];
			
			for(int i=0;i<size;i++) {
				temp[i]=items[i];
			}
			items=temp;
		}
	}
	
	//RandomQ tipinde aldığı randomKuyruk nesnesini Card nesneleri ile doldurmak üzere fillQueueWithBridgeHandsCards isminde static metodu yazıyoruz.
	
	@SuppressWarnings("rawtypes")
	private static void fillQueueWithBridgeHandsCards(RandomQ randomKuyruk) {
		String [] suits= {"Spades", "Hearts", "Diamonds", "Clubs"};
		
		for(int i=0;i<suits.length;i++) {
			randomKuyruk.enqueue(new Card("A",suits[i]));
			randomKuyruk.enqueue(new Card("2", suits[i]));
			randomKuyruk.enqueue(new Card("3", suits[i]));
			randomKuyruk.enqueue(new Card("4", suits[i]));
			randomKuyruk.enqueue(new Card("5", suits[i]));
			randomKuyruk.enqueue(new Card("6", suits[i]));
			randomKuyruk.enqueue(new Card("7", suits[i]));
			randomKuyruk.enqueue(new Card("8", suits[i]));
			randomKuyruk.enqueue(new Card("9", suits[i]));
			randomKuyruk.enqueue(new Card("10", suits[i]));
			randomKuyruk.enqueue(new Card("J", suits[i]));
			randomKuyruk.enqueue(new Card("Q", suits[i]));
			randomKuyruk.enqueue(new Card("K", suits[i]));
		}
	}
	//Card tipinde static bir sınıf yaratıyoruz.
	//Bu tip iki String değişkene sahip bunlar value ve suit. Suit(Spades,Hearts,Diamonds,Clubs) Kartların türünü value ise (A,2,3,4,5,6,7,8,9,10,J,Q,K) 
	//olmak üzere kartların değerini tutuyor.
	private static class Card{
		String value;
		String suit;
		
		public Card(String value,String suit) {
			this.value=value;
			this.suit=suit;
		}
		
		@Override
		public String toString() {
			return value+"-"+suit;
		}
	}

	public static void main(String[] args) {
		//Önce RandomQ tipinde bir nesne yaratabilmek için baseclasstan bir örnek yaratılıyor.
		RandomQueue kuyruk=new RandomQueue();
		//yaratılan kuyruk nesnesinden RandomQ nesnesi örnek olarak yaratılıyor.
		RandomQ<Card> randomKuyruk=kuyruk.new RandomQ<>();
		
		//randomKuyruk nesnesi kartlarla dolduruluyor.
		fillQueueWithBridgeHandsCards(randomKuyruk);
		//İki defa el dağıtılıyor.
		for(int i=0;i<3;i++) {
			int count=0;
			//
			StdOut.println((i+1)+" .El");
			//13 defa randomKuyruk nesnesinden rastgele kart seçiliyor.
			while(count<13) {
				StdOut.println(randomKuyruk.dequeue());
				count++;
			}
			StdOut.println();
		}
		
		Card sample=randomKuyruk.sample();
		StdOut.println("Size before sample: " + randomKuyruk.size + " Expected: 26");
        StdOut.println("Random item: " + sample);
        StdOut.println("Size after sample: " + randomKuyruk.size + " Expected: 26");

	}

}
