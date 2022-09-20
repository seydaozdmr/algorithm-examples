package algorithms.hindi;

public class LinkedLists1 {
	/*
	private class ListNode<T>{
		T item;
		ListNode<T> next;
	}
	
	private ListNode<String> head;
	private int size=0;
	*/
	
	private static class ListNode {
		private int item;
		private ListNode next;
		
		public ListNode(int item) {
			this.item=item;
			this.next=null;
		}
	}
	
	//private ListNode head;
	private int size;
	/*
	public boolean isEmpty() {
		return head==null;
	}
	*/
	public int size() {
		return size;
	}
	/*
	public void add(int item) {
		ListNode temp=new ListNode(item);
		temp.next=head;
		head=temp;
	}
	*/
	public ListNode addStart(ListNode head,int item) {
		ListNode temp=new ListNode(item);
		if(head==null) {
			return temp;
		}
		temp.next=head;
		head=temp;
		return head;
	}
	
	public ListNode addLast(ListNode head,int item) {
		ListNode temp=new ListNode(item);
		if(head==null) {
			return temp;
		}
		ListNode current=head;
		while(current.next!=null) {
			current=current.next;
		}
		current.next=temp;
		return head;
	}
	
	public int lenght(ListNode head) {
		int size=0;
		if(head==null) {
			return -1;
		}
		ListNode temp=head;
		while(temp!=null) {
			size++;
			temp=temp.next;
		}
		return size;
	}
	
	public ListNode addPosition(ListNode head,int item,int position) {
		int lenght=lenght(head);
		if(position>lenght+1 || position<1) {
			System.out.println("pozisyon uygun değil");
			return head;
		}
		ListNode newNode=new ListNode(item);
		if(position==1) {
			newNode.next=head;
			return newNode;
		}else {
			ListNode temp=head;
			int count=1;
			while(count<position-1) {
				temp=temp.next;
				count++;
			}
			ListNode current=temp.next;
			newNode.next=current;
			temp.next=newNode;
			return head;
		}	
	}
	
	public boolean search(ListNode head,int key) {
		if(head==null) {
			return false;
		}
		ListNode current=head;
		while(current!=null) {
			if(current.item==key) {
				return true;
			}
			current=current.next;
		}
		return false;
	}
	
	public void insertAfter(ListNode prev,int item) {
		if(prev==null) {
			return;
		}
		ListNode temp=new ListNode(item);
		temp.next=prev.next;
		prev.next=temp;
		
	}
	public ListNode deleteFirst(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode temp=head;
		head=head.next;
		temp.next=null;
		return head;
	}
	
	public ListNode deleteLastNode(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode current=head;
		while(current.next.next!=null) {
			current=current.next;
		}
		current.next=null;
		return head;
		
	}
	
	public ListNode deletePosition(ListNode head,int position) {
		int length=lenght(head);
		if(position>length || position<1) {
			System.out.println("invalid position");
			return head;
		}
		if(position==1) {
			head=head.next;
			return head;
		}
		int count=1;
		ListNode current=head;
		while(current!=null) {
			if(count==position-1) {
				break;
			}
			count++;
			current=current.next;
		}
		ListNode temp=current.next;
		current.next=temp.next;
		temp.next=null;
		
		return head;
	}
	
	public ListNode deleteLastNode2(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode current=head;
		ListNode temp=null;
		while(current.next!=null) {
			temp=current;
			current=current.next;
		}
		temp.next=null;
		return head;
	}
	
	public void show(ListNode head){
		if(head==null) {
			return;
		}
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}
	/*
	public void show(){
		if(head==null) {
			return;
		}
		ListNode current=head;
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}
	*/
	public int sizeLinkedList(ListNode head) {
		ListNode current=head;
		int count=0;
		while(current!=null) {
			count++;
			current=current.next;
		}
		return count;
	}
	
	
	
	

	public static void main(String[] args) {
		ListNode head=new ListNode(19);
		ListNode second=new ListNode(1);
		ListNode third=new ListNode(9);
		ListNode fourth=new ListNode(119);
		
		head.next=second;
		second.next=third;
		third.next=fourth;
		
		LinkedLists1 liste=new LinkedLists1();
		liste.show(head);
		System.out.println("*******");
		ListNode newHead=liste.addStart(head, 222);
		ListNode newHead2=liste.addLast(head, 25);
		liste.insertAfter(second, 111);
		System.out.println("*******");
		liste.show(newHead2);
		head=liste.addPosition(head, 13, 7);
		System.out.println("*******");
		liste.show(head);
		System.out.println(liste.search(newHead, 13));
		head=liste.deleteFirst(head);
		System.out.println("*******");
		liste.show(head);
		head=liste.deleteLastNode(head);
		System.out.println("delete last");
		liste.show(head);
		head=liste.deletePosition(head, 1);
		System.out.println("delete 1");
		liste.show(head);
		//System.out.println(liste.sizeLinkedList(head));
		
		
		/*
		LinkedLists1 liste2=new LinkedLists1();
		liste2.add(5);
		liste2.add(6);
		liste2.add(7);
		liste2.add(8);
		
		liste2.show();
		*/
	}

}
