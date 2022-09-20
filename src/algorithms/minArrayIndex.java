package algorithms;

public class minArrayIndex {

	public static void main(String[] args) {
		int[]dizi= {18, 6, 66, 44, 9, 22, 14};
		int index=enKucukIndex(dizi,0);
		System.out.println("dizideki en küçük değerin index numarası: "+index);
		System.out.println("dizideki en küçük değer: "+dizi[index]);

	}
	public static int enKucukIndex(int []dizi,int baslangic) {
		int minValue=dizi[baslangic];
		int minIndex=baslangic;
		
		for(int i=minIndex+1;i<dizi.length;i++) {
			if(dizi[i]<minValue) {
				minValue=dizi[i];
				minIndex=i;
			}
		}
		return minIndex;
	}
}
