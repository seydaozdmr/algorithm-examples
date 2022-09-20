package org.seydaozdemir;

import java.util.ArrayList;

class intWrapper{
	public int intvalue;
	
	public int getIntvalue() {
		return intvalue;
	}

	public void setIntvalue(int intvalue) {
		this.intvalue = intvalue;
	}

	public intWrapper(int deger) {
		this.intvalue=deger;
	}
}
public class AutoBoxingArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> studentNumbers=new ArrayList<Integer>();
		studentNumbers.add(25);//auto boxing
		System.out.println(studentNumbers);
		
		ArrayList<intWrapper> liste=new ArrayList<>();
		liste.add(new intWrapper(12));//boxing
		
		System.out.println(liste.get(0).getIntvalue());//unboxing
		
		
		ArrayList<Double> ondalikSayilar=new ArrayList<>();
		ondalikSayilar.add(11.11);//autoboxing
		ondalikSayilar.add(new Double(12.22));//ondalik sayiyi nesne haline getirmek
		ondalikSayilar.add(Double.valueOf(19.99));//Autoboxing yaparken arkada çalışan mekanizma
		
		//Unboxing örneği nesnede bulunan değeri primitive olarak ortaya çıkarmak
		System.out.println(ondalikSayilar.get(0).doubleValue());//unboxing
		//Burada yapılan işlem yukarıdaki intWrapper classda kullanılan getter örneğine benziyor.
		
		
	}

}
