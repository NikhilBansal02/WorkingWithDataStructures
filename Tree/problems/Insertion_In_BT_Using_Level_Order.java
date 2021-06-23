package problems;

import java.util.LinkedList;
import java.util.Queue;

public class Insertion_In_BT_Using_Level_Order {
	
	Node root;

	public static void main(String[] args) {
		
		Insertion_In_BT_Using_Level_Order bfs = new Insertion_In_BT_Using_Level_Order();
		
		bfs.printLevelOrdeUsingQueue(bfs.root);
		
		bfs.root = new Node(1);
		bfs.root.left = new Node(2);
		bfs.root.right = new Node(3);
		
		bfs.root.left.left = new Node(4);
		bfs.root.left.right = new Node(5);
		bfs.printLevelOrdeUsingQueue(bfs.root);
	}

	public void printLevelOrdeUsingQueue(Node root) {
		
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

}
