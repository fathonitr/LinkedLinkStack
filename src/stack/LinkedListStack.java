package stack;

public class LinkedListStack<E> implements Stack<E> {
	private Node head;
	//Nest class
	private class Node{
		E data;
		Node link;
		@Override
		public String toString(){

			if(link==null){
				return String.format(""+data);
			}else{
				return String.format(""+data+", "+link);
			}
		}
		public E getData(){
			return data;
		}
	}
	public LinkedListStack(){
		head=null;
	}
	@Override
	public boolean isEmpty() {
		return head==null;
	}

	@Override
	public E top() throws Underflow {
		if (!isEmpty())

			return head.getData();
		else {
			throw new Underflow("Error Underflow in line 33");
		}
	}
	public static void main(String args[]) throws Underflow {
		LinkedListStack test= new LinkedListStack();
		//test.push(1);
		//test.push(2);
		//System.out.println(test.top());
		//System.out.println(test.pop().getClass().getSimpleName());
		String before = test.toString();
		test.push("huhu");
		test.pop();
		//System.out.println(test.pop());
	}

	@Override
	public void push(E element){
		// create new node temp and allocate memory
		Node temp = new Node();

		// check if stack (heap) is full. Then inserting an
		//  element would lead to stack overflow
		if (temp == null) {
			//throw new Overflow("Overflow in line 46");
			System.out.print("\nHeap Overflow");
			return;
		}

		// initialize data into temp data field
		temp.data = element;

		// put top reference into temp link
		temp.link = head;

		// update top reference
		head = temp;
		//System.out.println("temp.data: "+temp.data+" temp.link: "+temp.link+" head: "+head+" temp: "+temp);

	}

	@Override
	public E pop() throws Underflow {
		// check for stack underflow
		if (head == null) {

			throw new Underflow("error");
			//return;
		}

		// update the top pointer to point to the next node
		head = (head).link;
		return head.getData();
		
	}
	public String toString(){

		return String.format(""+head);
	}

}
