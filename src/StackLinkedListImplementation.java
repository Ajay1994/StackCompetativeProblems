class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
public class StackLinkedListImplementation {
	static Node head = null;
	public static boolean isEmpty(){
		if (head == null) return true;
		else return false;
	}
	public static int peek(){
		if(head == null){
			System.out.println("Stack is empty !!");
			return -1;
		}
		return head.data;
	}
	public static int pop(){
		if(head == null){
			System.out.println("Stack is empty !!");
			return -1;
		}
		Node node = head;
		head = head.next;
		return node.data;
	}
	public static void push(int data){
		Node node = new Node(data);
		if(head == null){
			head = node;
			return;
		}
		node.next = head;
		head = node;
	}
	public static int getLength(Node head){
		if(head == null)
			return 0;
		if(head.next == null) 
			return 1;
		return 1 + getLength(head.next);
	}
	public static void main(String[] args) {
		System.out.println("Is empty :"+isEmpty());
		for(int i = 0; i<5; i++){
			push(i);
			System.out.println("Pushing ... "+i);
		}
		System.out.println(getLength(head));
		while(!isEmpty()){
			System.out.println("Poping ..." + pop());
		}
	}
}
