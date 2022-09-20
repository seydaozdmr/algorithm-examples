package algorithms;

public class MyHistogram {

	public static void main(String[] args) {
		int aralik=7;
		int enkucuk=10;
		int enbuyuk=51;
		int[]yaslar={10,11,12,17,19,20,20,24,25,29,30,31,31,32,32,34,35,36,36,36,37,37,37,37,39,40,40,41,41,41,42,42,43,43,44,45,46,46,46,47,47,48,50};
		
		histogram(aralik,enkucuk,enbuyuk,yaslar);

	}

	private static void histogram(int aralik, int enkucuk, int enbuyuk, int[] yaslar) {
		int[]aralikMiktarlari=new int[aralik];
		double aralikBuyuklugu=(enbuyuk-enkucuk)/aralik;
		histogramDegerleriniHesapla(aralik,enkucuk,enbuyuk,yaslar,aralikMiktarlari);
		for(int i=0;i<aralikMiktarlari.length;i++) {
			System.out.println(aralikMiktarlari[i]);
		}
		
		int maxCount=StdStats.max(aralikMiktarlari);
		
		double minX=enkucuk-1;
		double maxX=enbuyuk+1;
		double minY=-2;
		double maxY=maxCount +2;
		
		StdDraw.setCanvasSize(1024,512);
		StdDraw.setXscale(minX, maxX);
		StdDraw.setYscale(minY,maxY);
		double middleX = minX + (maxX - minX) / 2;
		double middleY = minY + (maxY - minY) / 2;
		
		//Etiketler
		StdDraw.text(middleX, maxY - 0.5, "Aralıktaki Yaşlar");
		StdDraw.text(minX + 0.25, middleY, "Yaşlar", 90);
		StdDraw.text(middleX, -1.2, "Aralık");
		
		//X ekseni
		for(int x = 0; x < aralik; x++) {
			double minValue = enkucuk + (aralikBuyuklugu * x);
			double maxValue = minValue + aralikBuyuklugu - 0.01;
			String intervalDescription = String.format("[%.2f - %.2f]", minValue, maxValue);
			StdDraw.text(enkucuk + (x + 0.5) * aralikBuyuklugu, -0.25, intervalDescription);
		}
		
		//Y ekseni
		for(int y = 0; y < maxY; y++) {
			StdDraw.text(minX + 0.7, y, String.valueOf(y));
		}
		for (int i = 0; i < aralik; i++) {

			double x = enkucuk + (i + 0.5) * aralikBuyuklugu;
			double y = aralikMiktarlari[i] / 2.0;
			double halfWidth = aralikBuyuklugu / 3.0;
			double halfHeight = aralikMiktarlari[i] / 2.0;

			StdDraw.filledRectangle(x, y, halfWidth, halfHeight);
		}
		
		
	}

	private static void histogramDegerleriniHesapla(int aralik, int enkucuk, int enbuyuk, int[] yaslar,
			int[] aralikMiktarlari) {
		int interval=enbuyuk-enkucuk;
		double aralikSayilari=interval/aralik;
		
		int aralikIndexi;
		for (int i=0;i<yaslar.length;i++) {
			aralikIndexi=0;
			for(int j=enkucuk;j<=enbuyuk && aralikIndexi<aralik;j+=aralikIndexi) {
				if(yaslar[i]>=j&&yaslar[i]<=j+aralikSayilari) {
					aralikMiktarlari[aralikIndexi]++;
				}
				aralikIndexi++;
			}
			
		}
	}

}
