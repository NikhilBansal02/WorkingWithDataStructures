//Sum of all nodes of Binary Tree
//Time O(n)
//Space O(n)

package problems;

public class SumOfElementsOfBT {
	
	static Node root;
	static int SUM=0;

	public static void main(String[] args) {
		sumOfAllNodes(root);
		root = new Node(15);
		root.left = new Node(10);
		root.right = new Node(20);
		
		root.left.left = new Node(8);
		root.left.right = new Node(12);
		
		root.right.left = new Node(16);
		root.right.right = new Node(25);
		
		sumOfAllNodes(root);
		if(SUM!=0)
			System.out.println("Sum of all nodes : "+SUM);
		else
			System.out.println("Empty Tree");
	}
	public static void sumOfAllNodes(Node root) {
		
		if(root == null) {
			return;
		}
		sumOfAllNodes(root.left);
		sumOfAllNodes(root.right);
		SUM = SUM + root.data;
		
		
	}

}
