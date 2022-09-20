package org.seydaozdemir;

import java.util.ArrayList;

public class AppArrayList {
	static ArrayList<String> listNames=new ArrayList<String>();
	
	public static void main(String[] args) {
		listNames.add("Seyda");
		listNames.add("John");
		listNames.add("Steve");
		listNames.add("Salim");
		listNames.add("Anhel");
		listNames.add("Mia");
		listNames.add("Pooja");
		listNames.add("John");
		AppArrayList app=new AppArrayList();
		app.displayList(listNames);
		app.removeNamebyPosition(0);
		System.out.println("********************************");
		app.displayList(listNames);
		//elemanı sildikten sonra elemanlar tekrar dizilir
		//Yani sıfırıncı elemanı sildiğimizde birinci eleman sıfırıncı eleman olur.
		System.out.println("********************************");
		app.removeNamebyName("Mia");
		app.displayList(listNames);
		System.out.println("********************************");
		app.modifyName(0, "Yeni İsim");
		app.displayList(listNames);
	}
	void removeNamebyPosition(int position) {
		listNames.remove(position);
	}
	void removeNamebyName(String name) {
		listNames.remove(name);
	}
	void displayList(ArrayList<String>names) {
		for(String name:names) {
			System.out.println(name);
		}
	}
	void modifyName(int position,String newName) {
		listNames.set(position, newName);
	}

}
