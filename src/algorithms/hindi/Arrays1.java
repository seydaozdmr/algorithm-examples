package algorithms.hindi;

public class Arrays1 {

	public static void main(String[] args) {
		int [] arr=new int[10];
		for(int i=0;i<10;i++) {
			arr[i]=i*i;
		}
		int[]arrtemp=new int[arr.length];
		int size=arr.length-1;
		for(int i=0;i<arr.length;i++) {
			arrtemp[size]=arr[i];
			size--;
		}
		arr=arrtemp;
		for(int i:arr) {
			System.out.println(i);
		}
		
		/*
		 * int start=0;
		 * int last=arr.length-1;
		 * int temp;
		 * while(start<last){
		 * 		int temp=arr[start];
		 * 		arr[start]=arr[last];
		 * 		arr[last]=arr[start];
		 * 		start++;
		 * 		last-;
		 * }
		 * 
		 */

	}

}
