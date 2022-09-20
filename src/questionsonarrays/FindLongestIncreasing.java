package questionsonarrays;

public class FindLongestIncreasing {
	
	public static int findLength(int[] arr) {
		
		if(arr.length==0) {
			return 0;
		}
		int len=1;
		int maxLen=1;
		
		for(int i=1;i<arr.length;i++) {
			//eğer dizinin birinci elemanından başlamak üzere eğer dizinin i. elemanı ondan önce gelen gelen elemandan
			//büyük ise len yani uzunluk değerini bir arttır. böylece ortada sürekli devam eden, ardı sıra gelen bir 
			//seri başlamış olur.
			if(arr[i-1]<arr[i]) {
				len++;
			}else {
				//değilse len'i tekrar 1'e eşitleyerek seriyi sıfırla.
				len=1;
			}
			//yukarıda elde ettiğimiz len değerini maxLen değeri ile kıyaslıyoruz, büyük ise maxLen'i güncelliyoruz.
			maxLen=Math.max(len, maxLen);
		}
		return maxLen;
	}
	
	

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,2,3,1,4,5,0};
		System.out.println(findLength(arr));

	}

}
