package questionsonarrays;

public class MinimumSizeSubArraySum {
	
	public static int minSum(int[]arr,int key) {
		int min=Integer.MAX_VALUE;
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			sum=0;
			for(int j=i;j<arr.length;j++) {
				sum=sum+arr[j];
				if(sum>=key) {
					min=Math.min(min, (j-i)+1);
				}
			}
		}
		return (min==Integer.MAX_VALUE) ? 0: min;
	}
	
	public static int minSum2(int[] arr,int key) {
		int min=Integer.MAX_VALUE;
		int sum=0;
		int start=0;
		
		for(int end=0;end<arr.length;end++) {
			sum=sum+arr[end];
			
			while(sum>=key && start<=end) {
				min=Math.min(min, (end-start)+1);
				sum=sum-arr[start++];
			}
		}
		
		return(min==Integer.MAX_VALUE) ? 0 : min;
	}

	public static void main(String[] args) {
		int[]arr= {7,2,1,1,6,5};
		
		System.out.println(minSum2(arr,17));

	}

}
