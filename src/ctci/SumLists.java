package ctci;
/*Sum Lists: You have two numbers represented by a linked list, where each node contains a single
digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
function that adds the two numbers and returns the sum as a linked list.
EXAMPLE
Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
Output: 2 -> 1 -> 9. That is, 912.
FOLLOW UP
Suppose the digits are stored in forward order. Repeat the above problem.
EXAMPLE
lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
Output: 9 - > 1 -> 2. That is, 912.

For question, where numbers are stored in forward order. Below approach can be used -
1). Reverse each number by reading each list node by node and adding each digit using add before method.
	Hence, 6,1,7 becomes, 7,1,6 and same for second number.
2). Add the number using same approach as below and add to result using addBefore Method which will save the number in forward way.
*/


/**
 * @author Nikhil Bansal
 * TC - O(N^2)
 *
 */
public class SumLists{

	static Node head1;
	static Node head2;

	static Node result;
	static int sum  =0; 
	static int carry =0;	

	public static void main(String args[]){

		System.out.println("Adding data to First list");
		head1 = append(head1,7);
		head1 = append(head1,1);
		head1 = append(head1,8);
		head1 = append(head1,9);
		printList(head1);
				
		System.out.println("Adding data to Second list");
		head2 = append(head2,5);
		head2 = append(head2,9);
		head2 = append(head2,2);
		printList(head2);

		sumOfList(head1,head2);
		System.out.println("Sjum of lists :");
		printList(result);

	}

	public static Node append(Node head, int data){

		Node new_node = new Node(data);

		if(head == null){
			head = new_node;
			return head;
		}	

		Node temp = head;
		while(temp.next!=null){

			temp = temp.next;
		}
		temp.next = new_node;
		return head;
	}



	public static void sumOfList(Node head1, Node head2){

		Node temp1 = head1;
		Node temp2 = head2;

		while(temp1!=null && temp2!=null){

			sum = temp1.data + temp2.data + carry;
			addNodeToResult(sum);
			temp1 = temp1.next;
			temp2 = temp2.next;

		}

		while(temp1!=null){

			sum = temp1.data+carry;	
			addNodeToResult(sum);
			temp1 = temp1.next;
		}

		while(temp2!=null){

			sum = temp2.data+carry;	
			addNodeToResult(sum);
			temp2 = temp2.next;
		}
		if(carry!=0) {
			addNodeToResult(carry);
		}

	}

	public static void addNodeToResult(int sum){

		if(sum > 9){
			sum  = sum -10;
			carry = 1;
		}else{	

			carry=0;	
		}

		result = append(result,sum);
	}

	public static void printList(Node temp){
		
		while(temp!=null){

			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
}
