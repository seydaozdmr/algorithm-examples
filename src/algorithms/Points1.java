package algorithms;

public class Points1 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]); // 10

		Point2D[] points = new Point2D[n];
		drawAndCreatePoints(points);

		StdOut.printf("The shortest distance is: %.3f", calculateShortestDistance(points));
	}

	private static void drawAndCreatePoints(Point2D[] points) {
		StdDraw.setCanvasSize(1024, 512);
		StdDraw.setPenRadius(.015);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);

		for (int i = 0; i < points.length; i++) {
			double pointX = StdRandom.uniform();
			double pointY = StdRandom.uniform();

			Point2D point = new Point2D(pointX, pointY);
			StdDraw.point(point.x(), point.y()); //The exercise doesn't require drawing, but it adds a nice touch

			points[i] = point;
		}
		
	}
	
	private static double calculateShortestDistance(Point2D[] points) {
		double shortestDistance = Double.MAX_VALUE; //en kısa mesafe
		double currentDistance;
		//güzel bir algoritma
		//iç içe döngüler noktalar arasındaki en kısa mesafeyi hesaplamaya çalışıyor.
		//Bunun için her bir noktanın diğer noktalara uzaklığını tek tek sorgulamak yerine
		//Daha önce sorgulanmış olan noktalarını yeniden sorgulamıyor. 
		//Örneğin 1-4 arası mesafeye baktıktan sonra sıra 4'e geldiğinde geri dönüp 4-1 arası mesafeyi yeniden hesaplamıyor.
		//Bu doğrultuda son nokta da tekrar diğer mesafeleri hesaplamıyor nasılsa son noktaya kadar bütün noktalar hesaplamasını gerçekleştiriyor.
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				currentDistance = points[i].distanceTo(points[j]);//mevcut mesafe
				System.out.println(i+".nokta: "+points[i].toString()+j+".Nokta "+points[j]);
				System.out.println("current distance: "+currentDistance);
				if (currentDistance < shortestDistance) {
					shortestDistance = currentDistance;
					//System.out.println(i+".nokta: "+points[i].toString()+j+".Nokta "+points[j]);
				}
			}
		}
		return shortestDistance;
	}

}
