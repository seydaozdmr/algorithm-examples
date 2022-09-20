package org.com.algo.java;

public class SortAnArrayof0s1s2s {
	
	//Güzel algoritma bir dizi içerisinde bize verilen 0,1 ve 2 sayılarını sıraya dizip geri döndüren algoritma
	public static int[] sort(int[]arr) {
		int [] count= {0,0,0};
		
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		
		int [] temp=new int[arr.length];
		int j=0;
		int i=0;
		while(i<arr.length) {
			if(count[j]==0) {
				j++;
			}else {
				temp[i]=j;
				count[j]--;
				i++;
			}
		}
		return temp;
	}
	
	public static int[] sort2(int[]arr) {
		int [] count= {0,0,0};
		
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		
		
		int j=0;
		int i=0;
		while(i<arr.length) {
			if(count[j]==0) {
				j++;
			}else {
				arr[i]=j;
				count[j]--;
				i++;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[]arr= {1,0,0,1,0,0,1,0,1,0,0};
		int []newArr=sort2(arr);
		
		for(int i:newArr) {
			System.out.println(i);
		}

	}

}
