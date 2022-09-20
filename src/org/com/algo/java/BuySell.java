package org.com.algo.java;

public class BuySell {
	
	public static int buySell(int []arr) {
		int min=Integer.MAX_VALUE;
		int max=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
			if(arr[i]-min>max) {
				max=arr[i]-min;
				System.out.println("max: "+max);
			}
		}
		return max;
	}
	
	public static int getMaxProfit(int []arr) {
		//her bir adımda en düşük ve en yüksek fiyatları hesaplamamız gerekiyor. Bunun için en düşük ve en yüksek değişkenleri oluşturuyorum
		int low=0;
		int high=0;
		//iterasyon yapmak için değişkenlerimi oluşturuyorum
		int i=0;
		int end=arr.length-1;
		//sonucu tutan değişken
		int maxProfit=0;
		//baştan sona diziyi geziyorum
		while(i<end) {
			//ilk adım olarak en düşük değeri bulmaya çalışıyorum
			while(i<end && arr[i]>=arr[i+1]) {
				//mevcut işaretliğimiz arr[i] değeri bir sonrakinden büyük olduğu sürece gezmeye devam ediyoruz, küçük olduğu noktada duruyoruz.
				i++;
			}
			//küçük olduğu noktada low değerimizi işaretliyoruz
			low=arr[i];
			//aynı işlemi high için de yapıyoruz
			while(i<end && arr[i]<=arr[i+1]) {
				i++;
			}
			//işaretliğimiz eleman bir sonraki elemandan büyük olduğu noktada duruyor ve bu bizim sıradaki en büyük değerimiz oluyor
			high=arr[i];
			
			//elde ettiğimiz maximum kazancı hesaplıyoruz
			
			maxProfit+=high-low;
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] arr= {7,1,5,3,6,4};
		System.out.println(buySell(arr));
		System.out.println(getMaxProfit(arr));
	}

}
