//Given a Binary Tree, print the nodes level-wise, each level on a new line.
package problems;

import java.util.LinkedList;
import java.util.Queue;

public class BFT_LineByLine {
	
	static Node root;

	public static void main(String[] args) {
		
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		printBFTLineByLine(root);
	}

	public static void printBFTLineByLine(Node root) {
		
		if(root == null) {
			System.out.println("Empty Tree...!!!");
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		Node temp;
		int size = 0;
		
		while(!q.isEmpty()) {
			
			size = q.size();
			
			while(size > 0) {
				
				temp = q.poll();
				System.out.print(temp.data+" ");
				if(temp.left!=null) {
					q.add(temp.left);
				}
				if(temp.right!=null) {
					q.add(temp.right);
				}
				size--;
			}
			System.out.println();
		}
	}

}
