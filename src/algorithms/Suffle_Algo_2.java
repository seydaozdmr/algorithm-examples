package algorithms;

public class Suffle_Algo_2 {

	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		int m=Integer.parseInt(args[1]);
		
		int[][] positions=new int[m][m];
		double []array=new double[m];
		
		for(int i=0;i<n;i++) {
			initializeArray(array);
			shuffle(array);
			for(int j=0;j<array.length;j++) {
				positions[(int)array[j]][j]++;
			}
		}	
		printTable(positions);
	}
	
	public static void initializeArray(double[]array) {
		for(int i=0;i<array.length;i++) {
			array[i]=i;	
		}
	}
	
	public static void shuffle(double[]array) {
		int n=array.length;
		for(int i=0;i<n;i++) {
			int randomIndex=i+StdRandom.uniform(n-i);
			double temp=array[i];
			array[i]=array[randomIndex];
			array[randomIndex]=temp;
		}
	}
	private static void printTable(int[][] positions) {
		StdOut.println("TABLE");

		for (int i = 0; i < positions.length; i++) {
			StdOut.printf("%3d  ", i);

			for (int j = 0; j < positions[0].length; j++) {
				StdOut.printf("%4d ", positions[i][j]);
			}
			StdOut.println();
		}
	}

}
