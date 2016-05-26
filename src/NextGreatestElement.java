import java.util.*;
/*
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first
 *  greater element on the right side of x in array. Elements for which no greater element exist, 
 *  consider next greater element as -1. 
 *  
 *  Algorithm :
 *  1) Push the first element to stack.
2) Pick rest of the elements one by one and follow following steps in loop.
….a) Mark the current element as next.
….b) If stack is not empty, then pop an element from stack and compare it with next.
….c) If next is greater than the popped element, then next is the next greater element for the popped element.
….d) Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements
….g) If next is smaller than the popped element, then push the popped element back.
3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them.
 */
public class NextGreatestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int [] list = {13, 7, 6, 12};
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		for(int i = 0; i < list.length; i++){
			if(stack.isEmpty()){
				stack.push(list[i]);
			}else{
				while(!stack.isEmpty() && stack.peek() < list[i]){
					int x = stack.pop();
					System.out.println(x + " -> " + list[i]);
				}
				stack.push(list[i]);
			}
		}
		while(!stack.isEmpty()){
			int x = stack.pop();
			System.out.println(x + " -> " + "-1");
		}
	}

}
