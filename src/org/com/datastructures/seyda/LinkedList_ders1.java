package org.com.datastructures.seyda;

//import java.util.ArrayList;
//import java.util.List;

public class LinkedList_ders1 {
	public static void main(String [] args) {
		//LinkedList
		//insert (5) end
		//insertAt(3,12) 3. node'a
		//insertsAtStart(18) start
		//delete(2) 2.elemanı siler
		//show() display all the elements
		
		//LinkedList list=new LinkedList();
		//list.insert(10);
		//list.insert(20);
		//list.insert(30);
		//eleman eklemek için
		//list.insertAt(3, 15);
		//eleman silmek için
		//list.deleteAt(3);
		//list.show();
		LinkedList list2=new LinkedList();
		list2.siraliekle(10);
		list2.siraliekle(1);
		list2.siraliekle(100);
		list2.siraliekle(50);
		list2.siraliekle(5);
		list2.siraliekle(500);
		list2.show();
		list2.sil(1);
		list2.show();
		list2.sil(50);
		list2.show();
		list2.sil(500);
		list2.sil(999);
		list2.show();
		/*
		 * public static void main(String [] args) {
		List<Integer> sayilar=new ArrayList<Integer>();
		for (int i=0;i<10;i++) {
			sayilar.add(i*i);
		}
		System.out.println(sayilar);
		
		LinkedList list2=new LinkedList();
		for(int i=0;i<sayilar.size();i++)
		{
			list2.siraliekle(sayilar.get(i));
		}
		list2.show();
	}
		 */
		
		
	}
}
