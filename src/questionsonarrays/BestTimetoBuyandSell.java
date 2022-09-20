package questionsonarrays;

public class BestTimetoBuyandSell {
	
	public static int getMaxProfit(int []arr) {
		int low=0;
		int hi=0;
		int i=0;
		int result=0;
		
		while(i<arr.length-1) {
			while(i<arr.length-1 && arr[i]>=arr[i+1]) {
				//arr[i] bir sonraki değerden büyük olduğu sürece i'yi 1 arttır
				//böylece kendinden büyük bir değer geldiği zaman low değerini buna ver.
				i++;
			}
			low=arr[i];
			
			while(i<arr.length-1 && arr[i]<=arr[i+1]) {
				//daha sonra arr[i] kendinden bir sonraki değerden küçük mü?
				//bunu sorgula kendinen sonrakiden küçük olana kadar i'yi bir arttır.
				//sıralamada olabilecek sıradaki en büyük değeri bulana kadar devam ediyoruz.
				i++;
			}
			//işlem sonunda bulunan büyük değeri hi değerine ata..
			hi=arr[i];
			
			result+=hi-low;
		}
		return result;
	}

	public static void main(String[] args) {
		int[]arr= {7,3,2,5,1,2,5,6,7,8};
		
		System.out.println(getMaxProfit(arr));

	}

}
