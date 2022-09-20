package questionsonarrays;

public class ReverseArrayinGroups {
	//verilen bir dizinin belirli bir sayıdaki elemanını tersine çeviren algortima.
	public static void reverse(int [] arr,int size) {
		//we will reverse every sub array of size group elements;
		for(int i=0;i<arr.length;i=i+size) {
			int start=i;
			//end i ile i'nin size fazlası ya da i ile son eleman arasında kalan elemanları irdelemek üzere ya belirlediğimiz size değeri kadar elemanı 
			//tersine çevirecek ya da sonda size'dan daha düşük sayıda eleman kalmışsa bunu belirleyecek minumum değeri buluyoruz.
			int end=Math.min(i+size-1,arr.length-1);
			for(int j=start;j<=end;j++) {
				int temp=arr[j];
				arr[j]=arr[end];
				arr[end]=temp;
				end--;
			}
		}
	}

	public static void main(String[] args) {
		int[]arr= {1,2,3,4,55,6,7,8,99,11,2};
		reverse(arr,5);
		for(int i:arr) {
			System.out.print(i+" ");
		}

	}

}
