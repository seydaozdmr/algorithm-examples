package questionsonarrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappeared {
	public static List<Integer> find(int[]arr){
		List<Integer> result=new ArrayList<>();
		
		int len=arr.length;
		Set<Integer> st=new HashSet<>();
		
		for(int i=0;i<len;i++) {
			st.add(arr[i]);
		}
		
		for(int i=1;i<=len;i++) {
			//eğer st 1'den başlayarak dizi boyutu kadar eleman içerisindeki elemanlardan sırasıyla hangisini içermiyorsa
			//result Listesine ekliyoruz.
			if(!st.contains(i)) {
				result.add(i);
			}
		}
		return result;
	}
	
	public static List<Integer> find2(int[]arr){
		List<Integer> result=new ArrayList<>();
		
		for(int num:arr) {
			int index=Math.abs(num)-1;
			
			if(arr[index]>0) {
				arr[index]=-arr[index];
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				result.add(i+1);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[]arr= {4,3,2,7,8,2,3,1};
		List<Integer>dizi=find2(arr);
		
		dizi.forEach(elem ->{
			System.out.println(elem);
		});

	}

}
