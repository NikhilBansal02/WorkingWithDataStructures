package problems;

public class DFS_Traversal {
	
	Node root;
	
	public void inorder(Node root) {
		
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data +" ");
		inorder(root.right);
	}
	
	public void preorder(Node root) {
		
		if(root == null) {
			return;
		}
		System.out.print(root.data +" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	
	public void postorder(Node root) {
		
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data +" ");
	}

	public static void main(String[] args) {
		
		DFS_Traversal dfs = new DFS_Traversal();
		
		dfs.root = new Node(1);
		dfs.root.left = new Node(2);
		dfs.root.right = new Node(3);
		
		dfs.root.left.left = new Node(4);
		dfs.root.left.right = new Node(5);
		
		System.out.println("Printing Inorder way......!!!!");
		dfs.inorder(dfs.root);
		System.out.println();
		System.out.println("Printing Preorder way.....!!!!");
		dfs.preorder(dfs.root);
		System.out.println();
		System.out.println("Printing Postorder way....!!!!");
		dfs.postorder(dfs.root);
	}

}
