package problems;

import java.util.Stack;

public class Postfix_To_Infix {

	public static void main(String[] args) {
		String postfix = "ab+ef*g*-";
		TNode root = convertToInfix(postfix);
		if(root!=null) {
			printInorder(root);
		}
	}

	private static void printInorder(TNode root) {
		
		if(root == null) {
			return;
		}
		
		printInorder(root.left);
		System.out.print(root.data+" ");
		printInorder(root.right);
		
	}


	public static TNode convertToInfix(String postfixNotation) {

		if(postfixNotation == "" || postfixNotation == null) {
			System.out.println("Empty String");
			return null;
		}

		Stack<TNode> stack = new Stack<TNode>();
		char[] ch = postfixNotation.toCharArray();

		TNode left;
		TNode right;
		TNode t;

		for(char c : ch) {
			if(c=='+' || c=='-' || c=='*' || c=='/') {
				right = stack.pop();
				left  = stack.pop();
				 t= new TNode(c);
				t.right = right;
				t.left  = left;

				stack.push(t);

			}else {
				t = new TNode(c);
				stack.push(t);
			}
		}
		return stack.pop();
	}

}
