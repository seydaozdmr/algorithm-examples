package org.com.datastructures.seyda;

public class Queue {
	//Sabit boyutlu kuyruk...
	int queue[]=new int[5];
	int size;
	int front;//ön
	int rear;//arka
	//Adding elements: by enQueue method
	public void enQueue(int data) {
		if(!isFull()) {
			queue[rear]=data;
			rear=(rear+1)%5;
			size++;
		}else
			System.out.println("Queue is full");
	}
	
	public int deQueue() {
		int data=queue[front];
		if(!isEmpty()) {
			front=(front+1)%5;
			size-=1;
		}else
			System.out.println("Queue is Empty!");
		return data;
	}
	
	public void show()
	{
		System.out.println("Elements: ");
		for(int i=0;i<size;i++) {
			System.out.print (queue[(front+i)%5]+" ");
		}
		System.out.println();
		for(int n:queue) {
			System.out.print(n+" ");
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return getSize()==0;
	}
	
	public boolean isFull()
	{
		return getSize()==5;
	}
}
