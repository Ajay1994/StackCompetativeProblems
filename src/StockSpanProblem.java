import java.util.*;
/*
 * The stock span problem is a financial problem where we have a series of n daily price quotes 
 * for a stock and we need to calculate span of stock’s price for all n days.
	The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days
	 just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
	For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the 
	span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 *
 * It ask for greater integer before the current index value. Solution ask to push values if TOS > value
 * else pop till TOS > value. Here we actually need index so instead of value we store index.
 * At any point of time i the stack contains the increasing sequence of prices. If at i, price is more than its immediate prev, then it will also be
 * more than the entire span of prev.

 */
public class StockSpanProblem {
	public static void main(String[] args) {
		int[] prices = {100, 80, 60, 70, 60, 75, 85};
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		
		System.out.println("Day 0" + "- " + "1");
		stack.push(0);
		for(int i = 1; i< prices.length; i++){
			while(!stack.isEmpty() && prices[stack.peek()] <= prices[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				//If stack is empty then price at i is more than all the previous prices.
				System.out.println("Day "+i + "- " + (i+1));
			}else{
				//else it is more than the Range (TOS - i) but less than TOS
				System.out.println("Day "+i + "- " + (i - stack.peek()));
			}
			stack.push(i);
		}
		
	}
}
