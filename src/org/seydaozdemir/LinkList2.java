package org.seydaozdemir;

import java.util.LinkedList;

public class LinkList2 {
	public static void main(String[] args) {
		LinkedList<String> ulkeler=new LinkedList<>();
		ulkeler.add("Türkiye");
		ulkeler.add("Finlandiya");
		ulkeler.add("Fransa");
		ulkeler.add("Almanya");
		ulkeler.add("Japonya");
		new LinkList2().printulkeler(ulkeler);
	}
	void printulkeler(LinkedList<String> ulkeler) {
		
		for(String ulke:ulkeler) {
			System.out.println(ulke);
		}
		System.out.println("*****************");
	}
}
