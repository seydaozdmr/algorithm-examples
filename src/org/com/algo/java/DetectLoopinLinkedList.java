package org.com.algo.java;

import java.util.HashSet;
import java.util.Set;

public class DetectLoopinLinkedList {
	public boolean hasLoop(Node head) {
		if(head==null || head.next==null) {
			return false;
		}
		Node slow=head;
		Node fast=head.next;
		
		while(slow!=fast) {
			if(fast==null || fast.next==null) {
				return false;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		
		return true;
	}
	
	public boolean hasCycle(Node head) {
		Set<Node> nodesVisited=new HashSet<>();
		while(head!=null) {
			if(nodesVisited.contains(head)) {
				return true;
			}else {
				nodesVisited.add(head);
			}
			head=head.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
