package org.com.algo.java;

import java.util.HashSet;
import java.util.Set;

class Nod2{
	public int data;
	public Nod2 next;
	
	public Nod2(int data) {
		this.data = data;
		this.next = null;
	}
	
	
}
public class FindIntersecitonTwoLinkedLists {
	
	public static Nod2 findIntersectionUsingSet(Nod2 nodeA,Nod2 nodeB) {
		if(nodeA==null || nodeB==null) {
			return null;
		}
		
		Set<Nod2> nodeSet=new HashSet<>();
		
		Nod2 tempA=nodeA;
		while(tempA!=null) {
			nodeSet.add(tempA);
			tempA=tempA.next;
		}
		
		Nod2 tempB=nodeB;
		while(tempB!=null) {
			if(nodeSet.contains(tempB)) {
				return tempB;
			}
			tempB=tempB.next;
		}
		
		return null;
	}
	public static void main(String[] args) {
		Nod2 node=new Nod2(5);
		Nod2 node2=new Nod2(5);
		
		Nod2 node3=findIntersectionUsingSet(node, node2);
		System.out.println(node3.data);
		
		
	}
}
