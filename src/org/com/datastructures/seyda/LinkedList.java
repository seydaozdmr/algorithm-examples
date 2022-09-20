package org.com.datastructures.seyda;

//import java.util.ArrayList;
//import java.util.List;

public class LinkedList {
	Node head;
	public void insert(int data) {
		//Linked List'lerin en önemli farkı veri boyutunun dinamik olması.
		//Aşağıda yaptığımız işlemi kısaca özetlemek gerekirse;
		//LinkedList'e yeni bir data eklemek için yeni bir node objesi yaratıyoruz.
		//Yeni yarattığımız objenin değeri node.data parametre olarak verdiğimiz değer yani eklemek istediğimiz değer
		//yeni node objemizin next değeri ise null yani boş
		//if bloğuna geldiğimizde eğer ilk değer boşsa ilk değerimiz yarattığımız node objesi oluyor
		//değilse ilk değerimiz Node n değerine atanıyor.
		//Döngü ile n değerimizin next değeri itere ediliyor ta ki son next değeri null olan yani bağlantısı olmayan değer bulunana kadar
		//Son değer bulununca son değerin next değeri n değerine eşitleniyor ve son değer'in next değeri ilk başta eklediğimiz node objesi oluyor
		//Yani yarattığımız node objesini son değere eklemiş oluyoruz.
		Node node=new Node();
		node.data=data;
		node.next=null;
		if(head==null) {
			head=node;
		}else {
			Node n=head;
			while(n.next!=null) {
				//Burada her defasında null değerini bulana kadar n next eleman'a eşitleniyor.
				//Node n head'dan başlamak üzeri null olan elemanı bulana kadar devam ediyor.
				//Son elemanı bulup n'i son elemana ekliyor.
				//Böylece son elemanın n.next'i yukarıda tanımladığımız ve sona eklemek istediğimiz eleman oluyor.
				n=n.next;
			}
			//Son node'un next değeri yukarıda yeni eklenen node oluyor.
			n.next=node;
		}
	}
	public Node siraliekle(int data) {
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if(head==null) {
			head=node;	
			return head;
		}
		if(head.data>data) {
			node.next=head;
			head=node;
			return head;
		}
			Node n=head;
			while(n.next!=null && n.next.data<data) {
				n=n.next;
			}//Node temp eleman yani geçici eleman'ın next'ine iter yani n.next'in değeri veriliyor.
			//n.next'in yeni değeri de node oluyor ve node yani geçiçi eleman araya ekleniyor.
			node.next=n.next;
			n.next=node;
			return n;
	}
	public void show() {
		//root değerini gösteriyor ilk başta 
		//ilk iterator Node node oluyor.
		Node node=head;
		//Liste elemanlarına erişmek için liste elemanları üzerinde hareket ediyoruz.
		while(node.next!=null){
			//linked list üzerinde dolaşan aynı tipte bir iterator yapısı
			System.out.println(node.data);
			//iter next yapılıyor, next kutuyu gösteriyor.
			node=node.next;
		}
		System.out.println(node.data);
	}
	public void insertAt(int index,int data) {
		int sayac=0;
		Node node=new Node();
		node.data=data;
		node.next=null;
		//Eklemek istediğimiz node'un head'inden başlayarak gezmek için: Node n=head eşitliğini sağlıyoruz.
		//while döngüsüyle n değerinin next'inin null olduğu noktaya kadar geziyoruz.
		Node n=head;
		boolean flag=false;
		while(n.next!=null) {
			if(index==0) {
				insertAtStart(data);
				flag=true;
				break;
			}else {
				if((sayac+1)==(index)) {
					    node.next=n.next;//node'un next'ine aşağıdaki geçici elemanın next'i veriliyor.
						n.next=node; //Tutan elemanın next'i de node a bağlanıyor.
						flag=true;
						break;					
				}else {
					n=n.next;//geçici eleman ondan sonraki elemanı tutuyor.
					sayac+=1;
					System.out.println(sayac);
					}
				}	
			}
		if(flag==false) {
			insert(data);
		}
	}
		
	public void insertAtStart(int data) {
		Node node=new Node();
		node.data=data;
		node.next=null;
		node.next=head;
		head=node;
	}
	public void deleteAt(int index) {
		if(index==0) {
			head=head.next;
			
		}else {
			Node n=head;
			Node node=null;//bunu while ile yaz.
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
			node=n.next;
			n.next=node.next;
		}
	}
	//sondan kaçıncı elemanı silmek istediğimizi gösteren iki metot
	public Node removeNodeFromEnd(int n) {
		//bu sınıfta yaratılan head'i alıyoruz. 
		Node temp=head;
		//önce linked List'in uzunluğunu yani kaç elemana sahip olduğunu belirliyoruz
		int len=0;
		while(temp!=null) {
			temp=temp.next;
			len++;
		}
		//daha sonra silmek istediğimiz elemanın sondan pozisyonunu belirliyoruz
		int pos=len-n+1;
		
		temp=head;
		len=0;
		while(temp!=null) {
			len++;
			if(pos-1==len) {
				temp.next=temp.next.next;
			}
			temp=temp.next;
		}
		return head;
	}
	public Node removeNodeFromEndSinglePass(int n) {
		Node slow=head;
		Node fast=head;
		
		for(int i=1;i<=n;i++) {
			fast=fast.next;
		}
		
		if(fast==null) {
			head=head.next;
			return head;
		}
		
		while(fast.next!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;
		
		return head;
	}
	
	
	//değere göre silme fonksiyonunu yaz...
	public Node sil(int deger) {
		Node node=new Node();
		node.data=deger;
		node.next=null;
		Node n=head;
		if(n.data==node.data) {
			head=n.next;
			System.out.println("değer"+n.data);
			return n;
		}
		while(n.next!=null && n.next.data!=node.data) {
			n=n.next;
		}
		if(n.next==null) {
			System.out.println("silinecek eleman bulunamadı...");
			return n;
		}			
		node=n.next;
		n.next=node.next;
		return n;
	}
}
