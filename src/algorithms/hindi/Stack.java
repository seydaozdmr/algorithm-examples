package algorithms.hindi;

import java.util.EmptyStackException;

public class Stack {
	
	private class ListNode{
		char item;
		ListNode next;
	}
	
	private ListNode top;
	private int size;
	
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public Stack() {
		top=null;
		size=0;
	}
	
	public void push(char data) {
		ListNode temp=new ListNode();
		temp.item=data;
		temp.next=top;
		top=temp;
		size++;
	}
	
	public char pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}else {
			char item=top.item;
			top=top.next;
			size--;
			return item;
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return top.item;
	}
	public void show() {
		if(top==null) {
			System.out.println("liste boş");
		}
		ListNode current=top;
		while(current!=null) {
			System.out.println(current.item);
			current=current.next;
		}
	}

	public static void main(String[] args) {
		Stack yigin=new Stack();
		String name="seyda";
		for(int i=0;i<name.length();i++) {
			System.out.println(name.charAt(i));
			yigin.push(name.charAt(i));
		}
		System.out.println(yigin.size());
		int size=yigin.size();
		for(int i=0;i<size;i++) {
			System.out.println(yigin.pop());
		}
		System.out.println(yigin.size());
		/*
		yigin.show();
		System.out.println(yigin.peek());
		*/
		
		

	}

}
