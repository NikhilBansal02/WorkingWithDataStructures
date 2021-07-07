/*
 * Design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * 
 * Solution
 * The thing with minimums is that they don't change very often. They only change when a smaller element is added.
 * One solution is to have just a single int value, minValue, that's a member of the Stack class. When
 * minValue is popped from the stack, we search through the stack to find the new minimum. Unfortunately,
 * this would break the constraint that push and pop operate in 0( 1) time.
 * To further understand this question, let's walk through it with a short example:
 * push(5); // stack is {5}, min is 5
 * push(6); // stack is {6, 5}, min is 5
 * push(3); // stack is {3, 6, 5}, min is 3
 * push(7); // stack is {7, 3, 6, 5}, min is 3
 * pop(); // pops 7. stack is {3, 6, 5}, min is 3
 * pop(); // pops 3. stack is {6, 5}. min is 5.
 * Observe how once the stack goes back to a prior state ( { 6, 5} ), the minimum also goes back to its prior
 * state (5). This leads us to our second solution.
 * If we kept track of the minimum at each state, we would be able to easily know the minimum. We can do
 * this by having each node record what the minimum beneath itself is. Then, to find the min, you just look at
 * what the top element thinks is the min.
 * TC - O(1)
 * SC - O(1)
 */

package ctci;

import java.util.Stack;

class NodeWithMin{
	
	int item;
	int min;
	
	public NodeWithMin(int item, int min) {
		this.item = item;
		this.min = min;
	}
}

public class StackWithMin extends Stack<NodeWithMin> {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		StackWithMin stack = new StackWithMin();
		stack.push(5);// min - 5
		stack.push(2);//min - 2
		stack.push(4);//min - 2
		stack.push(1);//min -1
		
		System.out.println("Min is : "+ stack.min());
		System.out.println("Popped out element is : "+stack.pop().item);
		System.out.println("Min is : "+ stack.min());
		System.out.println("Popped out element is : "+stack.pop().item);
		System.out.println("Min is : "+ stack.min());
		System.out.println("Popped out element is : "+stack.pop().item);
		System.out.println("Min is : "+ stack.min());
		
	}
	
	public void push(int item) {
		int minItem = Math.min(item,this.min());
		super.push(new NodeWithMin(item, minItem));
	}

	public int min() {
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		}else {
			return peek().min;
		}
	}
}
