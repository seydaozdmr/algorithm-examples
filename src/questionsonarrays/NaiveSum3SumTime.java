package questionsonarrays;

public class NaiveSum3SumTime {
	//Normal 3Sum problemi complexcity O(n3)
	public static int threeSumCount(int [] arr) {
		int n=arr.length;
		int count=0;
		
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					if(arr[i]+arr[j]+arr[k]==0) {
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int evenNaiverThreeSum(int[]arr) {
		int n=arr.length;
		int count=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(i<j && j<k) {
						if(arr[i]+arr[j]+arr[k]==0) {
							count++;
						}
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
