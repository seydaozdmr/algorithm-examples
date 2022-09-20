package algorithms;

public class Transpose {
	public static void transpose(int[][]mat) {
		int[][] newMat=new int[mat[0].length][mat.length];
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				newMat[j][i]=mat[i][j];
			}
		}
		print(newMat);
	}

	private static void print(int[][] newMat) {
		for(int i=0;i<newMat.length;i++) {
			for(int j=0;j<newMat[0].length;j++) {
				System.out.print(newMat[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		int[][]mat= {
				{1,3,5},{2,4,6}
		};
		transpose(mat);
		

	}

}
