package questionsonarrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//içerisinde aralıklar olan bir liste içerisinde kesişen aralıkları birleştiren ve liste olarak geri döndüren algoritma
class Interval{
	int start;
	int end;
	
	public Interval(int rigth,int left) {
		this.start=rigth;
		this.end=left;
	}
}
public class MergeOverlappingIntervals {
	
	public static List<Interval> mergeInterval(List<Interval> intervals){
		if(intervals.size()<2) {
			return intervals;
		}
		
		List<Interval> result=new ArrayList<>();
		
		//aralık elemanları sıralamamız gerekiyor.
		//iki aralığın başlangıç noktalarını kendi aralarında karşılaştırırız.
		Collections.sort(intervals,(a,b)-> Integer.compare(a.start, b.start));
		
		//ilk aralığı temp'e atarız.
		Interval temp=intervals.get(0);
		int start=temp.start;
		int end=temp.end;
		
		for(int i=1;i<intervals.size();i++) {
			//sıradaki ikinci elemanı temp'e atarız.
			temp=intervals.get(i);
			//ikinci elemanın başlangıç noktası ilk elemanın bitiş noktasından küçük mü
			//eğer küçükse iki aralık kesişiyor demektir.
			if(temp.start<=end) {
				//böylece bitiş noktasını güncelleriz. Yani ikinci elemanın bitiş noktası yeni bitiş noktamız olabilir
				//ya da ilk elemanın bitiş noktası ikinci elemanın'da bitiş noktasından büyükse yeni bitiş noktamız bu olur.
				end=Math.max(end, temp.end);
			}else {
				result.add(new Interval(start,end));
				start=temp.start;
				end=temp.end;
			}
		}
		
		result.add(new Interval(start,end));
		return result;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
