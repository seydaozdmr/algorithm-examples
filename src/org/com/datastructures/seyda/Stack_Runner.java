package org.com.datastructures.seyda;

public class Stack_Runner {

	public static void main(String[] args) {
		Stack nums=new Stack();
		System.out.println(nums.isEmpty());
		nums.push(15);
		nums.push(29);
		nums.show();
		nums.push(88);
		nums.push(219);
		nums.show();
		nums.push(15);
		nums.show();
		nums.push(29);
		nums.show();
		nums.push(88);
		nums.push(219);
		nums.show();
		//Remove last element and show me that.
		System.out.println(nums.pop());
		//Show me last element
		System.out.println(nums.peek());
		
		System.out.println("stack miktarı : "+nums.size());
		System.out.println(nums.isEmpty());
		
		//*************************Dynamic Stack
		DStack nums2=new DStack();
		nums2.push(15);
		nums2.push(29);
		nums2.show();
		nums2.push(88);
		nums2.push(219);
		nums2.show();
		nums2.push(15);
		nums2.show();
		nums2.push(29);
		nums2.show();
		nums2.push(88);
		nums2.push(219);
		nums2.show();
		nums2.push(15);
		nums2.show();
		nums2.push(29);
		nums2.show();
		nums2.push(88);
		nums2.push(219);
		nums2.show();
		nums2.push(88);
		nums2.push(219);
		nums2.push(88);
		nums2.push(219);
		nums2.push(88);
		nums2.push(219);
		nums2.show();
	}

}
