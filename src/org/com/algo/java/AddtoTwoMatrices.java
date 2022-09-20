package org.com.algo.java;

public class AddtoTwoMatrices {
	public static int[][] add(int[][] x,int [][] y){
		int[][]result=new int[x.length][x[0].length];
		
		for(int i=0;i<x.length;i++) {
			for(int j=0;j<x[0].length;j++) {
				result[i][j]=x[i][j]+y[i][j];
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		int [][]x= {{1,5,1},{2,8,2},{3,7,1}};
		int [][]y= {{1,1,9},{2,2,3},{5,6,4}};
		int [][]z=add(x,y);
		
		for(int i=0;i<z.length;i++) {
			for(int j=0;j<z[0].length;j++) {
				System.out.print(z[i][j]+" ");
			}
			System.out.println();
		}

	}

}
