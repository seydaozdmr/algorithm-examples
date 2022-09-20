package questionsonarrays;

public class SortZeroOneTwo {
	
	public static int[] sort(int [] arr) {
		int start=0;
		int mid=0;
		int end=arr.length-1;
		
		while(mid<=end) {
			switch (arr[mid]) {
			case 0: {
				//eğer sıfır üzerine gelmişsek onu başa getir(swap)
				swap(arr,start,mid);
				start++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2:{
				//eğer iki üzerine gelmişsek onu sona taşı..
				swap(arr,mid,end);
				end--;
				break;
			}
			}
		}
		return arr;
	}
	
	public static void swap(int[] arr,int start,int end) {
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
