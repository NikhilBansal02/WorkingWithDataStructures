
/*
 * Below program checks for intersection between two lists.
 * The Intersection is present based on reference and not on value.
 * Below algo. is being used - 
 * 1. Run through each linked list to get the lengths and the tails.
 * 2. Compare the tails. If they are different (by reference, not by value), return immediately. There is no intersection.
 * 3. Set two pointers to the start of each linked list.
 * 4. On the longer linked list, advance its pointer by the difference in lengths.
 * 5. Now, traverse on each linked list until the pointers are the same.
 * TC - O(N)
 * SC - O(1)
*/
package ctci;
public class IntersectionCheck{

static Node head1;
static Node head2;

	public static void main(String args[]){
	
	System.out.println("Creating first list");
	head1 = append(head1,3);
	head1 = append(head1,1);
	head1 = append(head1,5);
	head1 = append(head1,9);
	head1 = append(head1,7);
	head1 = append(head1,2);
	head1 = append(head1,1);

	System.out.println("Creating Second list");
	head2 = append(head2,4);
	head2 = append(head2,5);
	System.out.println("Creating Intersection");
	head2.next.next = head1.next.next.next.next;

	System.out.println("Checking Intersection : "+head2.next.next.data);
	
	Node intersection = checkAndFindIntersection(head1,head2);
	System.out.println("Intersection Found at : "+intersection.data);
	
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
	
	public static Node checkAndFindIntersection(Node h1,Node h2){

		Node t1 = h1;
		Node t2 = h2;
		int count1=1; // why count starts at 1 , as we are checking t1.next or t2.next in below while loops.
		int count2=1;
	
		while(t1.next!=null){
			t1 = t1.next;
			count1++;
		}
		while(t2.next!=null){
			t2 = t2.next;
			count2++;
		}

		if(t1 != t2){
		
			System.out.println("No Intersection Present");
			return null;

		}
		t1 =h1;
		t2 =h2;

		int diff = Math.abs(count1-count2);
		if(count1>count2){
			
			while(diff>0){
				
				t1 = t1.next;
				diff--;

			}	
		}else{
			while(diff>0){
				
				t2 = t2.next;
				diff--;

			}
		}
	
		while(t1!=t2){
			
			t1 = t1.next;	
			t2 = t2.next;

		}
		
		return t2;
	
	}
}