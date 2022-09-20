package org.com.algo.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisapeearedArray {
	
	public static List<Integer> findNumberDisappeared(int[] nums){
		List<Integer> liste=new ArrayList<>();
		
		int len=nums.length;
		Set<Integer> st=new HashSet<>();
		
		for(int i=0;i<len;i++) {
			st.add(nums[i]);
		}
		
		for(int i=1;i<=len;i++) {
			if(!st.contains(i)) {
				liste.add(i);
			}
		}
		return liste;
	}

	public static void main(String[] args) {
		int[] arr= {2,3,3,4,5};
		ArrayList<Integer> sonuc=(ArrayList<Integer>) findNumberDisappeared(arr);
		for(int i:sonuc) {
			System.out.println(i);
		}
		
		

	}

}
