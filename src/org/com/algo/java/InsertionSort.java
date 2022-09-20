package org.com.algo.java;

public class InsertionSort {
	//zor ve çok güzel bir algoritma
	public static void insertionSort(int[]arr) {
		//dizide gezinirken o an üzerinde bulunan elemanı temp ile tutuyoruz.
		int temp;
		//iç döngünün kaç kez çalışması gerektiğini hesaplayan değişken
		int j;
		//döngüyü ikinci elemandan başlatıyoruz ve her zaman geriye doğru kontrol gerçekleştiriyoruz
		//yani ikinci eleman birinci elemandan küçük mü
		for(int i=1;i<arr.length;i++) {
			temp=arr[i];
			//j mevcut elemandan bir önceki eleman
			j=i-1;
			//j ilk elemana kadar geriye doğru dönüyor
			//ve o an üzerinde işaretlediğimiz eleman bir önceki elemandan küçük ise iki elemanı yer değiştiriyoruz.
			while(j>=0 && temp<arr[j]) {
				//ikinci elemanla birinci elemanı yer değiştiriyoruz.
				arr[j+1]=arr[j];
				j--;
			}
			//j'nin değerini bir düşürdüğümüz için temp'te sakladığımız elemanımızı ilk elemanın yerine atıyoruz.
			arr[j+1]=temp;
		}
	}
	
	
	public static void main(String[] args) {
		int[]arr= {5,4,2,9,1};
		insertionSort(arr);
		for(int i:arr) {
			System.out.println(i);
		}
		
		
	}
}
