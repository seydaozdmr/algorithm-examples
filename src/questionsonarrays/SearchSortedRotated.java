package questionsonarrays;

public class SearchSortedRotated {
	//Rotated yani döndürülmüş bir dizide bir elemanı ararken binary search ile 4 seçeneğimiz var
	//1. bulduğumuz orta nokta başlangıç değerinden büyükyür ki bu bize orta noktaya kadar küçükten büyüğe doğru sıralanmış bir dizi bölüm olduğunu
	// gösterir. 
	//2. eğer aradığımız değer orta noktanın değerinden küçük ve başlangıç değeriden büyük ise yani bu aralıktaysa;  
	// end yani son değer orta değerin bir eksiği olarak atanır.
	// değilse başlangıç değeri orta değerin sağında aranır. Yani başlangıç orta değerin bir fazlası olarak atanır.
	//3. bulduğumuz orta değer başlangıç değerinden büyük ise bu durumda başlangıç kısmında büyük değerlerin olduğunu anlarız
	//örneğin 7,8,9,1,2,3,4,5 burada orta değer 2 başlangıç değerinden küçüktür. bu durumda 
	//4. aradığımız değer orta değerden büyükse ve end'den küçükse  start'ı orta değerin 1 fazlası olarak atarız ve o kısımda ararız
	//değilse end yani bitiş değerini orta değerden bir azaltarak atarız ve aramaya devam ederiz. 
	//aslında burada yapmaya çalıştığımız bu algoritmamızı rotate ediyoruz yani döndürüyoruz. 
	public static int search(int[]arr,int target) {
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(arr[mid]==target) {
				return mid;
			}
			//eğer orta değerin sol tarafı sıralı ise
			//{3,4,5,6,7,8,9,10,1,2}
			if(arr[start]<=arr[mid]) {
				//ve eğer hedef başlangıçtan büyük ve orta değerden küçük ise
				if(target>=arr[start] && target<=arr[mid]) {
					end=mid-1;
				}else {
					//sıralı ise ancak hedef değer orta değerin solunda yoksa:
					start=mid+1;
					//System.out.println(start);
				}
				//dizinin sol tarafı sıralı değilse
				//{10,1,2,3,4,5,6}//mid 2 olur ve 2 değeri 10 değerinden küçüktür. 
			}else {
				if(target>=arr[mid] && target<=arr[end]) {
					
					start=mid+1;
					//System.out.println(start);
				}else {
					end=mid-1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int []arr={10,1,2,3,4,5,6};
		System.out.println(search(arr,1));

	}

}
