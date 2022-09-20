package questionsonarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagramsTogether {
	//anagram olan stringleri gruplar halinde List generic kullanarak liste geri döndüreceğiz.
	public static List<List<String>> groupAnagrams(String []strs){
		//geriye döndüreceğimiz ArrayList
		List<List<String>> result=new ArrayList<>();
		//HashMap'in bir elemanı string: eat gibi kelimeler aet olarak sıralandıktan sonra key değeri olarak tutuluyor
		//bu key değerinin karşısına eat,ate,tea gibi kelimeler de List<String> olarak liste içerisinde tutulacaktır.
		HashMap<String,List<String>> map=new HashMap<>();
		
		for(String str:strs) {
			//String tipindeki liste içerisindeki string elemanları iterasyon gerçekleştiriyoruz.
			//her bir elemanı içeren karakterleri karakter dizisine ekliyoruz
			char[] karakter=str.toCharArray();
			//karakter dizisindeki elemanları sıralıyoruz.
			Arrays.sort(karakter);
			//karakter dizisinin elemanlarını tek bir String haline getiriyoruz.
			String key=new String(karakter);
			
			if(map.containsKey(key)) {
				//map Hashmap'i içerisinde eğer aradığımız key değeri varsa buna karşılık olarak iterasyon yaptığımız
				//str kelimesini key'e karşılık olarak ekliyoruz.
				map.get(key).add(str);
			}else {
				//eğer HashMap içerisinde aradığımız key yoksa önce yeni bir arraylist oluşturuyoruz.
				List<String> strList=new ArrayList<>();
				//bu listeye str kelimesini ekliyoruz
				strList.add(str);
				//oluşturduğumuz listeyi map Hashmap'ine ekliyoruz.
				map.put(key, strList);
			}
		}
		//sonuç(result) listeleri depolayan listeye map Hashmap'indeki listeleri (values yani değerleri tutan listeleri) ekliyoruz.
		//listelerin listerleri oluşuyor.
		result.addAll(map.values());
		return result;
	}

	public static void main(String[] args) {
		String[]dizi= {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result=groupAnagrams(dizi);
		
		result.forEach(elem ->{
			System.out.println(elem);
		});

	}

}
