package org.com.algo.java;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	
	//Implementing queue using two Stacks 
	
	Stack<Integer> st1=new Stack<>();
	Stack<Integer> st2=new Stack<>();
	//adding elements
	public void enqueue(int val) {
		st1.push(val);
	}
	//deleting elements
	public void dequeue() {
		//if st2 is Empty? then carry all of elements st1 to st2
		if(st2.isEmpty()) {
			if(st1.isEmpty()) {
				System.out.println("Elemena silinemez. Kuyruk boş.");
			}else {
				while(!st1.isEmpty()) {
					st2.push(st1.pop());
				}
				
			}
		}
		//delete element from st2
		System.out.println("silinen eleman: "+st2.pop());
	}
	

	public static void main(String[] args) {
		ImplementQueueUsingStacks test=new ImplementQueueUsingStacks();
		test.enqueue(5);
		test.enqueue(2);
		test.enqueue(7);
		test.dequeue();
		test.enqueue(1);
		test.enqueue(7);
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();
		test.dequeue();

	}

}
