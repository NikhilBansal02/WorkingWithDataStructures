/*
 * Stack Implementation using array
 * TC - O(1)
 * SC - O(1)
 */

package ctci;

public class StackImpleUsingArray {
	
	int size =0;
	int arr[];
	static int TOP = -1;
	int Max_Size=0;
	
	StackImpleUsingArray(int size){
		this.Max_Size = size;
		arr = new int[Max_Size];
	}

	public static void main(String[] args) {
		
		StackImpleUsingArray stack = new StackImpleUsingArray(3);
		stack.isEmpty();
		stack.push(0);
		stack.peek();
		stack.push(1);
		stack.peek();
		stack.push(2);
		stack.peek();
		stack.peek();
		
		stack.push(3);
		stack.isEmpty();
		stack.pop();
		stack.pop();
		stack.isEmpty();
		stack.pop();
		stack.pop();
		stack.isEmpty();
		
	}
	
	public void push(int item) {
		
		if(size < Max_Size) {
			arr[++TOP] = item;
			size++;
			System.out.println("Elemnt Pushed : "+arr[TOP]);
			System.out.println("Size of Stack : "+size);
		}else {
			System.out.println("Stack Overflow");
		}
		
	}
	
	public void pop() {
		
		if(TOP!= -1 ) {
			System.out.println("Element popped out is : "+arr[TOP--]);//2-1-0- -1
			size--;//3-2-1-0
			System.out.println("Size of Stack : "+size);
		}else {
			System.out.println("Stack underflow");
		}
		
	}
	
	public void peek() {
		
		if(TOP!= -1 ) {
			System.out.println("Top element is : "+arr[TOP]);//2-1-0- -1
		}else {
			System.out.println("Stack underflow");
		}
		
	}
	
	public void isEmpty() {
		System.out.println(TOP == -1);
	}

}
