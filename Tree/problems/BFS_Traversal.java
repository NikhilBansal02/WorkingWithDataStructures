package problems;

public class BFS_Traversal {
	
	Node root;
	
	public void printLevelOrder(Node root) {
		
		if(root == null) {
			System.out.println("Empty tree");
			return;
		}
		//get the height of tree
		int h = HeightOfBinaryTree.height(root);
		
		for(int d=1; d<=h;d++) {
			printCurrentLevel(root,d);
		}
		
	}

	public void printCurrentLevel(Node root, int d) {
		
		if(root == null) {
			return ;
		}
		if(d == 1) {
			System.out.print(root.data +" ");
		}else if(d>1) {
			printCurrentLevel(root.left,d-1);
			printCurrentLevel(root.right,d-1);
		}
		
	}

	public static void main(String[] args) {
		
		BFS_Traversal bfs = new BFS_Traversal();
		
		bfs.printLevelOrder(bfs.root);
		
		bfs.root = new Node(1);
		bfs.root.left = new Node(2);
		bfs.root.right = new Node(3);
		
		bfs.root.left.left = new Node(4);
		bfs.root.left.right = new Node(5);
		bfs.printLevelOrder(bfs.root);
	}

}
