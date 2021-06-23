package problems;

import java.util.LinkedList;
import java.util.Queue;

public class Deletion_In_BT {
	
	Node root;

	public static void main(String[] args) {
		
		Deletion_In_BT bfs = new Deletion_In_BT();
		
		bfs.root = new Node(10);
		System.out.println("Before");
		bfs.inorder(bfs.root);
		System.out.println();
		
		bfs.delete(bfs.root, 12);
//		bfs.root.left = new Node(11);
//		bfs.root.right = new Node(9);
//		
//		bfs.root.left.left = new Node(7);
//		bfs.root.left.right = new Node(12);
//		
//		bfs.root.right.left = new Node(15);
//		bfs.root.right.right = new Node(8);
		
//		bfs.delete(bfs.root, 800);
		System.out.println("After");
		bfs.inorder(bfs.root);
//		System.out.println();
	}
	public void delete(Node root,int key) {
		
		if(root == null) {
			System.out.println("Tree is empty. Deletion cannot happen");
			return;
		}
		
		if(root.left == null && root.right == null) {
			if(root.data == key) {
				this.root = null;
				return;
			}else {
				System.out.println("key is not present in tree");
				return;
			}
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		Node temp = null;
		Node Node_To_Be_deleted = null;
		
		while(queue.size()>0) {
			
			temp = queue.poll();
			if(temp.data == key) {
				Node_To_Be_deleted = temp; 
			}
			
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			
			if(temp.right!=null) {
				queue.add(temp.right);
			}
		}
		
		if(Node_To_Be_deleted == null) {
			System.out.println(key+" is not present in tree. Deletion cannot happen..!!");
			return;
		}else {
			int x = temp.data;
			deleteDeepest(root,temp);
			Node_To_Be_deleted.data = x;
		}
		
	}

	public void deleteDeepest(Node root, Node deleteNode) {
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		Node temp;
		
		while(queue.size()>0) {
			temp = queue.poll();
			
			if(temp.left!=null) {
				if(temp.left == deleteNode) {
					temp.left = null;
					return;
				}
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				if(temp.right == deleteNode) {
					temp.right = null;
					return;
				}
				queue.add(temp.right);
			}
		}
	}
	
	public void inorder(Node temp)
	{
	    if (temp == null)
	        return;
	 
	    inorder(temp.left);
	    System.out.print(temp.data + " ");
	    inorder(temp.right);
	}

}
