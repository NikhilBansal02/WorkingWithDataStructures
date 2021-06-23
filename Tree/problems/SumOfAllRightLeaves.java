package problems;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfAllRightLeaves {
	
	static Node root;
	static int SUM=0;
	static Queue<Node> left = new LinkedList<Node>();
	static Queue<Node> right = new LinkedList<Node>();
	
	public static void main(String[] args) {
		
		root = new Node(9);
		root.left = new Node(8);
		//root.right = new Node(6);
		
		root.left.left = new Node(5);
		//root.left.right = new Node(2);
		
		//root.right.left = new Node(1);
		//root.right.right = new Node(3);
		
		sumOfLeftleaves(root);
		System.out.println("Sum of Right Leaves : "+SUM);
		
	}

	public static void sumOfLeftleaves(Node root) {
		
		if(root == null) {
			System.out.println("Empty Tree...!!!!");
			return;
		}
		
		if(root.left!=null)
			left.add(root.left);
		if(root.right!=null)
			right.add(root.right);
		
		Node temp;
		
		while(left.size()>0 || right.size()>0){
			
			while(left.size()>0) {
				temp = left.poll();
				if(isLeaf(temp)) {
					SUM =SUM + 0;
				}else {
					addToQueues(temp);
				}
			}
			
			while(right.size()>0) {
				temp = right.poll();
				if(isLeaf(temp)) {
					SUM =SUM + temp.data;
				}else {
					addToQueues(temp);
				}
			}
		}
	}
	
	public static boolean isLeaf(Node root) {
		
		return (root.left == null && root.right == null);
		
	}
	
	public static void addToQueues(Node temp) {
		
		if(temp.left!=null) {
			left.add(temp.left);
		}
		if(temp.right!=null) {
			right.add(temp.right);
		}
	}

}
