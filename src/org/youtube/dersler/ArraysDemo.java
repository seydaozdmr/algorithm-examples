package org.youtube.dersler;

public class ArraysDemo {

	public static void main(String[] args) {
		double[] myList=new double[4];
		myList[0]=2.2;
		myList[1]=22.2;
		myList[2]=23.22;
		myList[3]=54.65;
		double max=myList[0];
		double toplam=0;
		for (double i:myList) {
			if(max<i) {
				max=i;
			}
			toplam+=i;
			System.out.println(i);
		}
		System.out.println("Toplam: "+toplam);
		System.out.println("En büyük Sayı: "+max);

	}

}
