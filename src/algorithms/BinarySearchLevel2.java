package algorithms;

import java.util.Arrays;

public class BinarySearchLevel2 {

	public static void main(String[] args) {
		//1-Bir sayı dizisi oluşturuyoruz.
		int[]array= {1, 2, 4, 4, 5, 6, 6, 7, 7, 7, 8};
		//2-Diziyi küçükten büyüğe doğru sıralıyorz.
		Arrays.sort(array);
		System.out.println("array:"+array.toString());
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		System.out.println("Arama: "+rank(5,array));
	}
	//3-Bir dizi ve bir anahtar değeri alan ve anahtar değerinden kaç tane küçük eleman olduğunu bulan rank fonksiyonu:
	public static int rank(int key,int[]array) {
		//anahtar ve dizi parametreleri ile 0'dan array'in eleman sayısını parametre olarak diğer rank fonksiyonunu geri dönüş değeri olarak belirliyoruz.
		return rank(key,array,0,array.length-1);
	}
	private static int rank(int key, int[] array, int lo, int hi) {
		if(lo<=hi) {
			int middle=lo+(hi-lo)/2;
			System.out.println("middle:"+middle);
			//Dizinin sağ bölümünde ve sol bölümünde key değerini arıyor.
			
			if(key<array[middle]) {
				System.out.println("key değeri array'in orta değerinden küçüktür.");
				return rank(key,array,lo,middle-1);
			}else if(key>array[middle]) {
				//key değeri orta değerden büyükse, orta değerin üstünde rightIndex araması yapıyoruz.
				int rightIndex=rank(key,array,middle+1,hi);
				System.out.println("rightIndex değeri:"+rightIndex);
				if(rightIndex==-1) {
					System.out.println("middle:"+middle);
					return middle+1;
				}else {
					return rightIndex;
				}
			}else {
				int leftIndex=rank(key,array,lo,middle-1);
				System.out.println("leftIndex değeri:"+leftIndex);
				if(leftIndex==-1) {
					System.out.println("middle:"+middle);
					return middle;
				}else {
					return leftIndex;
				}
			}	
		}
		return -1;
	}
	
	

}
