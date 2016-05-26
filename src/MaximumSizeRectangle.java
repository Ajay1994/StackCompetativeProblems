import java.util.*;

/*
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be 
 * made of a number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.

	For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 2, 6}. 
	The largest possible rectangle possible is 12
	
	
	We traverse all bars from left to right, maintain a stack of bars. Every bar is pushed to stack once. A bar 
	is popped from stack when a bar of smaller height is seen. When a bar is popped, we calculate the area with the 
	popped bar as smallest bar. How do we get left and right indexes of the popped bar – the current index tells us 
	the ‘right index’ and index of previous item in stack is the ‘left index’. Following is the complete algorithm.

	1) Create an empty stack.
	
	2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
	……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
	……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
	
	3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 */
public class MaximumSizeRectangle {

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if( i >= j) return i;
		else return j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		int [] array = {6, 2, 5, 4, 5, 1, 6};
		int [] prevMin = new int[array.length];
		int [] nextMin = new int[array.length];
		
		//Finding the next minimum
		prevMin[0] = -1;
		
		
		stack.push(0);
		for(int i = 1; i<array.length; i++){
			if(stack.isEmpty()){
				stack.push(i);
				prevMin[i] = -1;
			}else if(!stack.isEmpty() && array[i] > array[stack.peek()]){
				prevMin[i] = stack.peek();
				stack.push(i);
			}else{
				
				while(!stack.isEmpty() && array[i] <= array[stack.peek()]){
					stack.pop();
				}
				if(stack.isEmpty()) prevMin[i] = -1;
				else prevMin[i] = stack.peek();
				stack.push(i);
			}
		}
		while(!stack.isEmpty()){
			stack.pop();
		}
		//finding the next maximum
		for(int i = 0; i < array.length; i++){
			if(stack.isEmpty()) stack.push(i);
			else if(!stack.isEmpty() && array[stack.peek()] <= array[i]){
				stack.push(i);
			}else{
				while(!stack.isEmpty() && array[stack.peek()] > array[i]){
					nextMin[stack.pop()] = i;
				}
				stack.push(i);
			}
		}
		while(!stack.isEmpty()){
			nextMin[stack.pop()] = array.length;
		}
		
		int [] window = new int[array.length+1];
		
		for(int i = 0; i< window.length; i++) window[i] = 0;
		int index = 0;
		for(int i = 0; i< array.length; i++){
			index = nextMin[i] - prevMin[i] - 1;
			window[index] = max(window[index], array[i]);
		}
		//If some entries are left 0, it means that it means there is no direct element which 
		//is minimum of length i and therefore either the element of length ans[i+1], 
		//or ans[i+2], and so on is same as ans[i]
		int rightmost = window[window.length-1];
		for(int i = window.length -2; i > 0; i--){
			if(window[i] == 0) window[i] = rightmost;
			rightmost = window[i];
		}
		
		int result = 0;
		for(int i = 0; i < window.length; i++){
			if(result < i*window[i]) result = i*window[i];
		}
		System.out.println(result);
	}

}
