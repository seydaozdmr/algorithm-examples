package questionsonarrays;

public class FindMinRotatedArray {
	//BinarySearch yardımıyla döndürülmüş bir dizideki en küçük elemanı bulma
	public static int findMin(int[]arr) {
		//eğer dizide bir eleman var ise ilk elemanı geri döndürür
		if(arr.length==1) {
			return arr[0];
		}
		
		int start=0;
		int end=arr.length-1;
		//eğer dizi sıralı bir dizi ise ilk elemanı geri döndürür
		if(arr[0]<arr[end]) {
			return arr[0];
		}
		
		while(start<=end) {
			int mid=(start+end)/2;
			//eğer mid değeri başlangıç değerinden büyük ve bulunan arr[mid] elemanı kendisinden önce gelen elemandan küçük ise en küçük eleman o'dur.
			if(start<mid && arr[mid]<arr[mid-1]) {
				return arr[mid];
				//bitiş değeri orta değerden büyükse ve bulunan arr[mid+1] değeri kendisinden önce gelen değerden küçük ise en küçük eleman arr[mid+1]dir.
			}else if(end>mid && arr[mid+1]<arr[mid]) {
				return arr[mid+1];
			}else if(arr[end]>arr[mid]) {
				//döndürülen dizimizin son kısmı orta kısımdan büyük mü eğer doğru ise aradığımız küçük değeri orta değerin küçük tarafında demektir.
				end=mid-1;
			}else {
				//değilse küçük değer orta kısmın büyük tarafından demektir.
				start=mid+1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int [] arr1= {7,8,9,10,1,2,3,4,5,6};
		System.out.println(findMin(arr1));

	}

}
