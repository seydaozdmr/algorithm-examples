package org.seydaozdemir;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Comparable_Interface {

	public static void main(String[] args) {
		List<String>ulkeler=new LinkedList<>();
		ulkeler.add("Türkiye");
		ulkeler.add("Almanya");
		ulkeler.add("Uganda");
		ulkeler.add("Japonya");
		ulkeler.add("Brezilya");
		ulkeler.add("Meksika");
		ulkeler.add("Rusya");
		ulkeler.add("Tibet");
		
		new Comparable_Interface().printlist(ulkeler);
		System.out.println("**********************");
		Collections.reverse(ulkeler);
		
		new Comparable_Interface().printlist(ulkeler);
	}
	void printlist(List<String> list) {
		ListIterator<String> iterable=list.listIterator();
		while(iterable.hasNext()) {
			System.out.println("ülkeler: "+iterable.next());
		}
		
	}

}
