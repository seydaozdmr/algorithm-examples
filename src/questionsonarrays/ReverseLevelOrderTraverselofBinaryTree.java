package questionsonarrays;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



public class ReverseLevelOrderTraverselofBinaryTree {
	
	public static class TreeNode {
		 
        int data;
        TreeNode left;
        TreeNode right;
 
        TreeNode(int data) {
           this.data = data;
        }
    }
	
	//Bir BinaryTree'yi tersine çevirme
	
	public static void reverse(TreeNode node) {
		//Öncelikle elemanları sıraya alıyoruz.
		Stack<Integer> st=new Stack<>();
		Queue<TreeNode> queue=new LinkedList<>();
		//verilen binarytree'nin node elemanını kuyruğa alıyoruz.
		queue.add(node);
		//kuyruk boş olana kadar
		while(!queue.isEmpty()) {
			//sıradaki elemanı çıkarıyoruz.
			TreeNode nodeData=queue.poll();
			//kuytuktan çıkan elemanın integer tipinde değerini yığına ekliyoruz.
			st.add(nodeData.data);
			
			if(nodeData.right!=null) {
				queue.add(nodeData.right);
			}
			
			if(nodeData.left!=null) {
				queue.add(nodeData.left);
			}
		}
		
		//yığını döngü ile boşalt böylece elemanları tersine çevirmiş oluyoruz.
		while(!st.isEmpty()) {
			System.out.println(st.pop());
		}
		
	}

	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(7);
		 
		rootNode.left = new TreeNode(6);
		rootNode.right = new TreeNode(5);

		rootNode.left.left = new TreeNode(4);
		rootNode.left.right = new TreeNode(3);

		rootNode.right.left = new TreeNode(2);
		rootNode.right.right = new TreeNode(1);
	    
		reverse(rootNode);
	}

}
