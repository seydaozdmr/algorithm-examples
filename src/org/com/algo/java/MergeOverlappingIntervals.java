package org.com.algo.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval{
	int start;
	int end;
	
	public Interval(int start,int end) {
		this.start=start;
		this.end=end;
	}
}

public class MergeOverlappingIntervals {
	
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals.size()<2) {
			return intervals;
		}
		
		List<Interval> output=new ArrayList<>();
		//önce aralıkları sıralıyoruz, start elemanlarını küçükten büyüğe doğru
		Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
		//elemanları gezeceğimiz temp aralığını ilk elemandan başlatıyoruz.
		Interval temp=intervals.get(0);
		//ilk elemanın start ve end değerlerini tutuyoruz.
		int start=temp.start;
		int end=temp.end;
		
		for(int i=1;i<intervals.size();i++) {
			//temp ikinci eleman oluyor.
			temp=intervals.get(i);
			//ilk elemanın tuttuğumuz end değeri ile ikinci elemanın start değerini 
			if(temp.start<=end) {
				end=Math.max(end, temp.end);
			}else {
				output.add(new Interval(start,end));
				start=temp.start;
				end=temp.end;
			}
		}
		output.add(new Interval(start,end));
		
		return output;
				
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
