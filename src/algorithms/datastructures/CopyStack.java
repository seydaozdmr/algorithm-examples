package algorithms.datastructures;
import java.util.StringJoiner;

import algorithms.Stack;
import algorithms.StdOut;
public class CopyStack<Item> extends Stack<Item>  {
	
	public CopyStack(Stack<Item> stack) {
		Stack<Item> temp=new Stack<>();
		for(Item item:stack) {
			temp.push(item);
		}
		//temp'de toplanan elemanlar Stack a pushlanıyor
		for(Item item:temp) {
			push(item);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> originalStack=new Stack<>();
		originalStack.push(1);
		originalStack.push(2);
		originalStack.push(3);
		originalStack.push(4);
		
		CopyStack<Integer> copyStack=new CopyStack<>(originalStack); //CopyStack sınıfının constructure metoduna argüman olarak Stack tipinde bir nesne veriyorum
		
		copyStack.push(5);
		copyStack.push(6);
		
		StringJoiner originalStackItem=new StringJoiner(" ");
		for(int item:originalStack) { //Autoboxing Integer->int
			originalStackItem.add(String.valueOf(item));
		}
		StdOut.println("Original Stack: " + originalStackItem.toString());
		
		StringJoiner copyStackItems=new StringJoiner(" ");
		for(int item:copyStack) {
			copyStackItems.add(String.valueOf(item));
			
		}
		StdOut.println("Copy Stack Items: "+copyStackItems.toString());
		
		

	}

}
