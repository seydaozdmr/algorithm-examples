package algorithms.hindi;



public class LinkedLists2 {
	private static class LinkNode{
		int value;
		LinkNode next;
		
		public LinkNode(int value) {
			this.value=value;
			this.next=null;
		}
	}
	private LinkNode head;
	
	public LinkNode addStart(LinkNode head,int value) {
		if(head==null) {
			return head;
		}
		LinkNode temp=head;
		head.value=value;
		head.next=temp;
		return head;
	}
	
	public LinkNode addStart2(LinkNode head,int value) {
		LinkNode temp=new LinkNode(value);
		if(head==null) {
			return temp;
		}
		temp.next=head;
		head=temp;
		return head;
	}
	
	public void show(LinkNode head) {
		if(head==null) {
			System.out.println("Liste boş.");
		}else {
			LinkNode current=head;
			while(current!=null) {
				System.out.println(current.value);
				current=current.next;
			}
		}
	}
	
	public LinkNode reverse(LinkNode head) {
		if(head==null) {
			return head;
		}
		LinkNode current=head;
		LinkNode prev=null;
		LinkNode next=null;
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return prev;
	}
	
	public LinkNode midNode(LinkNode head) {
		if(head==null) {
			return null;
		}
		LinkNode slow=head;
		LinkNode fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public int lenght(LinkNode head) {
		int size=0;
		if(head==null) {
			return -1;
		}
		LinkNode temp=head;
		while(temp!=null) {
			size++;
			temp=temp.next;
		}
		return size;
	}
	
	public LinkNode nth(LinkNode head,int n) {
		if(n<1 || n>lenght(head)) {
			System.out.println("Aranan değer bağlı liste içerisinde bulunmamaktadır.");
			return null;
		}
		int size=1;
		LinkNode current=head;
		if(n==size) {
			return head;
		}else {
			while(size<lenght(head)+1) {
				if(size==n) {
					break;
				}
				current=current.next;
				size++;
			}
			return current;
		}
	}
	public LinkNode removeDublicate(LinkNode head) {
		if(head==null) {
			return null;
		}
		LinkNode current=head;
		LinkNode temp=head;
		while(current!=null) {
			temp=current;
			while(temp!=null && temp.next!=null) {
				if(current.value==temp.next.value)
				{
					temp.next=temp.next.next;
				}
				temp=temp.next;
			}
			current=current.next;
			temp=head;
		}
		return temp;
	}
	//LinkNode static tanımlandığı için bu metot doğru çalışmıyor
	public void removeSortedDublicates() {
		if(head==null) {
			return;
		}
		LinkNode current=head;
		while(current!=null && current.next!=null) {
			if(current.value==current.next.value) {
				current.next=current.next.next;
			}else {
				current=current.next;
			}
		}
	}
	public LinkNode endTth(LinkNode head,int n) {
		if(n<1 || n>lenght(head)) {
			System.out.println("Aranan değer aralıkta bulunmamaktadır.");
			return null;
		}
		int size=1;
		LinkNode current=head;
		LinkNode mainCurrent=head;
		
		while(size<=n) {
			/*
			 * if(current==null){
			 * 	throw new IllegalArgumentException(n+ "sayısı listenin büyüklüğünden daha büyüktür.");
			 * }
			 * 
			 * */
			current=current.next;
			size++;
		}
		while(current!=null) {
			current=current.next;
			mainCurrent=mainCurrent.next;
		}
		return mainCurrent;
	}

	public static void main(String[] args) {
		LinkNode head=new LinkNode(10);
		LinkNode second=new LinkNode(11);
		head.next=second;
		
		LinkedLists2 list=new LinkedLists2();
		head=list.addStart2(head, 15);
		head=list.addStart2(head, 16);
		head=list.addStart2(head, 19);
		head=list.addStart2(head, 15);
		head=list.addStart2(head, 16);
		head=list.addStart2(head, 19);
		list.show(head);
		//head=list.reverse(head);
		//list.show(head);
		head=list.removeDublicate(head);
		System.out.println("*****REMOVE DUBLICATES*****");
		list.show(head);
		/*
		LinkNode mid=list.midNode(head);
		System.out.println("Mid value: "+mid.value);
		LinkNode list2=list.nth(head, 1);
		System.out.println("1.eleman: "+list2.value);
		LinkNode lastTh=list.endTth(head, 5);
		System.out.println("Sondan 2.Eleman: "+lastTh.value);
		*/
		LinkedLists2 liste=new LinkedLists2();
		liste.addStart2(head, 1);
		liste.show(head);
		
	}

}
