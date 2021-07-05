package ctci;


/**
 * @author Dell
 * TC - O(N)
 * SC - O(N)
 */
public class PallindromeCheck{

	static Node head1;
	static Node head2;


	public static void main(String args[]){

		System.out.println("Creating List"); //1,2,3,2,1
		head1 =append(head1,1);
		head1 =append(head1,2);
		head1 =append(head1,3);
		head1 =append(head1,2);
		head1 =append(head1,1);

		System.out.println("Printing List");
		printList(head1);

		System.out.println("Creating Reversed List");
		reverseList(head1);
		
		System.out.println("Printing Reversed List");
		printList(head2);

		checkPallindrome(head1,head2);
	}

	public static Node append(Node head,int value){

		Node temp = head;
		Node new_node = new Node(value);

		if(temp== null){

			temp = new_node;	
			return temp;
		}
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = new_node;
		return head;
	}


	public static void printList(Node temp){

		while(temp!=null){
			System.out.print(temp.data+" ");
			temp = temp.next;

		}
		System.out.println();

	}

	public static void reverseList(Node temp){

		while(temp!=null){

			head2 = addBefore(head2,temp.data);
			temp = temp.next;

		}

	}

	public static Node addBefore(Node head2, int data){

		Node new_node = new Node(data);
		Node temp =head2;

		if(temp == null){
			temp = new_node;
			return temp;
		}

		new_node.next = head2;
		head2 = new_node;
		return head2;
	}

	public static void checkPallindrome(Node temp1, Node temp2){

		while(temp1!=null && temp2!=null){

			if(temp1.data  != temp2.data){
				System.out.println("List is not Pallindrome");
				return;
			}	
			temp1 = temp1.next;
			temp2 = temp2.next;
		}	
		System.out.println("List is Pallindrome");
	}
}