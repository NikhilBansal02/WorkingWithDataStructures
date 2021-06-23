package problems;

import java.util.LinkedList;
import java.util.Queue;

public class Tree_Helper {


	public static void printLevelOrdeUsingQueue(Node root) {

		System.out.println("Initializing printing tree in level order using Queue mechanism");

		if(root == null) {
			System.out.println("Empty tree");
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		Node temp;
		while(queue.size()>0) {
			temp = queue.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				queue.add(temp.left);
			}

			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
	}

	public void inorder(Node root) {

		if(root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data +" ");
		inorder(root.right);
	}

}
