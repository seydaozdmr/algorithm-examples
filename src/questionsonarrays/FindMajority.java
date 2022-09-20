package questionsonarrays;

import java.util.HashMap;
import java.util.Map;

public class FindMajority {
	public static int Find(int [] arr) {
		Map<Integer,Integer> liste=new HashMap<>();
		//hashmap'e arr dizimizdeki elemanların bulunma sıklığını ekliyoruz.
		for(int i=0;i<arr.length;i++) {
			int j=liste.getOrDefault(arr[i], 0)+1;
			liste.put(arr[i],j);
		}
		
		int val=arr.length/2;
		Integer result=null;
		for(Map.Entry<Integer, Integer> entry : liste.entrySet()) {
			if(entry.getValue()>val) {
				result=entry.getKey();
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr= {1,1,2,2,1,2,1,2,2,1,2,2,2,1,1,2,2,1,1,1,1};
		System.out.println(Find(arr));

	}

}
