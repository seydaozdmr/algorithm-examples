package questionsonarrays;

public class SumElementsRecursion {
	public static int toplam(int []arr,int n) {
		if(n<=0) {
			return 0;
		}
		return toplam(arr,n-1)+arr[n-1];
		
	}
	
	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5,6,7,8,9};
		System.out.println(toplam(arr,arr.length));
	}
}
