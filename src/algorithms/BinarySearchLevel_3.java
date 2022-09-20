package algorithms;

import java.util.Arrays;

public class BinarySearchLevel_3 {

	public static void main(String[] args) {
		int[] whitelist= {2, 10, 3, 6, 5, 4, 7, 1, 9, 8};
		int[] keys = {10, 12, 5};
		
		Counter counter=new Counter("Operations");
		
		Arrays.sort(whitelist);
		
		for(int i=0;i<keys.length;i++) {
			if(rank(keys[i],whitelist,counter)==-1)
				StdOut.println(keys[i]);
		}
		
		StdOut.println(counter);
	}

	private static int rank(int key, int[] whitelist, Counter counter) {
		int lo=0;
		int hi=whitelist.length-1;
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			counter.increment();
			if(key<whitelist[mid]) {
				hi=mid-1;
			}else if(key>whitelist[mid]) {
				lo=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}

}
