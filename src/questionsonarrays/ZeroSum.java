package questionsonarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeroSum {
	
	public static List<List<Integer>> threeSum(int[]arr){
		List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++) {
			//döngü döndükçe start i'nin bir sonrasında başlayacak.
			int start=i+1;
			//her zaman son sırada olacak end
			int end=arr.length-1;
			//i'inci elemanın değeri bir önceki elemanla aynıysa ona tekrar bakmaya gerek yok continue diyip geçiyoruz.
			//böylece aynı elemanları (consecutive -ardışık) tekrar yazdımak istemiyoruz.
			if(i>0 && arr[i]==arr[i-1]) {
				continue;
			}
			
			while(start<end) {
				//aynı şekilde sondan eğer aynı eleman varsa tekrar değerlendirmiyor.
				
				if(end<arr.length-1 && arr[end] == arr[end+1]) {
					end--;
					continue;
				}
				
				if(arr[i]+arr[start]+arr[end]==0) {
					//eğer aradığımız üç değeri bulursak bunu result listesine liste olarak ekliyoruz, start'ı arttırıp, end'i azaltarak aramaya devam ediyoruz.
					List<Integer> val=Arrays.asList(arr[i],arr[start],arr[end]);
					result.add(val);
					start++;
					end--;
				}else if(arr[i]+arr[start]+arr[end]<0) {
					start++;
				}else {
					end--;
				}
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr= {-1,0,1,2,-1,-4,3,5,2,1,3,-6,-1,-3,-4,-5};
		List<List<Integer>> liste=threeSum(arr);
		
		liste.forEach(values -> {
			System.out.println(values);
		});
		
	}

}
