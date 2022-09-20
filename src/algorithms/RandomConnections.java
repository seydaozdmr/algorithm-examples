package algorithms;

public class RandomConnections {

	public static void main(String[] args) {
		int n = 100;
		double p = 0.01;

		draw(n, p);

	}

	private static void draw(int n, double p) {
		StdDraw.setCanvasSize(1024, 1024);
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenRadius(.030);
		
		double[][] d = new double[n][2];
        for (int i = 0; i < n; i++) {
            d[i][0] = Math.cos(2 * Math.PI * i / n);
            d[i][1] = Math.sin(2 * Math.PI * i / n);
            StdDraw.point(d[i][0], d[i][1]);
        }
        
        StdDraw.setPenRadius();
        
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i + 1; j < n; j++) {
        		if (StdRandom.bernoulli(p)) {
        			StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
        		}
        	}
        }
		
	}

}
