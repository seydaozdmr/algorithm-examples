package questionsonarrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDublicates2 {
	
	public static void findDub(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					System.out.println(arr[i]);
				}
			}
		}
	}
	
	public static void findDub2(int [] arr) {
		Map<Integer,Integer> liste=new HashMap<>();
		
		for(int i=0;i<arr.length;i++) {
			if(liste.containsKey(arr[i])) {
				liste.put(arr[i], liste.get(arr[i])+1);
			}else {
				liste.put(arr[i], 1);
			}
		}
		
		liste.forEach((k,v) -> {
			if(v>1) {
				System.out.println(k);
			}
		} );
	}
	
	public static void findDub3(int[] arr) {
		Set<Integer> arrSet=new HashSet<>();
		
		for(int i=0;i<arr.length;i++) {
			if(arrSet.contains(arr[i])) {
				System.out.println(arr[i]);
			}else{
				arrSet.add(arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		int [] arr1= {2,5,3,1,8,7,5,3,2,1,2,4,5};
		findDub2(arr1);

	}

}
