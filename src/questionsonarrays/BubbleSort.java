package questionsonarrays;

public class BubbleSort {
	public static void bubbleSort(int[]arr) {
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	public static void sortRecursive(int []arr,int n) {
		if(n==1) {
			return;
		}
		
		for(int i=0;i<n-1;i++) {
			if(arr[i]>arr[i+1]) {
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		
		sortRecursive(arr,n-1);
	}

	public static void main(String[] args) {
		int[]arr= {6,2,4,1,3,5};
		bubbleSort(arr);
		for(int i:arr) {
			System.out.println(i);
		}

	}

}
