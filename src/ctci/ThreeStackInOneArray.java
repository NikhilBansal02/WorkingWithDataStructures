//Below program implemented three stack in one single array.

//TC- O(1)
//SC- O(1)

package ctci;

public class ThreeStackInOneArray {

	int NumberOfStack =3;
	int SizeOfArray;
	int SizeOfS1;
	int SizeOfS2;
	int SizeOfS3;
	int count1=0;
	int count2=0;
	int count3=0;
	int TOP1;
	int TOP2;
	int TOP3;

	int arr[];


	ThreeStackInOneArray(int SizeOfArray){
		this.SizeOfArray   = SizeOfArray;
		arr = new int[SizeOfArray];
		computeSizeOfEachStack(SizeOfArray);
		setTOP();

	}
	/**
	 * @param SizeOfArray
	 * Below approach will be used to compute the size; [ -> inclusive,  -> exclusive
	 * [0 to n/3), for n=10, 0,1,2, size =3
	 * [n/3 to 2n/3), for n=10, 3,4,5, size=3
	 * [2n/3 to n), for n=10, 6,7,8,9, size=4
	 */
	public void computeSizeOfEachStack(int SizeOfArray) {

		SizeOfS1 = SizeOfArray/3;
		SizeOfS2 = (2*SizeOfArray)/3 - SizeOfS1; 
		SizeOfS3 = SizeOfArray -(SizeOfS1 + SizeOfS2);

		System.out.println("Stack Sizes are - ");
		System.out.println(SizeOfS1 +" "+SizeOfS2+" "+SizeOfS3);

	}

	/**
	 * Below approach will be used to compute the size; [ -> inclusive,  -> exclusive
	 * [0 to n/3), for n=10, 0,1,2, size =3
	 * [n/3 to 2n/3), for n=10, 3,4,5, size=3
	 * [2n/3 to n), for n=10, 6,7,8,9, size=4
	 */
	public void setTOP() {

		TOP1 = -1;
		TOP2 = (SizeOfArray/3)  - 1 ;//3
		TOP3 = ((2*SizeOfArray)/3)   - 1;//6
		System.out.println("Initial Position are - ");
		System.out.println(TOP1 +" "+TOP2+" "+TOP3);
	}


	public static void main(String[] args) {

		ThreeStackInOneArray ts = new ThreeStackInOneArray(20);

		System.out.println("Implementing Stack Operation");
		ts.push(1,0);
		ts.push(1,1);
		ts.push(1,2);
		ts.push(1,3);
		ts.peek(1);
		
		ts.pop(1);
		ts.pop(1);
		ts.pop(1);
		ts.peek(1);

		ts.push(2,10);
		ts.push(2,11);
		ts.push(2,12);
		ts.push(2,13);
		ts.peek(2);
		ts.pop(2);
		ts.pop(2);
		ts.pop(2);
		ts.peek(2);

		ts.push(3,20);
		ts.push(3,21);
		ts.push(3,22);
		ts.push(3,23);
		ts.push(3,24);
		ts.peek(3);
		
		ts.pop(3);
		ts.pop(3);
		ts.pop(3);
		ts.pop(3);
		ts.peek(3);
		
		

	}

	public boolean isEmpty(int stack) {

		if(stack==1)
			return (count1 ==0);
		else if(stack==2)
			return (count2 ==0);
		else 
			return (count3 ==0);


	}

	public boolean isFull(int stack) {

		if(stack==1)
			return (count1 ==SizeOfS1);
		else if(stack==2)
			return (count2 ==SizeOfS2);
		else 
			return (count3 ==SizeOfS3);
	}

	public void push(int stack, int item) {

		if(stack !=1 && stack!=2 && stack!=3) {
			System.out.println("Illegal Stack entered : "+stack );
			return;
		}

		if(isFull(stack)) {
			System.out.println("Stack : " +stack +" is full");
			return;
		}else {
			if(stack==1){
				arr[++TOP1] = item;
				count1++;
				System.out.println("Item Pushed to Stack1 : "+item);
				System.out.println("Initial Position changes from : "+(TOP1-1) +" to "+TOP1 + ", Count1 : "+count1);
				//if(count==2)
			}
			else if(stack==2){
				arr[++TOP2] = item;
				count2++;
				System.out.println("Item Pushed to Stack2 : "+item);
				System.out.println("Initial Position from : "+(TOP2-1) +" to "+TOP2 + ", Count2 : "+count2);
			}
			else {
				arr[++TOP3] = item;
				count3++;
				System.out.println("Item Pushed to Stack3 : "+item);
				System.out.println("Initial Position from : "+(TOP3-1) +" to "+TOP3 + ", Count3 : "+count3);
			}
		}
	}


	public void pop(int stack) {
		
		int item =0;
		
		if(stack !=1 && stack!=2 && stack!=3) {
			System.out.println("Illegal Stack entered : "+stack );
			return;
		}

		if(isEmpty(stack)) {
			System.out.println("Stack : " +stack +" is empty");
			return;
		}else {
			if(stack==1){
				item = arr[TOP1--];
				count1--;
				System.out.println("Item popped from Stack1 : "+item);
				System.out.println("Initial Position changes from : "+(TOP1+1) +" to "+TOP1 + ", Count1 : "+count1);
			}
			else if(stack==2){
				item = arr[TOP2--];
				count2--;
				System.out.println("Item popped from Stack2 : "+item);
				System.out.println("Initial Position from : "+(TOP2+1) +" to "+TOP2 + ", Count2 : "+count2);
			}
			else {
				item = arr[TOP3--];
				count3--;
				System.out.println("Item popped from Stack3 : "+item);
				System.out.println("Initial Position from : "+(TOP3+1) +" to "+TOP3 + ", Count3 : "+count3);
			}
		}
	}
	
	public void peek(int stack) {
		
		if(stack !=1 && stack!=2 && stack!=3) {
			System.out.println("Illegal Stack entered : "+stack );
			return;
		}

		if(isEmpty(stack)) {
			System.out.println("Stack : " +stack +" is empty");
			return;
		}else {
			if(stack==1){
				System.out.println("TOP item in Stack1 : "+arr[TOP1]);
			}
			else if(stack==2){
				System.out.println("TOP item in Stack2 : "+arr[TOP2]);
			}
			else {
				System.out.println("TOP item in Stack3 : "+arr[TOP3]);
			}
		}
		
	}

}
