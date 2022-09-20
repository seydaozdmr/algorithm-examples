package org.com.datastructures.seyda;
class Queue_{
	int capacity=4;
	int[] dizi=new int[capacity];
	int last=0; //last
	int first=0; //first
	
	public void resize(int capacity){
		int[]temp=new int[capacity];
		for(int i=0;i<(last-first);i++) {
			temp[i]=dizi[first+i];
		}
		dizi=temp;
	}
	//Sıradan eleman çıkarma
	int deque() {
		if(last==first) {
			System.out.println("sıra boş");
			return -1;
		}
		System.out.println("boyut1: "+capacity+"son eleman: "+last+"ilk eleman: "+first+"fark : "+(last-first));
		if(last-first<=capacity/4) {
			int tempcapacity=capacity/2;
			resize(tempcapacity);
			last-=first;
			first=0;
			capacity=capacity/2;
		}
		
		//sira--;
		return dizi[first++];
	}
	
	//Diziyi toparlamak için kullanılacak kodlar.
	void toparla() {
		if (first==0)
			return;
		for(int i=0;i<=last;i++) {
			//System.out.println(dizi[i]);
			dizi[i]=dizi[i+first];
		}
		last-=first;
		first=0;
		System.out.println("boyut1: "+capacity+"son eleman: "+last+"ilk eleman: "+first+"fark : "+(last-first));
	}
	//Sıraya eleman ekleme
	void enque(int data) {
		//Eğer dizinin kapasitesi kadar eleman eklersek, kapasiteyi iki katına çıkarıyoruz.
		if(last>=capacity) {
			int tempcapacity=capacity*2;
			resize(tempcapacity);
			capacity*=2;
		}
		dizi[last++]=data;
	}
	//For show array(dizi)
	void show() {
		for(int i=first;i<capacity;i++) {
			System.out.println(dizi[i]);
		}
	}
}

public class QueueSadiHoca {

	public static void main(String[] args) {
		Queue_ kuyruk=new Queue_();
		//System.out.println(kuyruk.sirabasi);
		//kuyruk.toparla();
		//System.out.println("sira: "+kuyruk.sira);
		//System.out.println("Toplarla:");
		//kuyruk.show();
		System.out.println("*********SHOW*********");
		for(int i=0;i<20;i++) {
			kuyruk.enque(i);
		}
		
		kuyruk.show();
		System.out.println("boyut2: "+kuyruk.capacity+"sira: "+kuyruk.last+"sirabasi: "+kuyruk.first+"fark : "+(kuyruk.last-kuyruk.first));
		for(int i=0;i<13;i++) {
			kuyruk.deque();
		}
		System.out.println("*********SHOW*********");
		kuyruk.show();
		System.out.println("boyut3: "+kuyruk.capacity+"sira: "+kuyruk.last+"sirabasi: "+kuyruk.first+"fark : "+(kuyruk.last-kuyruk.first));
		kuyruk.toparla();
		kuyruk.show();
	}

}
