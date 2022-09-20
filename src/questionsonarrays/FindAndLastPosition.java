package questionsonarrays;

public class FindAndLastPosition {
	
	public static void findLinearSearch(int [] arr,int key) {
		int firstIndex=-1;
		int secondIndex=-1;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key && firstIndex==-1) {
				firstIndex=i;
			}
			if(arr[i]==key && firstIndex!=-1) {
				secondIndex=i;
			}
		}
		System.out.println("ilk index: "+firstIndex+" 2.index : "+secondIndex);
		
	}
	
	public static int findFirstPosition(int []arr, int key) {
		
		int start=0;
		int end=arr.length-1;
		
		int index=-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(arr[mid]==key) {
				index=mid;
				end=mid-1;
			}else if(arr[mid]>key) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return index;
	}
	
	public static int findLastPosition(int [] arr,int key) {
		int start=0;
		int end=arr.length-1;
		
		int index=-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(arr[mid]==key) {
				index=mid;
				start=mid+1;
			}else if(arr[mid]>key) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int []arr= {4,5,6,6,8,10};
		System.out.println(findLastPosition(arr,6));
		System.out.println(findFirstPosition(arr,6));
		int []arr2= {4,5,6,6,8,10,11,11,11,11,12,13,14,15,16,16};
		findLinearSearch(arr2,11);
	}

}
