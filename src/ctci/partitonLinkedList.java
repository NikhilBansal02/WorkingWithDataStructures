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

