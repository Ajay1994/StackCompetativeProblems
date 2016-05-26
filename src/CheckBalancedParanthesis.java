import java.util.*;
/*
 * Algorithm:
1) Declare a character stack S.
2) Now traverse the expression string exp.
    a) If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    b) If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3) After complete traversal, if there is some starting bracket left in stack then “not balanced”
 */

public class CheckBalancedParanthesis {
	
	public static void main (String[] args)
	 {
			Scanner scan = new Scanner(System.in);
	        String list = scan.nextLine();
	       
	        java.util.Stack<Character> stack = new java.util.Stack<Character>();
	        for(int j = 0; j<list.length(); j++){
	            char ch = list.charAt(j);
	           
	            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
	            else{
	            	if(!stack.isEmpty() && ch == ')' && stack.peek() == '('){
	            		stack.pop();
		            }
		            if(!stack.isEmpty() && ch == ']' && stack.peek() == '['){
		                stack.pop();
		            }
		            if(!stack.isEmpty() && ch == '}' && stack.peek() == '{'){
		                stack.pop();
		            }
	            }
	        }
	        if(stack.isEmpty()){
	            System.out.println("balanced");
	        }else{
	            System.out.println("not balanced");
	        }
	        
	 }

}
