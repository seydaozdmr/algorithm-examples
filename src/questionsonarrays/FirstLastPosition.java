package questionsonarrays;

public class FirstLastPosition {
	
	public static int findFirstPosition(int arr[],int key,int start,int end) {
		if(start<=end) {
			int mid=(start+end)/2;
			if((mid==0 ||  key>arr[mid-1] ) &&arr[mid]==key ) {
				return mid;
			}else if(arr[mid]>=key) {
				return findFirstPosition(arr,key,start,mid-1);
			}else {
				return findFirstPosition(arr,key,mid+1,end);
			}
		}
		return -1;
	}
	
	public static int FindLastPosition(int arr[],int key,int start,int end) {
		if(start<=end) {
			int mid=(start+end)/2;
			if((mid==arr.length-1 || key<arr[mid+1]) && arr[mid]==key) {
				return mid;
			}else if(arr[mid]>key) {
				return FindLastPosition(arr,key,start,mid-1);
			}else {
				return FindLastPosition(arr,key,mid+1,end);
			}
		}
		return -1;
	}
	
	

	public static void main(String[] args) {
		int [] arr= {1,1,4,7,8,8,11,11,11,11,12,13,13};
		int key=13;
		int start=0;
		int last=arr.length;
		
		int first=findFirstPosition(arr,key,start,last);
		int end=FindLastPosition(arr,key,start,last);
		
		System.out.println(first+":11 "+end+" :11 ");
	}

}
