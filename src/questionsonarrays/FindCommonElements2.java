package questionsonarrays;

public class FindCommonElements2 {
	
	//verilen iki farklı dizideki ortak elemanları ekrana yazdıran algoritma:
	
	private static void printElements(int [] a,int [] b) {
		int aIndex=0;
		int bIndex=0;
		//dizilerin boyutları sayısınca iterasyon gerçekleştiriyoruz. 
		while(aIndex<a.length && bIndex<b.length) {
			//eğer a'nın index değeri boyutundan küçükse yani iterasyon yapmaya devam edebiliyorsak ve
			//a'nın sıradaki değeri b'nin sıradaki değerinden küçük ise a'nın index değerini bir arttır.
			while(aIndex<a.length && a[aIndex]< b[bIndex]) {
				aIndex++;
			}
			//eğer a ve b'nin index numaraları boyutlarından küçükse ve a'nın değeri ile b'nin değeri birbirine eşit ise
			//bu değeri yazdırıyoruz.
			if(aIndex<a.length && bIndex<b.length && a[aIndex]==b[bIndex]) {
				
				System.out.println(a[aIndex]);
				//aynı sayıları tekrar yazdırmamak için
				int equalNumber=a[aIndex];
				
				//sıralamaları birer arttırıyoruz
				//sonrasında iki ayrı döngü ile sıraki değerimizin önceki değerle aynı olup olmadığını kontrol ediyoruz.
				while(aIndex<a.length && a[aIndex]==equalNumber) {
					aIndex++;
				}
				while(bIndex<b.length && b[bIndex]==equalNumber) {
					bIndex++;
				}
			}
			//a dizisinde ve b dizisinde iterasyon yapabiliyorsak ve a'nın sıradaki değeri b'nin sıradaki değerinden
			//büyük ise b'nin sıradaki elemanını bir arttıyoruz.
			while(aIndex<a.length && bIndex<b.length && b[bIndex]<a[aIndex] ) {
				bIndex++;
			}
		}
	}

	public static void main(String[] args) {
		int[] array1 = {-2, 1, 2, 2, 5, 6, 6, 8, 25};
        int[] array2 = {0, 1, 2, 2, 2, 3, 4, 5, 10, 20, 25};
        
        printElements(array1,array2);

	}

}
