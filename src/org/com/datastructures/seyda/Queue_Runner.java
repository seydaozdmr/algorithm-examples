package org.com.datastructures.seyda;

public class Queue_Runner {

	public static void main(String[] args) {
		Queue q=new Queue();
		q.enQueue(5);//0
		q.enQueue(100);//1
		q.enQueue(7);//2
		q.enQueue(1);//3
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		q.enQueue(67);//4
		q.enQueue(12);//0 Bu noktada çarşı karışıyor.
		q.enQueue(125);//1
		q.enQueue(125);
		q.enQueue(125);
		q.enQueue(125);
		q.show();

	}

}
