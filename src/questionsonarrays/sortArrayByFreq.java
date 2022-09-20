package questionsonarrays;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class sortArrayByFreq {
	
	public static List<Integer> sortFreq(int[]arr){
		List<Integer> liste=new ArrayList<>();
		
		Map<Integer,Integer> elemCount=new LinkedHashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			elemCount.put(arr[i],elemCount.getOrDefault(arr[i],0)+1);
		}
		
		elemCount.entrySet().stream()
							.sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
							.forEach(kayit->{
			int key=kayit.getKey();
			int value=kayit.getValue();
			for(int i=0;i<value;i++) {
				liste.add(key);
			}
		});
		return liste;
	}

	public static void main(String[] args) {
		int arr[]= {5,3,4,5,6,8,1,1,3,5,0};
		List<Integer> sonuc=sortFreq(arr);
		
		for(int i:sonuc) {
			System.out.print(i);
		}
		
		sonuc.forEach(elem->{
			System.out.println(elem+" ");
		});
		

	}

}
