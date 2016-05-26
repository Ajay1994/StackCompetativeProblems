import java.util.*;
/*
 * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(),
 * isEmpty(), isFull() and an additional operation getMin() which should return minimum element from
 * the SpecialStack. All these operations of SpecialStack must be O(1).
 * 
 * Idea - Maintain an auxilary stack which contains the minimum at each level of the entry of stack.
 * push() on stack - peek the TOS of aux and if it is less than the element being pushed, do nothing else push it on TOS.
 * pop() on stack - peek the TOS and if it equal to element being popped, pop it  
 */
class SpecialStack extends java.util.Stack<Integer>{
	public java.util.Stack<Integer> min = new java.util.Stack<Integer>();
	public java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
	public void push(int data){
		if(stack.isEmpty()){
			stack.push(data);
			min.push(data);
		}else{
			if(data <= min.peek()){
				min.push(data);
				stack.push(data);
			}else{
				stack.push(data);
			}
		}
	}
	public Integer pop(){
		if(!stack.isEmpty()){
			int x = stack.pop();
			if(x == min.peek()){
				min.pop();
				return x;
			}else{
				return x;
			}
		}else{
			System.out.println("Stack is empty !!");
			return null;
		}
	}
	public Integer getMin(){
		return min.peek();
	}
}
public class GetMinWithStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialStack stack = new SpecialStack();
		stack.push(5);
		System.out.println(stack.getMin());
		stack.push(9);
		System.out.println(stack.getMin());
		stack.push(1);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.push(10);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.pop();
	}

}
