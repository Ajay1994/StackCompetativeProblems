import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.
 */
public class InfixToPostfix {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String infix = scan.nextLine();
		
		//creating the precedence list
		Map<Character, Integer> precedence = new HashMap<Character, Integer>();
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
		precedence.put('^', 3);
		precedence.put('(', -1);
		StringBuffer postfix = new StringBuffer();
		//Note - lower precedence operator cant reside on top of a higher precedence operators
		java.util.Stack<Character> stack = new java.util.Stack<Character> (); 
		
		for(int i = 0; i < infix.length(); i++){
			char ch = infix.charAt(i);
			if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
				postfix.append(ch);
			}else if(ch == '('){
				stack.push(ch);
			}else if(ch == ')'){
				//Pop till ( is encountered and if stack becomes empty and you didnt get ( - invalid.
				while(!stack.isEmpty() && stack.peek() != '('){
					postfix.append(stack.pop());
				}
				if(stack.peek() != '('){
					System.out.println("Invalid Exp");
				}else{
					stack.pop();
				}
			}else{
				//Operator is encountered, pop till the you get an operator lower in precedence on TOS
				//You can put lower precedence operator on higher precedence but can't higher on top of lower
				while(!stack.isEmpty() && precedence.get(ch) <= precedence.get(stack.peek())){
					postfix.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		while(!stack.isEmpty()) postfix.append(stack.pop());
		System.out.println(postfix.toString());
		
	}
}
