import java.util.*;
public class ArrayRepresentBSTPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {40, 30, 35, 80, 100};
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		// Idea is to get the initialization of root at the deepest sub tree level.
		int root = Integer.MIN_VALUE;
		for(int i = 0; i < array.length; i++){
			//If any value less than root is coming where root have been initialized
			//such that its left tree is already traversed. then in this case
			//whole array is right child part and all elements coming after it should be greater than root.
			if(array[i] < root){
				System.out.println("Not Possible");
				return;
			}
			while(!stack.isEmpty() && stack.peek() < array[i]){
				//Popped element remains the root ensuring left portion covered and TOS is right sub tree root
				root = stack.peek();
				stack.pop();
			}
			stack.push(array[i]);
		}
		System.out.println("True");
	}

}
