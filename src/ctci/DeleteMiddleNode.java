/*Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
 * the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
 * that node.
 * EXAMPLE
 * lnput:the node c from the linked list a->b->c->d->e->f
 * Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f
 * TC - O(1)
 * SC - O(1)
*/
package ctci;
public class DeleteMiddleNode{
	static Node head;

	public static void main(String args[]){
	
	head = ListHelper.append(head,1);
	head = ListHelper.append(head,2);
	head = ListHelper.append(head,3);
	head = ListHelper.append(head,4);
	head = ListHelper.append(head,5);
	head = ListHelper.append(head,6); 	

	ListHelper.print(head);
	deleteMiddle(head.next.next);//3	
	ListHelper.print(head);

	}
	public static void deleteMiddle(Node node){
	
	if(node ==null || node.next == null){
		System.out.println("Node cannot be deleted.Either its null or its the last node");
		return;
	}

	Node temp = node.next;

	node.data = temp.data;
	node.next = temp.next;
	}

}
           	
//1-2-4-5-6