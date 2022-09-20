package org.com.algo.java;

public class SortaLinkedList0s1s2s {
	
	//Güzel bir algoritma
	private Node head;
	
	public Node sortLinkedList() {
		//Bir LinkedList içerisindeki 0ları 1leri ve 2leri sıraya dizeceğiz bunun için her birinden kaç tane olduğunu tespit edebilmek için 
		//bir dizi oluşturuyoruz ve dizimizin her bir elemanı 0,1 ve 2'nin bulunma miktarını sembolize ediyor.
		int[]countArr= {0,0,0};
		
		Node temp=head;
		while(temp!=null) {
			//temp data sıradaki elemanın değeri (0,1,2)
			countArr[temp.data]++;
			temp=temp.next;
		}
		//sonra başa dönüyoruz.
		temp=head;
		int i=0;
		//temp null olmayana kadar devam et
		while(temp!=null) {
			//eğer countArr'nin sıfırdan başlamak üzere sıradaki değeri 0 ise i'yi bir arttır yani (0,1,2) elemanlarından herhangi birinden 
			//Linked Listte bulunmuyorsa onun sırasını geç.
			if(countArr[i]==0) {
				i++;
			}
			//Kaç tane buluyorsa o kadar elemanı baştan başlamak üzere 0,1,2 ile doldur. yani Linked List'imizi baştan dizayn ediyoruz.
			
			else {
				temp.data=i;
				//yerine yerleştirdiğimiz kadar siliyoruz
				countArr[i]--;
				temp=temp.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(0);
		Node n4=new Node(1);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		Node temp=n1;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
		
		SortaLinkedList0s1s2s liste=new SortaLinkedList0s1s2s();
		liste.head=n1;
		liste.sortLinkedList();
		
		Node temp2=liste.head;
		while(temp2!=null) {
			System.out.println(temp2.data);
			temp2=temp2.next;
		}
		
	}

}
