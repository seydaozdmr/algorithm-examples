package questionsonarrays;

public class CountOccurrencesofNumberinArray {
	//Güzel algoritma
	//Aranan bir elemanın bir liste içersinde 
	//1-LinearSearch
	public static int search(int[]arr,int key) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {count++;}
			
		}
		return count;
	}

	//2-BinarySeach -> find firstPosition find lastPosition and then find differance between two value
	
	public static int searchBinary(int[]arr,int key) {
		int first=findFirstPosition(arr,key);
		int last=findLastPosition(arr,key);
		
		return (last-first)+1;
	}
	
	
	
	private static int findLastPosition(int[] arr, int key) {
		int start=0;
		int end=arr.length-1;
		int index=-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==key) {
				index=mid;
				start=mid+1;
			}else if(arr[mid]<key) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		return index;
	}

	private static int findFirstPosition(int[] arr, int key) {
		int start=0;
		int last=arr.length-1;
		int index=-1;
		while(start<=last) {
			int mid=(start+last)/2;
			
			if(arr[mid]==key) {
				index=mid;
				//aradığımız değeri bulduktan sonra eğer aynı değerden daha düşük index değerlerinde de var mı bunu anlamak için
				//son değeri bulduğumuz değerin bir önceki değeri yapıp tekrar arıyoruz.
				last=mid-1;
			}else if(arr[mid]>key) {
				last=mid-1;
			}else {
				start=mid+1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int []arr= {1,2,4,7,8,8,11,11,11,11,12,13};
		
		System.out.println(searchBinary(arr,8));

	}

}
