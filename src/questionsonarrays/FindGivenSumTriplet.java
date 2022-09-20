package questionsonarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindGivenSumTriplet {
	//***Verilen bir dizedeki elemanlar arasından istenen toplamı sağlayan 3 elemanı liste olarak geri döndüren algoritma
	public static List<List<Integer>> findTriplets(int[] arr,int key){
		if(arr.length<3) {
			return null;
		}
		
		List<List<Integer>> liste=new ArrayList<>();
		//önce sıralıyoruz
		int len=arr.length;
		Arrays.sort(arr);
		
		for(int i=0;i<len;i++) {
			int start=i+1;
			int end=len-1;
			
			while(start<end) {
				if(arr[i]+arr[start]+arr[end]==key) {
					//val isminde bir liste oluşturup bu üçlüyü listeye ekliyorum ve daha sonra listeme val'i liste olarak ekliyorum.
					List<Integer> val=Arrays.asList(arr[i],arr[start],arr[end]);
					liste.add(val);
					start++;
					end--;
				}else if(arr[i]+arr[start]+arr[end]<key) {
					start++;
				}else {
					end--;
				}
			}
		}
		
		return liste;
		
	}

	public static void main(String[] args) {
		int[]arr= {1,4,6,8,10,45};
		List<List<Integer>> liste=findTriplets(arr,13);
		
		liste.forEach(values ->{
			System.out.println(values);
		});

	}

}
