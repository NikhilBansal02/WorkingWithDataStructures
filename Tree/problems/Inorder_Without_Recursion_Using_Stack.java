package problems;

import java.util.Stack;

public class Inorder_Without_Recursion_Using_Stack {
	
	static Node root;

	public static void main(String[] args) {
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.left.right.left.right = new Node(7);
		
		traverse_Inorder(root);
	}

	public static void traverse_Inorder(Node root) {
		
		if(root == null) {
			System.out.println("Empty Tree....!!!");
			return;
		}
		
		Stack<Node> s = new Stack<Node>();
		//s.add(root);
		Node current = root;
		Node top;
		
		while(current!=null) {
			
			while(current!=null) {
				s.add(current);
				current = current.left;
				
			}
			
			while(current == null && s.size() > 0) {
				top = s.pop();
				System.out.print(top.data +" ");
				current = top.right;
			}
				
		}
	}
}
