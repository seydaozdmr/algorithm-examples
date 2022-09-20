package questionsonarrays;

public class MergeArrays {
	
	public static int[] mergeArrays(int []arr1,int[]arr2) {
		int len1=arr1.length;
		int len2=arr2.length;
		
		int [] temp=new int[len1+len2];
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<len1 && j<len2) {
			if(arr1[i]<arr2[j]) {
				temp[k++]=arr1[i++];
			}else {
				temp[k++]=arr2[j++];
			}
		}
		//eğer eleman sayıları bir birine eşit değilse yukardaki döngü eleman sayısı az olan kadar dönecektir. eleman sayısı fazla olanda
		//kalan elemanlar aşağıdaki döngülerin birinde tamamlanacaktır.
		while(i<len1) {
			temp[k++]=arr1[i++];
		}
		while(j<len2) {
			temp[k++]=arr2[j++];
		}
		
		return temp;
	}

	public static void main(String[] args) {
		int [] arr1= {1,2,4,5,6};
		int [] arr2= {2,5,6,7,9,10,11};
		int [] arr3=mergeArrays(arr1,arr2);
		for(int i:arr3) {
			System.out.println(i);
		}

	}

}
