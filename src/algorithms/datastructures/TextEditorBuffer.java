package algorithms.datastructures;
import algorithms.StdOut;
public class TextEditorBuffer<Item> {

	private class Node {
		Item item;
		Node next;
	}
	private int sizeLeft;
	private int sizeRight;
	private Node firstLeftStack;
	private Node firstRightStack;
	//constructure
	public TextEditorBuffer() {
		sizeLeft=0;
		sizeRight=0;
		firstLeftStack=null;
		firstRightStack=null;
	}
	
	public void insert(Item item) {
		//Yığının en başına yeni eleman eklenir.
		Node oldFirstLeft=firstLeftStack;
		firstLeftStack=new Node();
		firstLeftStack.item=item;
		firstLeftStack.next=oldFirstLeft;
		
		sizeLeft++;
	}
	public void insertOnRightStack(Item item) {
		Node oldFirstRight=firstRightStack;
		firstRightStack=new Node();
		firstRightStack.item=item;
		firstRightStack.next=oldFirstRight;
		
		sizeRight++;
	}
	
	public Item get() {
		if(sizeRight==0) {
			return null;
		}
		
		return firstRightStack.item;
	}
	
	public Item delete() {
		if(sizeRight==0) {
			return null;
		}
		
		Item item=firstRightStack.item;
		firstRightStack=firstRightStack.next;
		sizeRight--;
		return item;
	}
	
	public void left(int k) {
		int count=0;
		while(count<k&&sizeLeft>0) {
			Item item=firstLeftStack.item;
			insertOnRightStack(item);
			
			firstLeftStack=firstLeftStack.next;
			sizeLeft--;
			count++;
		}
	}
	
	public void right(int k) {
		int count=0;
		while(count<k &&sizeRight>0) {
			Item item=firstRightStack.item;
			
			insert(item);
			firstRightStack=firstRightStack.next;
			sizeRight--;
			count++;
		}
	}
	
	public int size() {
		return sizeRight+sizeLeft;
		
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		
		stringBuilder.append("Left Stack:");
		//Iterasyonu sağlıyor.
		for(Node current=firstLeftStack;current!=null;current=current.next) {
			stringBuilder.append(current.item).append(" ");
		}
		
		stringBuilder.append("\nRight Stack: ");
        for(Node current = firstRightStack; current != null; current = current.next) {
            stringBuilder.append(current.item).append(" ");
        }
        
        return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		TextEditorBuffer<Character> text=new TextEditorBuffer<>();
		
		StdOut.println("Text insert");
		text.insert('S');
		text.insert('e');
		text.insert('y');
		text.insert('d');
		text.insert('a');
		
		StdOut.println(text);
		StdOut.println("\nTest left");
	    text.left(3);
	    StdOut.println(text);
	    StdOut.println("\n 1 right");
	    text.right(1);
	    StdOut.println(text);
	    
	    StdOut.println("\nTest get");
        StdOut.println(text.get());
        StdOut.println(text.get());
        StdOut.println("Expected:\nTop of the right");
	    
	}

}
