package org.com.datastructures.seyda;

public class DoubleListRunner {

	public static void main(String[] args) {
		DoubleLinkedList list=new DoubleLinkedList();
		list.siraliekle(10);
		list.siraliekle(1);
		list.siraliekle(500);
		list.siraliekle(50);
		list.show();
		list.sil(55);
		list.sil(1);
		list.sil(500);
		list.sil(50);
		list.show();
	}

}
