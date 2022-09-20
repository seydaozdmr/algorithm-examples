package questionsonarrays;

public class MaximumConsecutiveOnesinArray {
	
	public static int countConsecutiveOnes(int[] arr) {
		
		int count=0;
		int MaxConsecutive=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				count++;
				MaxConsecutive=Math.max(count, MaxConsecutive);
			}else {
				count=0;
			}
		}
		return MaxConsecutive;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
