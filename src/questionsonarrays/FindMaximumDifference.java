package questionsonarrays;
//Find maximum difference between two array elements
//findMax finds Maxiumum difference between two elements such that larger number appears after the smaller number.
public class FindMaximumDifference {
	
	public static int findMax(int []arr) {
		int max=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					//eğer max büyükse max'ı değilse arr[j]-arr[i] işleminin sonucunu max'a ata.
					max=Math.max(max, arr[j]-arr[i]);
				}
			}
		}
		return max;
	}
	
	public static int findMax2(int []arr) {
		int currentMin=arr[0];
		int currentMax=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<currentMin)
				currentMin=arr[i];
			
			if(arr[i]>currentMax) {
				currentMax=arr[i];
			}
		}
		return currentMax-currentMin;
	}
	
	public static int findMax3(int[]arr) {
		int maxDif=arr[1]-arr[0];
		int min=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			if((arr[i]-min)>maxDif) {
				maxDif=arr[i]-min;
			}
			if(min>arr[i]) {
				min=arr[i];
			}
		}
		return maxDif;
	}
	
	public static void main(String[] args) {
		int [] arr= {7,9,5,6,13,2};
		System.out.println(findMax(arr));
		System.out.println(findMax2(arr));
		System.out.println(findMax3(arr));
	}

}
