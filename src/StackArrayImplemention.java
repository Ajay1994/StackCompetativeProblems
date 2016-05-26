class Stack{
	int top;
	int size;
	int list[];
	Stack(int size){
		this.size = size;
		this.list = new int[size];
		this.top = -1;
	}
}
public class StackArrayImplemention {
	public static boolean isEmpty(Stack stack){
		if(stack.top == -1) return true;
		return false;
	}
	public static boolean isFull(Stack stack){
		if(stack.top == (stack.size-1)) return true;
		else return false;
	}
	public static int peek(Stack stack){
		if(!isEmpty(stack)) return stack.list[stack.top];
		else return -1;
	}
	public static void push(Stack stack, int data){
		if(isFull(stack)){
			System.out.println("Stack is full !!");
			return;
		}
		stack.list[++stack.top] = data;
	}
	public static int pop(Stack stack){
		if(isEmpty(stack)){
			System.out.println("Stack is empty !!");
			return -1;
		}
		int data = stack.list[stack.top];
		stack.top = stack.top - 1;
		return data;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(3);
		System.out.println("Is stack empty ? - " + isEmpty(stack));
		push(stack, 10);
		push(stack, 20);
		push(stack, 30);
		push(stack, 40);
		for(int i = 0; i <= stack.top; i++){
			System.out.print(stack.list[i] + " -");
		}
		System.out.println();
		System.out.println("No of element in stack - "+(stack.top +1));
		while(!isEmpty(stack)){
			System.out.println("Poping ..."+ pop(stack));
		}
	}

}
