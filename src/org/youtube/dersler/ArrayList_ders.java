package org.youtube.dersler;

import java.util.ArrayList;

public class ArrayList_ders {
	public static void main(String[] args) {
		ArrayList<String> liste=new ArrayList<>();
		liste.add("Gazipaşa");
		liste.add("Alanya");
		liste.add("Manavgat");
		liste.add("Serik");
		System.out.println(liste);
		
		for(String eleman:liste) {
			System.out.println(eleman);
		}
		
		for(int i=0;i<liste.size();i++) {
			System.out.println(liste.get(i));
		}
		
		
	}
	
	
}
