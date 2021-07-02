/*
 * Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list the values of x only need
 *to be after the elements less than x (see below). The partition element x can appear anywhere in the
 *"right partition"; it does not need to appear between the left and right partitions.
 *EXAMPLE
 *Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
 *Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *TC - O(N) 
 *SC - O(N)
 */

package ctci;
class partitonLinkedList{

	static Node result;
	static Node head;

	public static void main(String args[]){

		head= ListHelper.append(head,3);
		head= ListHelper.append(head,5);
		head= ListHelper.append(head,8);
		head= ListHelper.append(head,0);
		head= ListHelper.append(head,5);
		head= ListHelper.append(head,10);
		head= ListHelper.append(head,2);
		head= ListHelper.append(head,1);

		ListHelper.print(head);
		partition(head,3);
		ListHelper.print(result);
	}

	public static void partition(Node head, int partition){

		if(head == null){

			System.out.println("List is Empty");
			return;
		}
		Node temp =head;
		boolean partitionPresent=false;
		while(temp !=null){

			if(temp.data == partition){
				partitionPresent=true;
				break;

			}
			temp = temp.next;
		}

		if(!partitionPresent){

			System.out.println("Partition is not present");
			return;
		}
		System.out.println("After partition present check");
		temp = head;
		int partitionCount = 0;
		while(temp!=null){

			if(temp.data > partition){
				result = ListHelper.append(result, temp.data);


			}else if(temp.data < partition){
				result= ListHelper.addbefore(result,temp.data);	
			}else if(temp.data == partition){

				partitionCount++;
			}
			temp = temp.next;
		}

		temp = result;
		ListHelper.print(result);
		Node prev = null;
		while(temp.data <partition){
			prev = temp;
			temp =temp.next;

		}
		System.out.println("Prev data - " + prev.data);
		System.out.println("Partition Count - " + partitionCount);
		while(partitionCount >0){

			Node new_node = new Node(partition);
			new_node.next  = prev.next;
			prev.next  = new_node;
			partitionCount--;		
		}	
		System.out.println("Exiting partition");
	}

}

