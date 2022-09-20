package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Exercise32_Histogram {
	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		System.out.println(n);
		double l=Double.parseDouble(args[1]);
		System.out.println(l);
		double r=Double.parseDouble(args[2]);
		System.out.println(r);
		List<Double> numbers=new ArrayList<>();
		
		int numberIndex=3;
		try {
			while(args[numberIndex]!=null) {
				numbers.add(Double.parseDouble(args[numberIndex]));
				numberIndex++;
			}
		}catch(ArrayIndexOutOfBoundsException exception) {
			
		}
		
		double[] newList=new double[numbers.size()];
		for(int i=0;i<numbers.size();i++) {
			newList[i]=numbers.get(i);
		}
		for(int i=0;i<newList.length;i++) {
			System.out.println(newList[i]);
		}
		
		histogram(n,l,r,newList);
	}

	private static void histogram(int numberOfIntervals, double left, double right, double[] numbers) {
		//numberOfInterval girilen aralık sayısı boyutune numbersInInterval Integer tipinde dizi yaratılıyor.
		int[] numbersInInterval = new int[numberOfIntervals];
		double intervalSize = (right - left) / numberOfIntervals;
		//1-numberOfIntervals (int) , 2-left (double),3-right(double) 4-numbers(double[]) 5-numbersInInterval(int[]) 
		computeHistogramValues(numberOfIntervals, left, right, numbers, numbersInInterval); 
		//Belirlenen aralıktaki histogram numberInInterval dizi içerisinde bulunuyor.
		for(int i=0;i<numbersInInterval.length;i++) {
			System.out.println(numbersInInterval[i]);
		}
		
		int maxCount = StdStats.max(numbersInInterval);
		System.out.println("max histogram değeri: "+maxCount);

		double minX = left - 1;
		double maxX = right + 1;
		double minY = -2;
		double maxY = maxCount + 2;

		StdDraw.setCanvasSize(1024, 512);
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY, maxY);

		double middleX = minX + (maxX - minX) / 2;
		double middleY = minY + (maxY - minY) / 2;

		// Labels
		StdDraw.text(middleX, maxY - 0.5, "Aralıktaki sayılar");
		StdDraw.text(minX + 0.25, middleY, "Sayılar", 90);
		StdDraw.text(middleX, -1.2, "Aralık");

		// X labels
		for(int x = 0; x < numberOfIntervals; x++) {
			double minValue = left + (intervalSize * x);
			double maxValue = minValue + intervalSize - 0.01;
			String intervalDescription = String.format("[%.2f - %.2f]", minValue, maxValue);
			StdDraw.text(left + (x + 0.5) * intervalSize, -0.25, intervalDescription);
		}
		
		// Y labels
		for(int y = 0; y < maxY; y++) {
			StdDraw.text(minX + 0.7, y, String.valueOf(y));
		}

		for (int i = 0; i < numberOfIntervals; i++) {

			double x = left + (i + 0.5) * intervalSize;
			double y = numbersInInterval[i] / 2.0;
			double halfWidth = intervalSize / 3.0;
			double halfHeight = numbersInInterval[i] / 2.0;

			StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
		}
		
	}

	private static void computeHistogramValues(int n, double l, double r, double[] numbers,int[] numbersInInterval) {
		double interval = r - l;
		double intervalOfNumbers = interval / n;
		System.out.println("interval: "+interval+"intervalOfNumbers: "+intervalOfNumbers);
		int indexOfInterval;
		//Bu fonksiyonun görevi belirtilen aralık içerisindeki değerlerin histogramını hesaplamak ve numbersInInterval dizisine
		//frekansı hesaplamak
		for (int i = 0; i < numbers.length; i++) {
			indexOfInterval = 0;
			
			for (double j = l; j <= r && indexOfInterval < n; j+= intervalOfNumbers) {
				if (numbers[i] >= j && numbers[i] <= j + intervalOfNumbers) {
					numbersInInterval[indexOfInterval]++;
				}

				indexOfInterval++;
			}
		}
		
	}
	
}
