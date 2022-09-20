package org.com.algo.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTopKMostFrequent2 {
	public static List<Integer> kMostFrequent(int[]nums,int k){
		Map<Integer,Integer> countMap=new HashMap<>();
		
		int maxFreq=0;
		for(int i=0;i<nums.length;i++) {
			int freq=countMap.getOrDefault(nums[i], 0)+1;
			countMap.put(nums[i], freq);
			maxFreq=Math.max(maxFreq, freq);
		}
		//bucket oluşturuyoruz. buna elemanların sahip olduğu sıklığa göre bucket'a ekliyoruz.
		@SuppressWarnings("unchecked")
		List<Integer>[]bucket=new List[maxFreq+1];
		
		for(int n:countMap.keySet()) {
			//En üstte tanımladığımız Map(countMap) içerisine yerleştirdiğimiz elemanların sırasıyla key değerine karşılık gelen
			//değeri freq'e atarız örneğin 1 key'inin (ki kendisi n oluyor) değeri:3'dür. 
			int freq=countMap.get(n);
			//bucket'ta bulduğumuz değerin yeri boş ise yeni bir arrayList oluştururuz.
			if(bucket[freq]==null) {
				bucket[freq]=new ArrayList<>();
			}
			//son olarak bucketta bulduğumuz değer karşılık gelen değeri ekleriz örneğin 3 değeri için 1'i ekleriz.
			// daha sonra 2 ve son olarak 3 değerlerinden kaç tane varsa bunlara karşılık gelen yerlere ArrayList'in içine ekleriz. 
			//sonuç olarak elimizde ArrayList'lerden oluşan bir liste olur.
			bucket[freq].add(n);
		}
		//son olarak bucket içerisinde bazı noktalar boş kalmış olabilir bunları düzenli bir şekilde tekrardan liste haline getiriyoruz.
		//yani elimizde bir List [] dizisi vardı ve 0'dan maximum frekansa kadar yer kaplıyordu.
		//biz bunu bir arrayList'e çeviriyoruz sonuç olarak elimizde yalnızca içerisinde liste olan yerlerin kalması için ve yalnıca 
		//k'dan büyük sayıda tekrar eden elemanların kalmasını sağlıyoruz.
		List<Integer> res=new ArrayList<>();
		for(int i=bucket.length-1;i>=0 && k>0;i--) {
			if(bucket[i]!=null) {
				List<Integer>list=bucket[i];
				res.addAll(list);
				k-=list.size();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[]arr= {1,1,1,1,2,2,3,3,3,3,4,4};
		List<Integer>sonuc=kMostFrequent(arr, 3);
		for(int i:sonuc) {
			System.out.println(i);
		}
	}

}
