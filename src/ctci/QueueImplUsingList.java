package ctci;
public class QueueImplUsingList{

	static Node front;
	static Node rear;

	public static void main(String args[]){
		
		front();
		rear();
		enqueue(1);	
		front();
		rear();
		enqueue(2);
		front();
		rear();
		enqueue(3);
		front();
		rear();
		enqueue(4);
		front();
		rear();
		dequeue();
		front();
		rear();
		dequeue();
		front();
		rear();
		enqueue(5);
		front();
		rear();
		dequeue();
		front();
		rear();
		dequeue();
		front();
		rear();
		dequeue();
		front();
		rear();

	}

	public static void enqueue(int data)
	{	
		Node new_node = new Node(data);

		if(rear == null){

			rear = new_node;
			front = rear;
			System.out.println("Element Enqueued : "+rear.data);
			return;
		}

		rear.next = new_node;
		rear = new_node;
		System.out.println("Element Enqueued : "+rear.data);


	}

	public static void dequeue(){


		if(front==null){
			System.out.println("Queue is Empty");
			return;
		}
		System.out.println("Element Dequeued is : "+front.data);
		front = front.next;	
		if(front ==null) {
			rear = null;
		}
	}

	public static void front(){


		if(front==null){
			System.out.println("Queue is Empty");
			return;
		}
		System.out.println("Front Element is : "+front.data);
	}

	public static void rear(){


		if(rear==null){
			System.out.println("Queue is Empty");
			return;
		}
		System.out.println("Rear Element is : "+rear.data);
	}

	public static void isEmpty(){

		System.out.println("Is Queue Empty :"+(front == null && rear ==null));

	}
}