package algorithms.datastructures;

public class DoubleLinkedList {
	private class Node{
		String item;
		Node next;
		Node prev;
	}
	
	private Node first;
	private Node last;
	private int size;
	
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	
	public void insertAtBeginning(String item) {
		Node oldfirst=first;
		first=new Node();
		first.item=item;
		first.next=oldfirst;
		
		if(oldfirst!=null) {
			oldfirst.prev=first;
		}
		if(isEmpty()) {
			last=first;
		}
		size++;
	}
	
	public void insertBeforeNode(String oncekideger,String deger) {
		if(isEmpty()) {
			return;
		}
		Node current;
		for(current=first;current!=null;current=current.next) {
			if(current.item.contentEquals(oncekideger)) {
				break;
			}
		}
		if(current!=null) {
			Node newNode=new Node();
			newNode.item=deger;
			
			Node prevNode=current.prev;
			current.prev=newNode;
			newNode.next=current;
			newNode.prev=prevNode;
			
			if(newNode.prev==null) {
				first=newNode;
			}else {
				newNode.prev.next=newNode;
			}
			size++;
		}
	}
	
	
	public void insertAtTheEnd(String item) {
		Node oldlast=last;
		last=new Node();
		last.item=item;
		last.prev=oldlast;
		if(oldlast!=null) {
			oldlast.next=last;
		}
		
		if(isEmpty()) {
			first=last;
		}
		size++;
	}
	
	public void insertAfterNode(String sonraki,String deger) {
		if(isEmpty()) {
			return;
		}
		//iterasyon düğümü current
		Node current;
		for(current=first;current!=null;current=current.next) {
			//gezen elemanımız aranan değeri bulana kadar ilerliyor
			if(current.item.equals(sonraki)) {
				break;
			}
		}
		
		if(current!=null) {
			//araya eklenecek olan newNode düğümü yaratılıyor ve item değeri deger olarak atanıyor
			Node newNode=new Node();
			newNode.item=deger;
			
			//nextNode bulduğumuz node değerinin bir sonraki değerini tutan düğümümüz
			Node nextNode=current.next;
			//Bulduğumuz değerin next'ine newNode yeni değerimizi bağlıyoruz.
			current.next=newNode;
			//NewNode yeni değerimizin önceki prev değerine bulduğumuz current nodu ile birleştiriyoruz.
			newNode.prev=current;
			//newNode yeni düğümümüzün next değerini nextNode düğümü ile birleştirerek araya eklenmesini sağlıyoruz.
			newNode.next=nextNode;
			//eğer yeni node değerimizden sonra herhangi bir değer yoksa yeni değer son sıraya ekleniyor.
			if(newNode.next==null) {
				last=newNode;
			}else {
				//son olarak newNode düğümümüzün next'inde bulunan düğümün prev değerini newNode düğümümüz ile birleştiriyoruz.
				newNode.next.prev=newNode;
			}
			size++;
		}
	}
	
	public String removeFromTheBeginnig() {
		if(isEmpty()) {
			return null;
		}
		String item=first.item;
		if(first.next!=null) {
			first.next.prev=null;
		}else {
			last=null;
		}
		
		first=first.next;
		size--;
		return item;
	}
	
	public String removeFromEnd() {
		if(isEmpty()) {
			return null;
		}
		String item=first.item;
		//last'ın prev'i null değilse 
		if(last.prev!=null) {
			//son düğümün öndeki elemanın next bağı kopartılıyor, null değeri atanıyor.
			last.prev.next=null;
		}else {
			first=null;
		}
		
		last=last.prev;
		size--;
		return item;
	}
	
	//istenen indexte bulunan düğümü silen metot
	public String removeItemWithIndex (int nodeIndex) {
		if(isEmpty() || nodeIndex<=0 || nodeIndex>size()) {
			return null;
		}
		
		boolean startFromTheBeginning=nodeIndex<=size()/2;
		//aranan nodeIndex eğer toplam düğüm sayısının yarısından küçükse başlangıçtan başla değilse sondan başla
		int index=startFromTheBeginning ? 1:size(); //index eğer başlangıçtan başlıyorsa 1 bitişten başlıyorsa bağlı liste uzunluğunun değeri yani size;
		Node current=startFromTheBeginning?first:last; //eğer gezmeye baştan başlarsa current=first, sondan başlarsa current=last;
		
		while (current!=null) {
			if(nodeIndex==index) {
				break;
			}
			if(startFromTheBeginning) {
				index++;
			}else {
				index--;
			}
			current=startFromTheBeginning ? current.next:current.prev;
		}
		
		String item=current.item;
		Node prevNode=current.prev;
		Node nextNode=current.next;
		
		if(prevNode!=null) {
			prevNode.next=nextNode;
		}
		if(nextNode!=null) {
			nextNode.prev=prevNode;
		}
		//Yukarıdaki iki eğer de doğru olarak çalışırsa current yani aradığımız değerin önceki düğümü sonrakine, sonraki de öncekine bağlanır 
		//Böylece istediğimiz ara düğümü silmiş oluruz.
		
		//Eğer ara değer değilde ilk ya da son düğümü silmek istersek aşağıda belirtilen kodlar işlem yapar.
		if(current==first) {
			first=nextNode;
		}
		if(current==last) {
			last=prevNode;
		}
		size--;
		return item;
	}
	
	public void show() {
		Node current=first;
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}
	
	public static void main(String[] args) {
		DoubleLinkedList liste=new DoubleLinkedList();
		liste.insertAtBeginning("ali");
		liste.insertAtBeginning("veli");
		liste.insertAtBeginning("mahmut");
		liste.insertAtBeginning("huseyin");
		liste.insertAtBeginning("yasin");
		liste.insertAtBeginning("yunus");
		liste.insertAtBeginning("emrah");
		liste.insertAtBeginning("apo");
		liste.show();
		System.out.println(liste.size());
		System.out.println(liste.first.item);
		System.out.println(liste.removeFromTheBeginnig());//ilk elemanı sil
		System.out.println(liste.size());
		System.out.println("***InsertBeforeNode***");
		liste.insertBeforeNode("yasin", "çetin"); //Bir önceki yere ekler
		liste.show();
		System.out.println("***InsertAfterNode***");
		liste.insertAfterNode("yasin", "mustafa");
		liste.show();
		System.out.println("***InsertEndNode***");
		liste.insertAtTheEnd("seyda");
		liste.show();
		
		
	}

}
