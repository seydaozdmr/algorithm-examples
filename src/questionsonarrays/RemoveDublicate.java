package questionsonarrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDublicate {
	/*
	 * 1-Yaklaşım 
	 * Önce elemanları sıralamak daha sonra tekrar eden elemanları silmek
	 */
	
	public static int[] TekrarSil(int []arr) {
		Arrays.sort(arr);
		int j=0;
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]!=arr[i+1]) {
				arr[j++]=arr[i];
			}
		}
		//son eleman
		arr[j++]=arr[arr.length-1];
		//geriye kalan elemanları 0 olarak değiştiriyorum
		for(int i=j;i<arr.length;i++) {
			arr[i]=0;
		}
		return arr;
	}
	
	/*
	 * 2-Yaklaşım 
	 * Elemanları HashMap e sırasıyla atıyoruz. Daha sonra yalnızca key değerini geri döndürdüğümüzde tekrarları ortadan 
	 * kaldırmış oluyoruz.
	 */
	
	public static void TekrarSil2(int [] arr) {
		Map<Integer,Integer> liste=new HashMap<>();
		
		for(int i=0;i<arr.length-1;i++) {
			//sıradaki eleman liste içerisinde var mı?
			if(liste.containsKey(arr[i])) {
				//eğer varsa
				liste.put(arr[i], liste.get(arr[i])+1);
			}else {
				//eğer yoksa key değerini ekliyor karşılık olarak 1 değerini veriyor.
				liste.put(arr[i], 1);
			}
		}
		liste.forEach((k,v)-> System.out.println(k));
	}
	/*
	 * 3-Yaklaşım 
	 * Elemanları Set veri tipinde ekliyoruz, ki Set veri yapısı tekrara izin vermiyor.
	 */
	public static void TekrarSil3(int [] arr) {
		Set<Integer> liste=new HashSet<>();
		
		for(int i=0;i<arr.length-1;i++) {
			liste.add(arr[i]);
		}
		
		liste.forEach(elem -> System.out.print(elem+ " "));
	}
	
	
	
	public static void main(String[] args) {
		int [] arr= {5,1,2,6,4,4,5};
		
		arr=TekrarSil(arr);
		for(int i:arr) {
			System.out.println(i);
		}
		//HashMap yaklaşımı ile
		TekrarSil2(arr);
		
		//HashSet yaklaşımı ile
		TekrarSil3(arr);
	}

}
