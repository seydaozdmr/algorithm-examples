package algorithms;

import java.util.LinkedList;
import java.util.List;


public class Fileinput {
	private static final String FILE_PATH="test.txt";

	public static void main(String[] args) {
		int[] sayilar=readAllInts(FILE_PATH);
		
		for(int i : sayilar) {
			System.out.println(i+" ");
		}

	}

	private static int[] readAllInts(String fileName) {
		In in=new In(fileName);
		String input=in.readAll();
		
		String[]inputs=input.split("\\s+");
		//Dosya içerisinde ne kadar sayısal değer olduğunu bilmediğimiz için LinkedList kullanıyoruz. Böylece her yeni eleman öncekine ekleniyor.
		List<Integer>intList=new LinkedList<>();
		
		for(int i=0;i<inputs.length;i++) {
			try {
				int number=Integer.parseInt(inputs[i]);
				intList.add(number);
			}catch(NumberFormatException e) {
				System.out.println("Sayısal bir değer bulunamadı.");
			}
		}
		//LinkedList'e bütün elemanlar eklendikten sonra bu elemanları normal listeye dönüştürüyoruz. Eleman sayısı belirli bir liste haline getiriyoruz.
		int[] ints =new int[intList.size()];
		for(int i=0;i<intList.size();i++) {
			ints[i]=intList.get(i);
		}
		return ints;
	}

}
