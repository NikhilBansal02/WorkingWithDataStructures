//Write code to remove duplicates from an unsorted linked list.
//TC - O(N) 
package ctci;

import java.util.HashMap;
import java.util.Map;

class RemoveDuplicate{
	static Node head;

	public static void main(String a[]){

		head = ListHelper.append(head,5);	
		head = ListHelper.append(head,3);
		head = ListHelper.append(head,6);
		head = ListHelper.append(head,2);
		head = ListHelper.append(head,1);
		head = ListHelper.append(head,2);
		head = ListHelper.append(head,3);
		head = ListHelper.append(head,1);

		ListHelper.print(head);
		removeDuplicates(head);
		ListHelper.print(head);
	}

	public static void removeDuplicates(Node head){

		if(head == null){

			System.out.println("List is empty");
			return;
		}

		Map<Integer, Integer> map =new HashMap<Integer,Integer>();

		Node temp = head;
		Node prev = null;

		while(temp!=null){

			if(map.containsKey(temp.data)){
				prev.next = temp.next;

			}else{
				map.put(temp.data,1);
				prev= temp;
			}
			temp = temp.next;
		}
	}
}
