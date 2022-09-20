package questionsonarrays;

public class maxProfit {
	//bir dizi elamanın sırasıyla alınıp satıldığı sıralamada toplam edilen kazancı hesaplayan metot.
	public static int maxProfitFind(int [] arr) {
		int maxProfitSum=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[i-1]) {
				//ikinci elemandan başlamak üzere eğer i'inci eleman bir önceki elemandan büyük ise aradaki farkı 
				//maxProfitSum değişkenine ekle.
				maxProfitSum+=arr[i]-arr[i-1];
			}
		}
		return maxProfitSum;
	}
	
	//bir dizi üzerinde gerçekleşecek alım satım işleminden gerçekleşecek maksimum kazancı hesaplayan metot.
	
	public static int maxProfit2(int[] arr) {
		int min=Integer.MAX_VALUE;
		int max=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
			if((arr[i]-min)>max) {
				max=arr[i]-min;
			}
		}
		return max;
	}
	
	
	
	

	public static void main(String[] args) {
		int [] arr= {100,180,260,310,40,535,695};
		System.out.println(maxProfitFind(arr));
		System.out.println(maxProfit2(arr));
		int [] arr1= {7,1,5,3,6,4};
		System.out.println(maxProfitFind(arr1));
		System.out.println(maxProfit2(arr1));
	}

}
