package questionsonarrays;

public class FindSecondSmallest {
	public static int find(int [] arr) {
		int smallest=Integer.MAX_VALUE;
		int secondSmallest=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<smallest) {
				smallest=arr[i];
			}
			if(arr[i]>smallest && arr[i]<secondSmallest) {
				secondSmallest=arr[i];
			}
		}
		return secondSmallest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
