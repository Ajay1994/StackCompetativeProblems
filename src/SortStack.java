import java.util.Stack;
/*
 * Algorithm
We can use below algorithm to sort stack elements:

sortStack(stack S)
	if stack is not empty:
		temp = pop(S);  
		sortStack(S); 
		sortedInsert(S, temp);

Below algorithm is to insert element is sorted order:

sortedInsert(Stack S, element)
	if stack is empty OR element > top element
		push(S, elem)
	else
		temp = pop(S)
		sortedInsert(S, element)
		push(S, temp)

 */
public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(9);
		stack.push(1);
		stack.push(15);
		stack = sortStack(stack);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

	private static Stack<Integer> sortStack(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		if(stack.isEmpty()) return stack;
		int x = stack.pop();
		stack = sortStack(stack);
		stack = insertSortedStack(stack, x);
		return stack;
	}

	private static Stack<Integer> insertSortedStack(Stack<Integer> stack, int x) {
		// TODO Auto-generated method stub
		if(stack.isEmpty() || stack.peek() <= x){
			stack.push(x);
			return stack;
		}
		//Here we are inserting in a sorted stack, so we pop here and see at what level we can insert x safely and then we can push back the item
		int item = stack.pop();
		stack = insertSortedStack(stack, x);
		stack.push(item);
		return stack;
	}

}
