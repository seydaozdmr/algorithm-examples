package org.com.datastructures.seyda;

public class Stack {
	int [] stack=new int[5];//constant size array,,,
	int top=0;  //size
	
	public void push(int data) {
		//if size==5 not push
		if(top==5) {
			System.out.println("Stack dolu! Yeni eleman eklenemiyor.");
		}else {
			stack[top]=data;
			top+=1;
		}	
	}
	
	public void show() {
		for(int n:stack) {
			System.out.println(n);
		}
		System.out.println();
	}
	
	public int pop() {
		int data = 0;
		if(top==0) {
			System.out.println("Stack bitti yeni eleman silinemez");
		}else {
			
			top--;
			data=stack[top];
			stack[top]=0;
			
		}
		return data;
	}
	
	public int peek() {
		int data;
		data=stack[top-1];
		return data;
	}
	public int size() {
		return top;
	}
	public boolean isEmpty() {
		return top<=0;
	}
}
