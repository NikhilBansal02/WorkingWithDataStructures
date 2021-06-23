//Given a binary tree and a key, insert the key into the binary tree at the first position available in level order.
//Space Complexity - O(n)
//Time Complexity  - O(n)

package problems;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal_Using_Queue {
	
	Node root;

	public static void main(String[] args) {
		
		BFS_Traversal_Using_Queue bfs = new BFS_Traversal_Using_Queue();
		int key = 12;
		
		bfs.printLevelOrdeUsingQueue(bfs.root);
		
		bfs.root = new Node(10);
		bfs.root.left = new Node(11);
		bfs.root.right = new Node(9);
		
		bfs.root.left.left = new Node(7);
		bfs.root.right.left = new Node(15);
		bfs.root.right.right = new Node(8);
		
		bfs.printLevelOrdeUsingQueue(bfs.root);
		System.out.println();
		
		bfs.insert(bfs.root,key);
		
		bfs.printLevelOrdeUsingQueue(bfs.root);
		System.out.println();
		
		bfs.insert(bfs.root,1);
		
		bfs.printLevelOrdeUsingQueue(bfs.root);
		System.out.println();
		
	}
	
	public void insert(Node root, int key) {
		if (root == null) {
			this.root = new Node(key);
			return;
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		Node temp;
		
		while(queue.size()>0) {
			temp = queue.poll();
			
			if(temp.left!=null) {
				queue.add(temp.left);
			}else {
				temp.left = new Node(key);
				break;
			}
			
			if(temp.right!=null) {
				queue.add(temp.right);
			}else {
				temp.right = new Node(key);
				break;
			}
		}
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
