package org.com.algo.java;

public class MergeTwoSortedArrays {
	
	public static int[] mergeArrays(int []a,int []b) {
		int y=0;
		int x=0;
		int [] temp=new int[a.length+b.length-1];
		int z=0;
		while(x<a.length && y<b.length) {
			if(a[x]<b[y]) {
				temp[z++]=a[x++];
			}else if(b[y]<a[x]) {
				temp[z++]=b[y++];
				//eğer aynı elemanlardan yalnızca birini eklemesini istiyorsak alttaki şartı kullanmamız gerekiyor.
			}else if(a[x]==b[y]) {
				temp[z++]=a[x];
				x++;
				y++;
			}
		}
		if(a.length>b.length) {
			while(x<a.length) {
				temp[z++]=a[x++];
			}
		}else {
			while(y<b.length) {
				temp[z++]=b[y++];
			}
		}
		
		return temp;
	}

	public static void main(String[] args) {
		int[]a= {1,5,6,7};
		int[]b= {2,5,8,9,11,12};
		
		int []c=mergeArrays(a,b);
		
		for(int i:c) {
			System.out.println(i);
		}

	}

}
