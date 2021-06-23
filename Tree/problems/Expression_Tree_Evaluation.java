package problems;

import java.util.Stack;

public class Expression_Tree_Evaluation {
	
	static TNode_String root;
	static Stack<TNode_String> stack = new Stack<TNode_String>();
	static boolean Invalid_Tree_Flag=false;
	
	public static void main(String[] args) {
		
//		Empty Tree
//		evaluate(root);
		
		//Tree with only operators on both child
//		root = new TNode_String("+");
//		root.left = new TNode_String("*");
//		root.right = new TNode_String("-");
//		evaluate(root);
		
		//Tree with only operators on left child
//		root = new TNode_String("+");
//		root.left = new TNode_String("*");
//		evaluate(root);
		
		//Tree with only operators on right child
//		root = new TNode_String("+");
//		root.right = new TNode_String("*");
//		evaluate(root);
		
		//Tree with only operator on one child and operand on another
//		root = new TNode_String("+");
//		root.left = new TNode_String("5");
//		root.right = new TNode_String("-");
//		evaluate(root);
		
		//Tree with with only root and its child as operands
//		root = new TNode_String("+");
//		root.left = new TNode_String("5");
//		root.right = new TNode_String("10");
//		evaluate(root);
		
		//Invalid Scenario
//		root = new TNode_String("+");
//		root.left = new TNode_String("-");
//		root.right = new TNode_String("+");
//		root.right.left = new TNode_String("10");
//		root.right.right = new TNode_String("20");
//		evaluate(root);
		
		//Invalid Scenario
//		root = new TNode_String("+");
//		root.right = new TNode_String("+");
//		root.right.left = new TNode_String("10");
//		root.right.right = new TNode_String("20");
//		evaluate(root);
		
		//Positive Scenario
		root = new TNode_String("+");
		root.left = new TNode_String("*");
		root.right = new TNode_String("-");
		
		root.left.left = new TNode_String("5");
		root.left.right = new TNode_String("4");
		root.right.left = new TNode_String("100");
		root.right.right = new TNode_String("/");
		root.right.right.left = new TNode_String("20");
		root.right.right.right = new TNode_String("2");
		
		evaluate(root);
		if(stack.size() ==1 && !Invalid_Tree_Flag) {
			System.out.println("Result : "+stack.pop().data);
		}else {
			System.out.println("Invalid Tree and Expression...!!!!");
		}
		
	}

	private static void evaluate(TNode_String root) {
		
		if(root == null) {
			System.out.println("Tree Is Empty");
			return;
		}
		readPostOrderAndEval(root);
		
	}

	private static void readPostOrderAndEval(TNode_String root) {
		
		if(root == null) {
			return;
		}
		readPostOrderAndEval(root.left);
		readPostOrderAndEval(root.right);
		populateStack(root);
		
	}

	private static void populateStack(TNode_String root) {
		
		int ldata, rdata;
		String node_data = root.data;
		if(node_data =="+" || node_data =="-" || node_data =="*" || node_data =="/") {
			
			if(stack.size() == 0 || stack.size() == 1) {
				Invalid_Tree_Flag = true;
				return;
			}
			rdata = Integer.parseInt(stack.pop().data);
			ldata = Integer.parseInt(stack.pop().data);
			int temp=0;
			switch(node_data) {
				case "+":{
					temp = ldata+rdata;
					break;
				}
				case "-":{
					temp = ldata-rdata;
					break;
				}
				case "*":{
					temp = ldata*rdata;
					break;
				}
				case "/":{
					temp = ldata/rdata;
					break;
				}
			}
			stack.push(new TNode_String(temp+""));
			
		}else {
			stack.add(root);
		}
	}

}
