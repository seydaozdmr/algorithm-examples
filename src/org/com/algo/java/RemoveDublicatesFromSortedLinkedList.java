package org.com.algo.java;

public class RemoveDublicatesFromSortedLinkedList {
	//sıralı bir linkedlist'de tekrar eden elemanları silen metod
	public Node removeDublicates(Node head) {
		Node temp=head;
		while(temp!=null && temp.next!=null) {
			if(temp.data==temp.next.data) {
				temp.next=temp.next.next;
			}else {
				temp=temp.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
