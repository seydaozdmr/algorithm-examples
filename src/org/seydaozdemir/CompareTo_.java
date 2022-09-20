package org.seydaozdemir;

import java.util.LinkedList;
import java.util.List;

public class CompareTo_ {

	public static void main(String[] args) {

		int sonuc;
		List<String> ulkeler=new LinkedList<>();
		ulkeler.add("a");
		sonuc=ulkeler.get(0).compareTo("a");
		System.out.println(sonuc);
	}

}
