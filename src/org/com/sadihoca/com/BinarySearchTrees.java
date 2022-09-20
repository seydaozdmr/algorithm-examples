package org.com.sadihoca.com;
//İkili Ağaç(Binary Trees)
//Özyineli (Recursive) olarak çalışır.
class n{
	int data;
	n sol;
	n sag;
}
class binaryCreate{
	n root=null;
	void ekle(int data) {
		root=ekle(root,data);
	}
	
	public n ekle(n root,int data) {
		n node=new n();
		node.data=data;
		node.sag=null;
		node.sol=null;
		if (root==null) {
			root=node;
			System.out.println(node.data);
			return root;
		}
		if(root.data<data)
			root.sag=ekle(root.sag,data);
		else if(root.data>data)
			root.sol=ekle(root.sol,data);
		
		return root;
	}
	void dolas(n root) {
		if(root==null)
			return;
		dolas(root.sol);
		System.out.println(root.data);
		dolas(root.sag);
	}
	void dolas() {
		dolas(root);
	}
}

public class BinarySearchTrees {
	
	
	public static void main(String[] args) {
		binaryCreate agac=new binaryCreate();
		agac.ekle(10);
		agac.ekle(5);
		agac.ekle(100);
		agac.ekle(6);
		agac.ekle(25);
		agac.ekle(15);
		agac.dolas();
		
	}

}
