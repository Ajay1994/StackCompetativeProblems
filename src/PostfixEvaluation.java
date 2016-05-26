import java.util.*;
/*
 * Following is algorithm for evaluation postfix expressions.
1) Create a stack to store operands (or values).
2) Scan the given expression and do following for every scanned element.
…..a) If the element is a number, push it into the stack
…..b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and push the result back to the stack
3) When the expression is ended, the number in the stack is the final answer
 */

public class PostfixEvaluation {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String postfix = scan.nextLine();
		
		
		
		//Note - lower precedence operator cant reside on top of a higher precedence operators
		java.util.Stack<Integer> stack = new java.util.Stack<Integer> (); 
		
		for(int i =0; i < postfix.length(); i++){
			char ch = postfix.charAt(i);
			if(ch >= '1' && ch <= '9'){
				stack.push(ch - '0');
			}else{
				int x;
				int value1 = stack.pop();
				int value2 = stack.pop();
				switch(ch){
					case '+':
						stack.push(value2 + value1);
						break;
					case '-':
						stack.push(value2 - value1);
						break;
					case '*':
						stack.push(value2 * value1);
						break;
					case '/':
						stack.push(value2 / value1);
						break;
					case '^':
						stack.push(value2 ^ value1);
						break;
				}
			}
		}
		System.out.println(stack.pop());
	}
}
