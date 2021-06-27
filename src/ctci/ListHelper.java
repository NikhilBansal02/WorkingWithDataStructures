package ctci;

public class ListHelper {
	
	public static void print(Node head) {
		
		Node temp =head;
		
		while(temp!=null) {
				
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
public static Node append(Node head,int data){
		
		if(head == null){
		head = new Node(data);
		return head;
		}

		Node temp = head;

		while(temp.next!=null){
		
		temp =temp.next;
		}

		temp.next = new Node(data);	
		return head;

	}

public static Node addbefore(Node head, int data) {
	
	if(head == null){
		head = new Node(data);
		return head;
	}
	
	Node new_node = new Node(data);
	new_node.next = head;
	head = new_node;
	
	return head;
}

}
