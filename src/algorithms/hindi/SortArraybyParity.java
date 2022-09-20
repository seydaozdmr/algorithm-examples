package algorithms.hindi;

public class SortArraybyParity {
	
	public static int[] sirala(int []arr) {
		int j=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%2==0) {
				int temp=arr[j];
				arr[j++]=arr[i];
				arr[i]=temp;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[]arr= {23,44,55,667,88,99,343,22,56};
		arr=sirala(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}

}
