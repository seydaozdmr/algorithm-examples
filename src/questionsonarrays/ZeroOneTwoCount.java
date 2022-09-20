package questionsonarrays;

public class ZeroOneTwoCount {
	
	public static int[] organize(int [] arr) {
		int zeros=0;
		int ones=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==0) {
				zeros+=1;
			}else if(arr[i]==1) {
				ones+=1;
			}
		}
		
		for(int i=0;i<zeros;i++) {
			arr[i]=0;
		}
		
		for(int i=zeros;i<(zeros+ones);i++) {
			arr[i]=1;
		}
		for(int i=(zeros+ones);i<arr.length;i++) {
			arr[i]=2;
		}
		return arr;
	}

	public static void main(String[] args) {
		int []arr= {0,1,0,2,1,0,2};
		arr=organize(arr);
		for(int i:arr) {
			System.out.println(i);
		}

	}

}
