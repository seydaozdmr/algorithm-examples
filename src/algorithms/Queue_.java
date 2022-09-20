package algorithms;

import java.util.Arrays;

public class Queue_ {
	private String[] queueArray;
	private int queueSize;
	private int front,rear,numberOfItems=0; //kuyruğun ilk sırası front,sonu rear ve kuyruktaki eleman sayısı numberOfItems.
	
	public Queue_(int size) {
		queueSize=size;
		queueArray=new String[queueSize];
		
		Arrays.fill(queueArray, "-1");
	}
	
	public void insert(String input) {
		if(numberOfItems+1<=queueSize) {
			queueArray[rear]=input;
			rear++;
			numberOfItems++;
			System.out.println("EKLE "+input+" işlemi gerçekleştirilmiştir.");
		}else {
			System.out.println("Bir Hata ile karşılaşıldı. Ekleme gerçekleştirilemedi.");
		}
	}
	public void remove() {
		if(numberOfItems>0) {
			System.out.println("SİL "+queueArray[front]+" elemanı silinmiştir.");
			queueArray[front]="-1";
			front++;
			numberOfItems--;
		}else {
			System.out.println("Kuyruk boş.");
		}
	}
	
	public void siraliEkle(String input) {
		int i;
		if(numberOfItems==0) { //Hiçbir eleman yoksa:
			insert(input);
		}else {
			for(i=numberOfItems-1;i>=0;i--) {
				if(Integer.parseInt(input)<Integer.parseInt(queueArray[i])) { //eklenen elemanları küçükten büyüğe ekle
					queueArray[i+1]=queueArray[i]; 
				}else break;
			}
			queueArray[i+1]=input;
			rear++;
			numberOfItems++;
		}
		
	}
	//Ekrana değerlerin yazılması algoritması
	public void displayTheQueue() {
		for(int n=0;n<61;n++) System.out.print("-");
		System.out.println();
		for(int n=0;n<queueSize;n++) {
			System.out.format("| %2s "+" ",n);
		}
		
		System.out.println("|");
		
		for(int n=0;n<61;n++) {
			System.out.print("-");
		}
		System.out.println();
		for(int n = 0; n < queueSize; n++){
			if(queueArray[n].equals("-1")) System.out.print("|     ");
			else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
		}
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
		
		int spacesBeforeFront = 3*(2*(front+1)-1);
		for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
		System.out.print("F");
		
		int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
		for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");
		System.out.print("R");
		System.out.println("\n");
	}
	
	public void peek() {
		System.out.println("İlk Eleman: "+queueArray[front]);
	}

	public static void main(String[] args) {
		Queue_ kuyruk=new Queue_(10);
		kuyruk.siraliEkle("10");
		kuyruk.siraliEkle("20");
		kuyruk.siraliEkle("15");
		kuyruk.siraliEkle("12");
		kuyruk.siraliEkle("11");
		kuyruk.siraliEkle("17");
		kuyruk.siraliEkle("7");
		kuyruk.siraliEkle("19");
		kuyruk.siraliEkle("18");
		kuyruk.siraliEkle("5");
		kuyruk.displayTheQueue();

	}

}
