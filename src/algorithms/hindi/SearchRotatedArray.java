package algorithms.hindi;

public class SearchRotatedArray {
	
	public static int search(int[]arr,int target) {
		int start=0;
		int end=arr.length-1;
		
		while(start<=end) {
			int mid=(start+end)/2;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[start]<=arr[mid]) {
				if(target>=arr[start] && arr[mid]>=target) {
					end=mid-1;
				}else {
					start=mid+1;
				}
			}else {
				if(target<=arr[end]&&target>=arr[mid]) {
					start=mid+1;
				}else {
					end=mid-1;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[]arr= {5,6,7,8,10,12,-4,-3,-1,0,1,3,4};
		System.out.println(search(arr,4));
	}

}
