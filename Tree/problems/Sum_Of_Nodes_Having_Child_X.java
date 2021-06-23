//Given a binary tree containing n nodes. 
//The problem is to find the sum of all the parent node’s which have a child node with value x.
//Time - O(n)
package problems;

import java.util.LinkedList;
import java.util.Queue;

public class Sum_Of_Nodes_Having_Child_X {
	
	static Node root;
	static int SUM=0;

	public static void main(String[] args) {

		root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);

		root.left.left = new Node(7);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		
		sumOfNodesHavingSpecificChild(root, 2);
		System.out.println("Sum is :" +SUM);
	}

	public static void sumOfNodesHavingSpecificChild(Node root, int item) {

		if(root == null) {
			System.out.println("Empty tree");
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		Node temp;
		while(queue.size()>0) {
			temp = queue.poll();
			if(temp.left!=null) {
				queue.add(temp.left);
				if(temp.left.data == item) {
					SUM = SUM + temp.data;
				}
			}

			if(temp.right!=null) {
				queue.add(temp.right);
				if(temp.right.data == item) {
					SUM = SUM + temp.data;
				}
			}
		}
	}

}
