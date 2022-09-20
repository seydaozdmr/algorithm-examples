package algorithms;

import java.util.HashMap;
import java.util.Map;

public class Aralik_Expert {
	private static Map<Interval2D,Interval1D[]> intervalMap=new HashMap<>();
	

	public static void main(String[] args) {
		int n=Integer.parseInt("100");
		double min=Double.parseDouble("5");
		double max=Double.parseDouble("70");
		
		if(min>max) {
			double temp=min;
			min=max;
			max=temp;
		}
		
		Interval2D[] intervals=new Interval2D[n];
		
		drawAndCreateIntervals(intervals,min,max);
		
		int[]sonuclar=countIntervalIntersectionsAndContains(intervals);
		StdOut.println("kesişen aralık çiftleri: " + sonuclar[0]);
		StdOut.println("Aralıkların bir birini içermesi: " + sonuclar[1]);
	}


	private static int[] countIntervalIntersectionsAndContains(Interval2D[] intervals) {
		int[]sonuclar=new int[2];
		int intersections=0;
		int contains=0;
		
		for(int i=0;i<intervals.length-1;i++) {
			for(int j=i+1;j<intervals.length;j++) {
				if(intervals[i].intersects(intervals[j])) {
					intersections++;
				}
				if(isContained(intervals[i],intervals[j])) {
					contains++;
				}
			}
		}
		sonuclar[0]=intersections;
		sonuclar[1]=contains;
		return sonuclar;
	}

	//iki aralığın birbirini içerip içermediği
	private static boolean isContained(Interval2D interval1, Interval2D interval2) {
		boolean isContained = false;
		
		Interval1D[] intervalsFromInterval1 = intervalMap.get(interval1);
		Interval1D[] intervalsFromInterval2 = intervalMap.get(interval2);
		
		//interval1 interval2'yi içeriyor mu OR interval2 interval1'i içeriyor mu ?
		if (  (intervalsFromInterval1[0].min() > intervalsFromInterval2[0].min() 
				&& intervalsFromInterval1[0].max() < intervalsFromInterval2[0].max()
				&& intervalsFromInterval1[1].min() > intervalsFromInterval2[1].min() 
				&& intervalsFromInterval1[1].max() < intervalsFromInterval2[1].max() )
				||
				(intervalsFromInterval2[0].min() > intervalsFromInterval1[0].min() 
						&& intervalsFromInterval2[0].max() < intervalsFromInterval1[0].max()
						&& intervalsFromInterval2[1].min() > intervalsFromInterval1[1].min() 
						&& intervalsFromInterval2[1].max() < intervalsFromInterval1[1].max() )
				) {
			isContained = true;
		}
		
		return isContained;
	}


	private static void drawAndCreateIntervals(Interval2D[] intervals, double min, double max) {
		StdDraw.setCanvasSize(1024, 512);
		StdDraw.setPenRadius(.015);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        
        for(int i=0;i<intervals.length;i++) {
        	//genişlik
        	Interval1D width=generateInterval1D(min,max);
        	//yükseklik
        	Interval1D height = generateInterval1D(min, max);
        	//2 boyutlu aralık oluşturuyoruz.
        	Interval2D interval = new Interval2D(width, height);
        	//aralığı çiziyoruz
        	interval.draw();
			//intervals dizisine aralığı ekliyoruz.
			intervals[i] = interval;
			//hashmap içerisine 2 boyutlu aralığı, ve yeni oluşturduğum 1boyutlu dizi içersine yükseklik ve gelişlik değerlerini yerleştiriyorum.
			intervalMap.put(interval, new Interval1D[] {width, height});
        }
		
	}


	private static Interval1D generateInterval1D(double min, double max) {
		double firstValue=StdRandom.uniform(min,max);
		double secondValue=StdRandom.uniform(min,max);
		
		if(firstValue>secondValue) {
			double temp=firstValue;
			firstValue=secondValue;
			secondValue=temp;
		}
		//verilen değerler içersinde rastgele değerlere sahip yeni bir aralık oluşturuyoruz.
		Interval1D interval=new Interval1D(firstValue,secondValue);
		return interval;
	}

}
