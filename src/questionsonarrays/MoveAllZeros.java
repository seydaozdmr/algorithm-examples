package questionsonarrays;

public class MoveAllZeros {
	
	public static void moveArrays(int [] arr) {
		int len=arr.length;
		int count=0;
		
		for(int i=0;i<len;i++) {
			if(arr[i]!=0) {
				arr[count++]=arr[i];
			}
		}
		
		while(count<len) {
			arr[count++]=0;
		}
		
		for(int j=0;j<len;j++) {
			System.out.print(arr[j]+" ");
		}
	}

	public static void main(String[] args) {
		int [] arr= {1,2,0,4,5,0,4,5,3};
		
		moveArrays(arr);

	}

}
