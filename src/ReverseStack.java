import java.util.Stack;
/*
 *The idea of the solution is to hold all values in Function Call Stack 
 *until the stack becomes empty. When the stack becomes empty, insert all held items one 
 *by one at the bottom of the stack.  
 *--------> Idea is to push an item on the bottom of a partially reversed stack.
 */
public class ReverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack = reverseStack(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	//This function is responsible for pushing the item at the end of stack
	private static Stack<Integer> insertAtBottom(Stack<Integer> stack, int item){
		if(stack.isEmpty()){
			stack.push(item);
			return stack;
		}
		int x = stack.pop();
		stack = insertAtBottom(stack, item);
		stack.push(x);
		return stack;
	}
	//This function is reversing a partial stack and then pushing the item at level of recursion to end of stack 
	private static Stack<Integer> reverseStack(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(stack.isEmpty()) return stack;
		int x = stack.pop();
		stack = reverseStack(stack);
		stack = insertAtBottom(stack, x);
		return stack;
	}

}
