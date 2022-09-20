package algorithms;

import java.util.Arrays;

public class RandomMatches {

	public static void main(String[] args) {
		int t=Integer.parseInt(args[0]);
		
		int n1=(int)Math.pow(10, 3);
		int n2=(int)Math.pow(10, 4);
		int n3=(int)Math.pow(10, 5);
		int n4=(int)Math.pow(10, 6);
		
		int[]results=new int[4];
		
		for(int i=0;i<t;i++) {
			results[0] += deney(n1);
			results[1] += deney(n2);
			results[2] += deney(n3);
			results[3] += deney(n4);
		}
		StdOut.println("Results");
		
		StdOut.printf("10ˆ3: %7.2f \n", ((double)results[0]) / t);
		StdOut.printf("10ˆ4: %7.2f \n", ((double)results[1]) / t);
		StdOut.printf("10ˆ5: %7.2f \n", ((double)results[2]) / t);
		StdOut.printf("10ˆ6: %7.2f \n", ((double)results[3]) / t);
		

	}
	
	public static int deney(int n) {
		int[]array1=new int[n];
		int[]array2=new int[n];
		
		for(int i=0;i<n;i++) {
			array1[i]=StdRandom.uniform(100000,1000000);
			array2[i]=StdRandom.uniform(100000,1000000);
		}
		
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int aynielemanlar=0;
		
		for(int i=0;i<n;i++) {
			if(binarySearch(array1[i],array2,0,array2.length-1)) {
				aynielemanlar++;
			}
		}
		return aynielemanlar;
		
		
	}

	public static boolean binarySearch(int key, int[] arr, int lo, int hi) {
		boolean found = false;
		if (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < arr[mid]) {
				return binarySearch(key, arr, lo, mid - 1);
			} else if (key > arr[mid]) {
				return binarySearch(key, arr, mid + 1, hi);

			} else
				found = true;

		} else {
			found = false;
		}
		return found;
	}

}
