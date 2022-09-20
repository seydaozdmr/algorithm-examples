package questionsonarrays;

public class RotateArraybyKStep {
	
	//Birinci yaklaşım brutal force:
	public static void Rotate(int [] arr,int k) {
		//j'yi bu noktada tanımlamamızın sebebi for döngüsü bittikten sonra j'yi tekrar kullanmamıza olanak sağlaması.
		int j=0;
		//bu işlem k kadar yani biz ne kadar olmasını istiyorsak o kadar devam ediyor.
		while(k>0) {
			//son elemanı temp'e atıyoruz
			int temp=arr[arr.length-1];
			
			for(j=arr.length-1;j>0;j--) {
				//bir önceki elemanı bir sonraki elemanın yerine atıyoruz.
				arr[j]=arr[j-1];
			}
			//en baştaki elemanın yerine sonra temp'e atadığımız elemanı atıyoruz.
			arr[j]=temp;
			k--;
		}
	}
	
	//ikinci yaklaşım 
	
	public static void rotateByK(int []arr,int k) {
		int len=arr.length;
		k=k%len;
		//önce son kalan k'kadar eleman dışındaki baştaki elemanları tersine çeviriyoruz.
		reverse(0,len-k-1,arr);
		//daha sonra sondan k' kadar elemanın kalan kısmını tersine çeviriyoruz.
		reverse(len-k,len-1,arr);
		//son adım olarak hepsini tersine çeviriyoruz.
		reverse(0,len-1,arr);
	}
	//verilen diziyi tersine çeviriyoruz.
	public static void reverse(int start,int end,int[]arr) {
		while(start<end) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
	
	
	public static void main(String[] args) {
		int[]arr= {1,2,3,4,5,9,10,11};
		rotateByK(arr,3);
		for(int i:arr) {
			System.out.print(i+" -> ");
		}
	}
}
