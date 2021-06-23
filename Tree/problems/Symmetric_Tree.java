//Time Complexity: O(N)
//Auxiliary Space: O(h) where h is the maximum height of the tree 

package problems;

public class Symmetric_Tree {
	
	Node root;

	public static void main(String[] args) {
		
		Symmetric_Tree st  = new Symmetric_Tree();
		
		st.root = new Node(1);
		
		st.root.left = new Node(2);
		st.root.right = new Node(2);
		
		st.root.left.left = new Node(3);
		st.root.left.right = new Node(4);
		
		st.root.right.left = new Node(4);
		st.root.right.right = new Node(3);
		
		st.root.left.left.left = new Node(5);
		st.root.left.left.right = new Node(6);
		
		st.root.right.right.left = new Node(6);
		st.root.right.right.right = new Node(5);
		
		Tree_Helper.printLevelOrdeUsingQueue(st.root);
		System.out.println();
		
		if(st.isSymmetric()) {
			System.out.println("Symmetric");
		}else {
			System.out.println("Non-Symmetric");
		}
		
	}
	
	public boolean isSymmetric() {
		return isMirror(root,root);
	}

	private boolean isMirror(Node root1, Node root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if((root1 != null && root2 != null) 
			&& (root1.data == root2.data)) {
			return (isMirror(root1.left, root2.right));// && isMirror(root1.right, root2.left));
		}
		return false;
	}
}
