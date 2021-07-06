//Queue implementation using Array
//TC - O(1) i.e. constant
//SC - O(1) i.e. constant
package ctci;

public class QueueImplUsingArray {

	int arr[];
	int capacity;
	int front = 0;
	int rear;
	int size =0;

	QueueImplUsingArray(int capacity){
		this.capacity = capacity;
		arr = new int[capacity];
		rear = capacity -1;


	}
	public static void main(String[] args) {

		QueueImplUsingArray q = new QueueImplUsingArray(5);//capacity = 5, rear = 5;
		q.enqueue(0);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(10);
		q.dequeue();
		q.dequeue();
		q.rearItem();
		q.enqueue(10);
		q.enqueue(20);
		q.frontItem();
		q.dequeue();
		q.frontItem();
		q.enqueue(30);
		q.frontItem();
		q.frontItem();
		q.rearItem();
		q.dequeue();
		q.dequeue();
		q.rearItem();

	}

	public boolean isEmpty() {

		return size==0;

	}
	public boolean isFull() {

		return size==capacity;

	}
	public void enqueue(int item) {

		if(isFull()) {
			System.out.println("Queue overflowed...!!!!");
		}else {
			rear = (rear+1)% capacity;
			arr[rear] = item;
			size++;
			System.out.println("Item enqueued : "+item);
		}
	}

	public void dequeue() {

		if(isEmpty()) {
			System.out.println("Queue is empty...!!!!");
		}else {
			System.out.println("Element dequeued : "+arr[front]);
			front =(front+1)%capacity;
			size--;
		}
	}

	public void frontItem() {

		if(isEmpty()) {
			System.out.println("Front Item - Queue is empty...!!!!");
		}else {
			System.out.println("Front Element : "+arr[front]);
		}

	}

	public void rearItem() {

		if(isEmpty()) {
			System.out.println("Rear Item - Queue is empty...!!!!");
		}else {
			System.out.println("Rear Element : "+arr[rear]);
		}

	}

}
