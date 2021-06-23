package problems;

import java.util.LinkedList;
import java.util.Queue;

public class Continuous_Tree {
	
	Node root;
	
	
	public boolean isContinuous(Node root) {
		
		if(root == null) {
			System.out.println("Tree is Empty...!!!!");
			return false;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		Node temp;
		while(q.size()>0) {
			temp = q.poll();
			
			if(temp.left!=null) {
				if(Math.abs(temp.data - temp.left.data) ==1) {
					q.add(temp.left);
				}else {
					return false;
				}
			}
			if(temp.right!=null) {
				if(Math.abs(temp.data - temp.right.data) ==1) {
					q.add(temp.right);
				}else {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		
		Continuous_Tree ct = new Continuous_Tree();
		ct.root = new Node(3);
		ct.root.left = new Node(2);
		ct.root.right = new Node(4);
		
		ct.root.left.left = new Node(1);
		ct.root.left.right = new Node(3);
		ct.root.right.right = new Node(5);
		
		System.out.println(ct.isContinuous(ct.root) == true ? "Continuous" : "Not Continuous");

	}

}
