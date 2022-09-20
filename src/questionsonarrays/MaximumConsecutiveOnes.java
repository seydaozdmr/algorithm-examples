package questionsonarrays;

public class MaximumConsecutiveOnes {
	//Güzel algoritma
	//0'lar ve 1'lerden oluşan bir array dizi
	//0 lardan k kadarını dahil etmek şartıyla sıralı şekilde 0 ve 1'lerden oluşan en büyük alt dizinin eleman sayısını bulmaya çalışıyoruz.
	public static int count(int []arr,int k) {
		int maxConsecutive=0;
		//Bu tarz algoritmalarda sliding window kullanmamız gerekir bunun içinde biz diziyi içerisinde gezen sliding windows oluşturabilmek için
		//start noktası ve end noktası olması gerekiyor. iki nokta arasındaki elemanları hesaplayabilmemiz için
		int start=0;
		int zeroCount=0;
		
		for(int end=0;end<arr.length;end++) {
			//sıradaki 0'ı saymak için kullanıyoruz.
			if(arr[end]==0) {
				zeroCount++;
			}
			//k istenen maximum 0 sayısı eğer sayılan 0 sayısı maksimum değeri geçmiş ise saymaya tekrardan başlamamız lazım.
			//örneğin k=2 ise k 3 e geldiğinde sliding windows'u 0 sayısı 2 ye düşene kadar sıfırlayıp (start'ı) tekradan elemanları saymamız gerekir.
			while(zeroCount>k) {
				//tekrardan maximum değerinde altındaki 0'ları dahil ederek sayabilmek için start değerini maximum 0'ın altına
				//düşene kadar start'ı arttırıyorum.
				if(arr[start]==0) {
					zeroCount--;
				}
				start++;
			}
		
			//her bir işlem sırasında maximum devam eden sırayı tekrar hesaplamamız gerekir.
			maxConsecutive=Math.max(maxConsecutive, end-start+1);
		}
		return maxConsecutive;
	}

	public static void main(String[] args) {
		int arr[]= {1,1,0,0,0,1,1,1,1,1};
		System.out.println(count(arr,0));

	}

}
