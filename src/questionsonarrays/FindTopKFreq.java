package questionsonarrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTopKFreq {
	//bir dizide belirli bir miktardan daha çok tekrar eden elemanları bulma
	//bulduğumuz elemanları liste olarak geriye döndüreceğiz
	public static List<Integer> findK(int[] arr,int key){
		Map<Integer,Integer> countElem=new HashMap<>();
		
		int maxFreq=0;
		for(int i=0;i<arr.length;i++) {
			//countElem listesinde arr[i]'ye karşılık gelen elemanı bulup onun value değerini bir arttırıp freq değişkenine atıyoruz.
			int freq=countElem.getOrDefault(arr[i], 0)+1;
			//countElem listesine arr[i] değerimize karşılık gelen freq değerini atıyoruz.
			countElem.put(arr[i],freq);
			//en fazla tekrar eden eleman sayısını buluyoruz.
			maxFreq=Math.max(maxFreq, freq);
		}
		//tekrar eden elemanların değerlerini listeler halinde tutmak için bucket listesini oluşturuyoruz.
		@SuppressWarnings("unchecked")
		List<Integer>[] bucket=new List[maxFreq+1];
		//countElem listesindeki keyset üzerinde iterasyon yapıyoruz
		for(int n:countElem.keySet()) {
			//n elemanına karşılık gelen sıklık değerini buluyoruz yani value değerini
			int freq=countElem.get(n);
			//eğer bucket'in sıklık değerine karşılık gelen elemanı boş ise bir ArrayList oluşturuyoruz.
			if(bucket[freq]==null) {
				bucket[freq]=new ArrayList<>();
			}
			bucket[freq].add(n); //sıklığa karşılık gelen n değerini bucket'in içindeki ArrayList'e ekliyoruz.			
		}
		
		List<Integer> result=new ArrayList<>();
		for(int i=bucket.length-1;i>=0 && key>0;i--) {
			if(bucket[i]!=null) {
				List<Integer> liste=bucket[i];
				result.addAll(liste);
				//yalnızca key'değerinden fazla sayıda eleman topladığımız için key'değerinden liste'ye eklediğimiz eleman sayısını çıkartıyoruz.
				key-=liste.size();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[]arr= {1,1,1,1,2,2,2,3,3,4,4,4,4,4,5,5,5,5,6};
		//en fazla elemanı olan 3 eleman
		List<Integer> result=findK(arr,3);
		for(int elem:result) {
			System.out.println(elem);
		}

	}

}
/**
 * great Video man !!
	But just a doubt, if we take array as {1,1,1,2,2,3,3,3,4,4} and k=3  
	the answer turns out to be 1,3,2,4  but we need only 3 elements. How could that be solved.?

	Answer:
	Here the frequency of 1 and 3 are same so i am counting them as one 
	(As both are in same bucket). You can also solve this by using Priority Queue. Here is the code.public 

	The other way for finding the kth largest element is to use Heap Data structure. 
	What you can do is to create a max heap and extract element k times to find kth largest element.


	int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> largest = new PriorityQueue<>(Collections.reverseOrder());
    // build a binary max heap PQ with numbers of the array. O(nlogn) 
 	for (int num : nums){
        largest.add(num);    
    }
 
    // extract the largest element k times. 
 	// worst case k = n ; extract-max = O ( logn ) => total O ( n logn)
    int kthLargest = largest.poll();
    for(int i = 0; i < k - 1; i++){
        kthLargest = largest.poll();
    }
    return kthLargest;
    }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
