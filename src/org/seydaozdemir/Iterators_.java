package org.seydaozdemir;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iterators_ {

	public static void main(String[] args) {

		List<String> ulkeler=new LinkedList<>();
		ulkeler.add("Türkiye");
		ulkeler.add("Almanya");
		ulkeler.add("Çin");
		ulkeler.add("Finlandiya");
		ulkeler.add("İran");
		ulkeler.add("Fas");
		new Iterators_().printList(ulkeler);
		System.out.println("*****************");
		ulkeler.sort(null);
		new Iterators_().printList(ulkeler);
		System.out.println("*****************");
		Collections.reverse(ulkeler);
		System.out.println("*****************");
		new Iterators_().printList(ulkeler);
	}
	void printList(List<String> list) {
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.println("Ülke: "+iterator.next());
		}
	}

}
