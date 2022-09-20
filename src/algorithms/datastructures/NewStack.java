package algorithms.datastructures;

import java.util.Iterator;

public class NewStack<Item> implements Iterable<Item> {
	//Node sınıfımız
	private class Node{
		Item item;
		Node next;
	}
	//Bağlı listenin ilk elemanı head ve eleman sayısını tutan size
	private Node head;
	private int size;
	//Yeni bir düğüm yaratan metot
	public Node createNode(Item item) {
		Node yeni=new Node();
		yeni.item=item;
		return yeni;
	}
	//Bağlı listenin boş olup olmadığını soran metot
	public boolean isEmpty() {
		return head==null;
	}
	//Bağlı listenin eleman sayısını döndüren metot.
	public int size() {
		return size;
	}
	//Eleman eklemek için çalışan metot
	public void add(Item item) {
		if(isEmpty()) {
			head=new Node();
			head.item=item;
		}else {
			Node temp;
			//Aşağıdaki döngü yapısını ilk defa kullanıyorum;
			//Burada amaç ilk elemandan başlayarak, sonraki elemanı boş olan elemana kadar iterasyon gerçekleştiriyoruz.
			//Ve temp son elemanı tutana kadar iterasyon devam ediyor, döngünün şartı bu
			for(temp=head;temp.next!=null;temp=temp.next);
			/* Node temp=head;
			 * while(temp.next!=null){
			 * 		temp=temp.next;
			 * }
			 * */
			Node newNode=new Node();
			newNode.item=item;
			temp.next=newNode;
		}
		size++;
	}
	//son elemanı silen metot
	public void deleteLast() {
		if(!isEmpty()) {
			if(size==1) {  //eleman sayısı 1 ise tek eleman olduğu anlamına geliyor
				head=null; // ilk elemanı null olarak atıyor.
			}else {
				Node temp=head;
				while(temp.next.next!=null) {
					temp=temp.next;
				}
				temp.next=null;
			}
			size--;
		}
	}
	//belirli bir indexteki elemanı silen metot
	public void deleteAt(int k) {
		//Eğer k değeri toplam eleman sayısından büyükse ya da liste boş ise hiçbir şey yapma
		if(isEmpty()|| k>size) {
			return;
		}
		//eğer k 1'e eşitse bir tane eleman olduğu anlamına geliyor, ilk elemanı sil.
		if(k==1) {
			head=head.next;
		}else {
			Node temp;
			int count=1;
			//temp ilk elemandan başlıyor
			//bağlı liste üzerinde gezmeye başlıyor
			for(temp=head;temp!=null;temp=temp.next) {
				if(count==k-1 && temp.next!=null) {
					//eğer elemanları sayan count ile silmek istediğimiz elemanın bir eksiği eşitse (bunun sebebi ilk elemanı yukarda
					//değerlendirdiğimiz için 2. elemandan başlıyor oluşumuz. ve istediğimiz eleman null değilse
					//temp.next'i ile olan bağını koparıp next'in next'ine yanı silmek istediğimiz elemanla olan bağı koparıp bir sonraki elemana
					//bağlayarak silme iştemini gerçekleştirmiş oluyoruz.
					temp.next=temp.next.next;
					break;
				}
				count++;
			}
		}
		size--;
	}
	
	//Bir değerin olup olmadığını arayan metot
	public boolean find(String key) {
		if(isEmpty()) {
			return false;
		}
		boolean contains=false;
		Node temp;
		for(temp=head;temp!=null;temp=temp.next) {
			//Eğer temp'in item değeri key değerine eşitse contains true döner.
			if(temp.item.equals(key)) {
				contains=true;
				break;
			}
		}
		return contains;
	}
	
	//Parametre olarak alınan düğümün silindiği metot
	public void removeAfter(Node node) {
		if(isEmpty() || node==null) {
			return;
		}
		
		Node temp;
		for(temp=head;temp!=null;temp=temp.next) {
			if(temp.item.equals(node.item)) {
				if(temp.next!=null) {
					temp.next=temp.next.next;
					size--;
				}
			break;
			}
		}
	}
	//Parametre olarak iki tane bağlı liste düğümü alıp sırasıyla ekleyen algoritma
	//İlk eleman bağlı listede olan eleman, ikinci eleman o elemandan sonra gelen eleman.
	//Eğer ilk eleman sıradan bir elemanla eşleşirse arkasına ikinci elemanı ekliyoruz.
	public void insertAfter(Node first,Node second) {
		if(isEmpty() || first==null || second==null) {
			return;
		}
		
		Node temp;
		for(temp=head;temp!=null;temp=temp.next) {
			if(temp.item.equals(first.item)) {
				second.next=temp.next;
				temp.next=second;
				size++;
			}
		}
	}
	
	//Listede aranan bir değere sahip bütün düğümleri silen remove metodu
	public void remove(Item key) {
		if(isEmpty() || key==null) {
			return;
		}
		//İlk eleman eğer silmek istediğimiz elemansa ilk elemanı siler
		//daha sonra eğer ilk elemandan sonra gelen elemanlarda silmek istediğimiz değere eşitse silmeye devam eder.
		while(head!=null && head.item.equals(key)) {
			head=head.next;
			size--;
		}
		Node temp;
		for(temp=head;temp!=null;temp=temp.next) {
			//Buradaki algoritmada next önce temp'in önündeki elemanı tutuyor.
			Node next=temp.next;
			//Eğer next null değilse ve next'in değeri aranan değere eşitse
			while(next!=null && next.item.equals(key)) {
				//Next'in değeri next'den sonra gelen elemana eşitleniyor.
				//Bu döngü bu ihtimaller doğru olduğu sürece devam ediyor.
				//Ard arda gelen "4" değerlerini sırasıyla siliyor.
				next=next.next;
				size--;
			}
			//Daha sonra temp'in next'ine en son oluşan yani silme işlemi sonrasında oluşan next bağlanıyor.
			temp.next=next;
		}
	}
	
	//Bağlı liste içerisindeki maksimum değeri bulan metot
	public int max() {
		if(isEmpty()) {
			return 0;
		}
		int maxValue=(Integer)head.item;
		
		Node temp;
		for(temp=head;temp!=null;temp=temp.next) {
			int tempValue=(Integer) temp.item;
			if(tempValue>maxValue) {
				maxValue=tempValue;
			}
		}
		return maxValue;
	}
	//Recursive max metodu
	public int maxRecursive() {
		if(isEmpty()) {
			return 0;
		}
		int tempMaxValue=(Integer)head.item;
		return maxRecursive(head.next,tempMaxValue);
	}
	private int maxRecursive(Node node, int tempMaxValue) {
		if(node==null) {
			return tempMaxValue;
		}
		int tempValue=(Integer) node.item;
		if(tempValue>tempMaxValue) {
			tempMaxValue=tempValue;
		}
		return maxRecursive(node.next,tempMaxValue);
	}
	//Bir bağlı listeyi tersine çeviren reverse metodu
	public Node reverse() {
		if(isEmpty()) {
			return null;
		}
		if(size==1) {
			return head;
		}
		Node old=head;
		Node current=head.next;
		Node newNode=head.next.next;
		
		head.next=null;
		current.next=old;
		
		while(newNode!=null) {
			old=current;
			current=newNode;
			newNode=newNode.next;
			current.next=old;
			head=current;
		}
		return head;
	}
	
	//Reverse improved
	public Node reverse2() {
		//boş elemanlar bağlı liste elemanlarını sırayıla tutar
		//aralarındaki bağlar kopartılıp bir önceki elemana bağlanır.
		//sonuc olarak reverse en sona kadar gider ve liste tersine çevrilmiş olur.
		Node reverse=null;
		while(head!=null) {
			Node second=head.next;
			head.next=reverse;
			reverse=head;
			head=second;
		}//eğer liste boşsa null değer olarak döner
		//eğer bir tane eleman varsa yukardaki döngü bir kez döner head null olur 
		//reverse head'in değerini tutar böylelikle head aşağıda tekrar kendi değerini tutar 
		//ve reverse tek eleman olarak döner.
		head=reverse;
		return reverse;
	}
	//Reverse by hindi
	public Node reverseHindi() {
		//Bütün işlemi yürüten 3 adet düğüm var bunlar current,previous,next
		Node current=head;
		Node previous=null;
		Node next=null;
		while(current!=null) {
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		head=previous;
		return previous;
	}
	
	
	public void show() {
		Node temp;
		for(temp=head;temp!=null;temp=temp.next) {
			System.out.println(temp.item);
		}
	}
	
	
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item> {
		Node current = head;
		
		@Override
		public boolean hasNext() {
			return current != null; 
		}
		
		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			
			return item;
		}
	}
	
	
	
	

	public static void main(String[] args) {
		NewStack<String> linkedList=new NewStack<>();
		
		linkedList.add("0");
		linkedList.add("1");
		linkedList.add("2");
		linkedList.add("3");
		linkedList.add("4");
		linkedList.add("4");
		linkedList.add("4");
		linkedList.add("5");
		linkedList.add("6");
		System.out.println("******ADD**********");
		linkedList.show();
		System.out.println("******REVERSE*******");
		linkedList.reverse();
		linkedList.show();
		
		System.out.println("******DELETE LAST**********");
		linkedList.deleteLast();
		linkedList.show();
		System.out.println("******FIND 2***********");
		System.out.println(linkedList.find("2"));
		
		linkedList.removeAfter(linkedList.createNode("2"));
		System.out.println("******REMOVE AFTER 2*******");
		linkedList.show();
		System.out.println("********INSERT 10 AFTER 4*******");
		linkedList.insertAfter(linkedList.createNode("4"), linkedList.createNode("10"));
		linkedList.show();	
		System.out.println("********REMOVE 4*******");
		linkedList.remove("4");
		linkedList.show();
		System.out.println("Removed all 4.");
		
		
		
		NewStack<Integer> sayilar=new NewStack<>();
		sayilar.add(1);
		sayilar.add(2);
		sayilar.add(3);
		sayilar.add(4);
		System.out.println("Max value of sayilar:  "+sayilar.max());
		sayilar.show();
		System.out.println("********REVERSE 2*********");
		sayilar.reverse2();
		sayilar.show();	
		System.out.println("******KELİMELER*******");
		NewStack<String> kelimeler=new NewStack<>();
		kelimeler.add("to");
		kelimeler.add("be");
		kelimeler.add("or");
		kelimeler.add("not");
		kelimeler.add("to");
		kelimeler.add("be");
		kelimeler.show();
		System.out.println("///REVERSE\\\\");
		kelimeler.reverseHindi();
		kelimeler.show();
		
	}
}
