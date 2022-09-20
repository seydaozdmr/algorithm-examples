package algorithms;

public class DiceSimulation {

	public static void main(String[] args) {
		double[] distExact=diceSimulation();
		double[] distExperiment = diceExperiment();
		//Zarların toplam 2,3,4,5,6,7,8,9,10,11,12 gelme ihtimallerini hesaplıyoruz.
		StdOut.println("Exact:");
		for (int i = 2; i < distExact.length; i++) {
			StdOut.printf("%5.3f ", distExact[i]);
		}
		StdOut.println("Experiment:");
		for (int i = 2; i < distExperiment.length; i++) {
			StdOut.printf("%5.3f ", distExperiment[i]);
		}

	}
	
	public static double [] diceSimulation() {
		int SIDES=6;
		double [] dist=new double [2*SIDES+1];
		//System.out.println(dist.length);
		for (int i=1;i<=SIDES;i++) {
			for(int j=1;j<=SIDES;j++) {
				dist[i+j]+=1.0;
				//System.out.println("i: "+i+"j: "+j+"dist i+j: "+dist[i+j]);
			}
		}
		//Zar toplamının k olma olasılığı:
		for(int k=2;k<=2*SIDES;k++) {
			dist[k]/=36;
		}
		return dist;
	}
	
	private static double[] diceExperiment() {
		int SIDES = 6;
		double[] distExperiment = new double[2 * SIDES + 1];
		
		int n = 6000000;
		//int n = 6000;
		int diceOne = 0;
		int diceTwo = 0;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			diceOne = StdRandom.uniform(1, 7);
			diceTwo = StdRandom.uniform(1, 7);
			
			sum = diceOne + diceTwo;
			//System.out.println("sum: "+sum);
			distExperiment[sum]++;
		}
		
		for (int k = 2; k <= 2 * SIDES; k++) {
			System.out.println(distExperiment[k]);
			distExperiment[k] /= n;
		}
		
		return distExperiment;
	}
	

}
