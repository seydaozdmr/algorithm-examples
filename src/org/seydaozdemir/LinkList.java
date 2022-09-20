package org.seydaozdemir;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkList {
	public static void main(String[] args) {
		LinkedList<String> ulkeler=new LinkedList<>();
		ulkeler.add("Türkiye");
		ulkeler.add("Finlandiya");
		ulkeler.add("Fransa");
		ulkeler.add("Almanya");
		ulkeler.add("Japonya");
		new LinkList().printulkeler(ulkeler);
		
		ArrayList<String> demo=new ArrayList<>();
		demo.add("Bir");
		demo.add("İki");
		demo.add("Üç");
		demo.add("Dört");
		new LinkList().printulkeler(demo);
	}
	//LinkedList ve ArrayList List intefacenını implemente ettikleri için ikisininde elemanlarını printulkeler ile yazdırabiliyoruz.
	void printulkeler(List<String> ulkeler) {
		
		for(String ulke:ulkeler) {
			System.out.println(ulke);
		}
		System.out.println("*****************");
	}
	
	

}
