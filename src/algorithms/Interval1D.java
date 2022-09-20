package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Interval1D {
	//iki aralığı minimum bitiş noktasına göre karşılaştırır.
	public static final Comparator<Interval1D> MIN_ENDPOINT_ORDER  = new MinEndPointComparator();
	//iki aralığı maksimum bitiş noktasına göre karşılaştırır.
	public static final Comparator<Interval1D> MAX_ENDPOINT_ORDER = new MaxEndpointComparator();
	//iki aralığı uzunluğa göre karşılaştırır.
	public static final Comparator<Interval1D> LENGTH_ORDER = new LengthComparator();
	private final double max;
	private final double min;
	public double min() { 
	        return min;
	    }
	public double max() {
		return max;
	}
	//iki aralık arasında keşisim olup olmadığına bakan metot
	public boolean intersects(Interval1D that) {
		//Birinci elemanın minumum değeri ikinci elemanın maksimum değerinden küçükse
		if(this.max<that.min) return false;
		//Birinci elemanın minumum değer ikinci elemanın maksimum değerinden büyükse false değer döndürüyor.
		if(that.max<this.min) return false;
		//Yukardaki iki durum da aralığın dışını ifade ediyor.
		return true;
	}
	//aralığın bir değeri içerip içermediği
	public boolean contains(double x) {
		return (min<=x)&&(x<=max);
	}
	//aralık mesafesi
	public double length() {
        return max - min;
    }
	//ToString
	public String toString() {
		return "[" + min + ", " + max + "]";
	}
	//equals metodu
	public boolean equals(Object other) {
		if(other==this) return true;
		if(other==null) return false;
		if(other.getClass()!=this.getClass()) return false;
		Interval1D that=(Interval1D) other;
		return this.min==that.min &&this.max==that.max;
	}
	
	public Interval1D(double min,double max) {
		if(Double.isInfinite(min)||Double.isInfinite(max))
			throw new IllegalArgumentException("Bitiş noktaları sonlu olmalıdır.");
		if(Double.isNaN(min)||Double.isNaN(max))
			throw new IllegalArgumentException("Bitiş noktaları NaN olmamalıdır.");
		if(min==0.0)min=0.0;
		if(max==0.0)max=0.0;
		
		if(min<=max) {
			this.min=min;
			this.max=max;
		}
		else throw new IllegalArgumentException("geçersiz aralık.");
	}
	
	public static class MinEndPointComparator implements Comparator<Interval1D>{
		public int compare(Interval1D a,Interval1D b) {
			if(a.min<b.min) return -1;
			else if(a.min>b.min) return +1;
			//önce küçük değerlerden hangisi küçük ona bakıyor sonra aralığın büyük tarafına bakıyor.
			else if(a.max<b.max) return -1;
			else if(a.max>b.max) return +1;
			else return 0;
		}
	}
	 // bitiş noktasına göre küçükten büyüğe doğru sıralama 
    private static class MaxEndpointComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            if      (a.max < b.max) return -1;
            else if (a.max > b.max) return +1;
            //Önce büyük değerlere bakıyor eğer büyük değerlerin ikisi de eşitse aralığın küçük tarafında hangisi büyükse ona +1 değerini veriyor.
            else if (a.min < b.min) return -1;
            else if (a.min > b.min) return +1;
            else                    return  0;
        }
    }

    // ascending order of length
    private static class LengthComparator implements Comparator<Interval1D> {
        public int compare(Interval1D a, Interval1D b) {
            double alen = a.length();
            double blen = b.length();
            if      (alen < blen) return -1;
            else if (alen > blen) return +1;
            else                  return  0;
        }
    }
	
	public static void main(String[] args) {
		Interval1D [] aralik=new Interval1D[7];
		aralik[0]=new Interval1D(15.0,33.0);
		aralik[1]=new Interval1D(45.0,60.0);
		aralik[2]=new Interval1D(20.0,70.0);
		aralik[3]=new Interval1D(46.0,55.0);
		aralik[4]=new Interval1D(10.0,19.0);
		aralik[5]=new Interval1D(32.0,42.0);
		aralik[6]=new Interval1D(15.0,34.0);
		
		//Sıralanmamış
		StdOut.println("Sıralanmamış düzenleme");
		for(int i=0;i<aralik.length;i++) {
			System.out.println(aralik[i]);
		}
		
		StdOut.println("Küçük noktalara göre sıralama");
        Arrays.sort(aralik, Interval1D.MIN_ENDPOINT_ORDER);
        for (int i = 0; i < aralik.length; i++)
            StdOut.println(aralik[i]);
        StdOut.println();
        
        StdOut.println("Büyük bitiş noktasına göre sıralama");
        Arrays.sort(aralik, Interval1D.MAX_ENDPOINT_ORDER);
        for (int i = 0; i < aralik.length; i++)
            StdOut.println(aralik[i]);
        StdOut.println();
        
        StdOut.println("Uzunluğa göre sıralama");
        Arrays.sort(aralik, Interval1D.LENGTH_ORDER);
        for (int i = 0; i < aralik.length; i++)
            StdOut.println(aralik[i]);
        StdOut.println();
	}

}
