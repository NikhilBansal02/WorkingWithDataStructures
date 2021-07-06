package ctci;
public class DetectAndRemoveLoop{

static Node head1;

	public static void main(String args[]){

	head1 = append(head1,3);
	head1 = append(head1,1);
	head1 = append(head1,5);
	head1 = append(head1,9);
	head1 = append(head1,7); // 3-1-5-9-7
	//head1.next.next.next.next.next = head1.next.next;
	//System.out.println("Checking if loop is created or not on 5 :" + head1.next.next.next.next.next.data);

	detectAndRemoveLoop(head1);
	ListHelper.print(head1);;

}

public static Node append(Node list , int data){
		
		
		Node new_node = new Node(data);
		if(list == null){
			
		list = new_node;
		return list;

		}

		Node temp = list;
		while(temp.next!=null){
			temp = temp.next;

		}	
		temp.next = new_node;
		return list;
		
	}

	public static void detectAndRemoveLoop(Node temp){

		
	Node slow  = temp;
	Node fast    = temp;

	slow = slow.next;
	fast  = fast.next.next;

	while(slow!=fast && fast.next!=null && fast.next.next!=null){
		
	slow = slow.next;
	fast  = fast.next.next;

	}
	
	if(slow==fast){

		System.out.println("Loop Exists");
		removeLoop(temp,slow);
	
	}else
		System.out.println("No Loop Found");

	}
		
	public static void removeLoop(Node temp, Node slow){
		
		Node t1 = temp;
		Node t2 = slow;
		
		while(true){
		while(slow !=t2.next && t1!=t2.next){
			t2 = t2.next;
			
		}
		
		if(t1 == t2.next){

			System.out.println("Loop Node Found at: "+t2.next.data);
			System.out.println("Loop Removed");
			t2.next = null;
			return;
		
		}
		
		t1 = t1.next;
		t2 = slow;
		}


	}

}