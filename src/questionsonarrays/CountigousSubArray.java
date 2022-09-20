package questionsonarrays;

import java.util.HashMap;
import java.util.Map;

public class CountigousSubArray {
	//yalnızca 0 ve 1 lerden oluşan bir dizi içerisinde eşit sayıda 0 ve 1 lerin bulunduğu alt dizi en çok kaç eleman barındırır
	
	public static int findSub(int[]arr) {
		Map<Integer,Integer> mp=new HashMap<>();
		//liste içerisindeki 0 ların karşılığına -1, 1 lerin karşılığına 1 yazıyoruz ve sırayla toplayıp toplamlarının
		//0 olmasını bekliyoruz. böylece 0 ve 1 lerin aynı sayıda olmasını sağlıyoruz.
		mp.put(0, -1);
		
		int sum=0;
		int maxLen=0;
		
		for(int i=0;i<arr.length;i++) {
			//0 ile karşılaşırsak toplamı -1 ekliyoruz
			if(arr[i]==0) {
				sum+=-1;
			}else {
				//1 ile karşılaşırsak toplamları 1 arttırıyoruz.
				sum+=1;
			}
			//eğer toplam değeri map içerisinde var ise
			//bu şu anlama geliyor toplamları 0 olan elemanlar bir alt dizi oluşturuyor.
			if(mp.containsKey(sum)) {
				maxLen=Math.max(maxLen, i-mp.get(sum)); //sum'in karşılığındaki son değeri bulunduğumuz sıradan çıkartıyoruz.
			}else {
				//eğer ilk defa toplamları 0 olan bir grupla karşılaşmış isek:
				mp.put(sum, i);
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		int[]arr= {1,0,1,1,1,0,0};
		System.out.println(findSub(arr));

	}

}
