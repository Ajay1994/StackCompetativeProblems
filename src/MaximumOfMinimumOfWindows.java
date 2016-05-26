import java.util.*;
/*
 * Given an integer array of size n, find the maximum of the minimum’s of every window size in the array.
 *  Note that window size varies from 1 to n.

	Example:
	
	Input:  arr[] = {10, 20, 30, 50, 10, 70, 30}
	Output:         70, 30, 20, 10, 10, 10, 10
	
	First element in output indicates maximum of minimums of all 
	windows of size 1.
	Minimums of windows of size 1 are {10}, {20}, {30}, {50}, {10},
	{70} and {30}.  Maximum of these minimums is 70
	
 */
public class MaximumOfMinimumOfWindows {
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if( i >= j) return i;
		else return j;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		int [] array = {10, 20, 30, 50, 10, 70, 30};
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
		
		
		for(int i = 0; i<window.length; i++){
			System.out.println(window[i]);
		}
	}

}
