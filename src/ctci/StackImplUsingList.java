/*
 * Stack implementation using linked list.
 * TC - O(1)
 * SC - O(1)
*/
package ctci;

public class StackImplUsingList {
	
	static Node head;

	public static void main(String[] args) {
	
    pop();
    peek();
	isEmpty();
	push(1);
	push(2);
	push(3);
	push(4);
	push(5);
	peek();
	pop();
	peek();
	pop();
    isEmpty();
    peek();
	pop();
    isEmpty();
    peek();
	pop();
    isEmpty();
    peek();
	pop();
    isEmpty();
	
	}

	public static void push(int data) {
		
		Node new_node = new Node(data);
		if(head == null) {
			head = new_node;
			return;
		}
		new_node.next = head ;
		head = new_node;
	}
	public static void peek() {
		
		if(head!=null) {
			System.out.println("Top element is : "+head.data);
		}else {
			System.out.println("Stack Underflow");
		}
		
	}
	
	public static void pop() {
		
		if(head!=null) {
			System.out.println("Popped-up element is : "+head.data);
			head = head.next;
		}else {
			System.out.println("Stack Underflow");
		}
	}
	
	public static void isEmpty() {
		System.out.println("Is Stack Empty : "+ (head==null));
	}
}
