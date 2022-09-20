package org.com.algo.java;

public class SelectionSort {
	private static void sort(int[]arr) {
		
		//dizi içinde geziniriz
		for(int i=0;i<arr.length;i++) {
			//sıradaki index değerini minimum olarak işaretleriz. 
			int min=i;
			//sıradaki değerin bir sonrasından başlamak üzere sırasıyla diziyi gezeriz
			//ki bu sırasıyla başlangıç sırasının artacağını ve gezilecek eleman sayısının azalacağını gösterir.
			for(int j=i+1;j<arr.length;j++) {
				if(arr[min]>arr[j]) {
					//sırasıyla gezerken minimum index değerini güncelliyoruz.
					min=j;
				}
			}
			//en bulunan en küçük değer ile gezilen sıradaki değeri değiştiririz.
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			
		}
		
	}
	
	public static void selectionSort(int []arr) {
		for(int i=0;i<arr.length;i++) {
			int min=i; 
			for (int j = i+1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
			
		}
	}

	public static void main(String[] args) {
		int[]arr= {5,4,2,9,1};
		selectionSort(arr);
		for(int i:arr) {
			System.out.println(i);
		}

	}

}
