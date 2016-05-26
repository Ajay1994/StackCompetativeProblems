import java.util.*;
/*
 * Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

	Examples:
	
	Input : ((()
	Output : 2
	Explanation : ()
	
	//Crusk of the approach is to push the opening brace and if closing comes pop from stack and the again compare with the 
	 * remainning TOS. If in case the satck becomes empty put the curect value to stack to use it as marker.
	 * 
	 * 
	 * 1) Create an empty stack and push -1 to it. The first element
		   of stack is used to provide base for next valid string. 
		
		2) Initialize result as 0.
		
		3) If the character is '(' i.e. str[i] == '('), push index 
		   'i' to the stack. 
		   
		2) Else (if the character is ')')
		   a) Pop an item from stack (Most of the time an opening bracket)
		   b) If stack is not empty, then find length of current valid
		      substring by taking difference between current index and
		      top of the stack. If current length is more than result,
		      then update the result.
		   c) If stack is empty, push current index as base for next
		      valid substring.
		
		3) Return result.
 */
public class LongestValidParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "()(()()))(((((())))))";
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		int result = 0;
		// this is pushed becoause if in case, ))) wil come this will pop out.
		stack.push(-1);
		
		for(int i = 0; i < string.length(); i++){
			char ch = string.charAt(i);
			if(ch == '('){
				stack.push(i);
			}else{
				stack.pop();
				if(!stack.isEmpty()){
					result = max(result, (i - stack.peek()));
					
				}else{
					stack.push(i);
					//stack may become empty, in that case to push the start index of the comparison.
					// this case arises when after the match of complete set another ) comes and that pops away the -1 also.
				}
				
			}
		}
		System.out.println(result);
	}

	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		if( i >= j) return i;
		else return j;
	}

}
