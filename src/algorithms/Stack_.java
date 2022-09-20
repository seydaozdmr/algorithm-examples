package algorithms;

import java.util.Arrays;

public class Stack_ {
	
	private String [] stackArray;
	private int size; //means stack size
	
	private int topOfStack=-1; //top of the stack
	
	public Stack_(int size) {
		this.size=size;
		stackArray=new String[size];
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String input) {
		if(topOfStack+1<size) {
			topOfStack++;
			stackArray[topOfStack]=input;
		}else {
			System.out.println("Yığın dolu."); //stack is full
		}
		
		displayTheStack();
		System.out.println("PUSH "+input+" eklendi.");
	}
	
	public void pushMany(String cokluListe) {
		String[] liste=cokluListe.split(" ");
		for(int i=0;i<liste.length;i++) {
			push(liste[i]);
		}
	}
	
	public String pop() {
		if(topOfStack>=0) {
			displayTheStack();
			System.out.println("POP "+stackArray[topOfStack]+" silinmiştir.");
			stackArray[topOfStack]="-1";
			return stackArray[topOfStack--];
		}else {
			displayTheStack();
			System.out.println("Yığın boş.");
			return "-1";
		}
	}
	public void popAll() {
		for (int i=topOfStack;i>=0;i--) {
			pop();
		}
	}
	
	public String peek() {
		return stackArray[topOfStack];
	}
	
	

	private void displayTheStack() {
		for(int i=0;i<61;i++) {
			System.out.print("-");
		}
		System.out.println();
		for(int n=0;n<size;n++) {
			System.out.format("| %2s "+" ", n);
		}
		System.out.println("|");
		for(int n=0;n<61;n++) {
			System.out.print("-");
		}
		System.out.println();
		
		for(int n=0;n<size;n++) {
			if(stackArray[n].equals("-1")) System.out.print("|     ");
			else System.out.print(String.format("| %2s "+" ",stackArray[n]));
		}
		System.out.println("|");
		for(int n=0;n<61;n++) System.out.print("-");
		System.out.println();
	}

	public static void main(String[] args) {
		Stack_ stack=new Stack_(10);
		stack.push("5");
		stack.push("20");
		stack.push("5");
		stack.pushMany("11 12 13 15");
		stack.popAll();
		stack.displayTheStack();

	}

}
