package algorithms.hindi;

import java.util.ArrayList;
import java.util.List;

public class arrayofarray {

	public static void main(String[] args) {
		List<List<Integer>> arr=new ArrayList<>();
		
		List<Integer> a1=new ArrayList<>();
		a1.add(11);
		a1.add(2);
		a1.add(4);
		List<Integer> a2=new ArrayList<>();
		a1.add(4);
		a1.add(5);
		a1.add(6);
		
		List<Integer> a3=new ArrayList<>();
		a1.add(10);
		a1.add(8);
		a1.add(12);
		
		arr.add(a1);
		arr.add(a2);
		arr.add(a3);
		
		for(int i=0;i<3;i++) {
			System.out.println(arr.get(i));
		}
		
		
		
		

	}

}
