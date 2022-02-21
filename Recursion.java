/*
 * There is no requirement for a file header comment for this 
 * assignment. Spend your time writing good testcases instead!
 */
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Recursion {

	/**
	 * Write a recursive function that finds the index of s2 in s1. Do not use any
	 * string functions except for .length(), .equals(), and .substring(). Do not use
	 * any loops, or any data structures.
	 * @param s1
	 * @param s2
	 * @return Returns the index of the first time that
	 * 			s2 appears in s1 or -1 if s2 is not contained
	 * 			in s1.
	 */
	public static int indexOf(String s1, String s2) {
		
		// Base Case: Returns -1 since s1 is smaller than s2
		
		if (s1.length() < s2.length()) {
			
			return -1;
			
		}
		
		// Returns 0 since the portion of s1 is equal to s2
		
		if (s1.substring(0, s2.length()).equals(s2)) {
			return 0;
		}
		
		// Recursing here, this time with removing the first character in the string
		
		int index = indexOf(s1.substring(1), s2);
		
		// Checking if the index is -1, if so, returning that value
			
		if (index == -1) {
				
			return -1;
			
		// If the value of index is not -1, increment index by 1	
			
		} else {
				
			return index + 1;
			}
		}

	/**
	 * Write a recursive function that removes the first k even numbers
	 * from the stack. If there are less than k even elements in the stack,
	 * just remove all even elements. Do not use any loops or data structures
	 * other than the stack passed in as a parameter.
	 * @param stack
	 * @param k
	 * @return Returns the number of elements removed from the stack.
	 */
	public static int removeEvenNumbers(Stack<Integer> stack, int k) {
		
		// Base Case: Checking to see if the stack is not empty
		
		if (!stack.isEmpty()) {
			
			// Declaring variables
			
			int value = stack.pop();
			int count = 0;
			
			// Checking to see if the value is an even number and
			// The user requests that at least 1 even number be removed
			
			if (value % 2 == 0 && k > 0) {
				count++; k--;
			}
			
			// Recursing count, which indicates how many numbers were removed
			
			count += removeEvenNumbers(stack, k);
			
			// Returning count after recursing
			
			return count;
			
		}
		return 0;
	}

	/**
	 * Write a recursive function that accepts an integer and
	 * returns a new number containing only the even digits, in the same
	 * order. If there are no even digits, return 0. Your function should
	 * work for positive or negative numbers. You are NOT allowed
	 * to use any data structures. You are not allowed to use Strings to
	 * solve this problem either.
	 * @param n
	 * @return The input with only the even digits remaining in the same
	 * order.
	 */
	public static int evenDigits(int n) {
		
		// Checking if the given number is negative
		
		// If it is, we will recurse using the positive version of the number
		
		if (n < 0) {
			return evenDigits(-n);
		}
		
		// Base Case: If the number is 0, return 0.
		
		else if (n == 0) {
			return 0;
		}
		else {
			int getNums = evenDigits(n / 10);
			int value = n % 10;
			if (value % 2 == 0) {
				getNums *= 10;
				getNums += value;
			}
			return getNums;
		}
	}

	/**
	 * Write a recursive function that evaluates a Queue<Character> as a mathematical
	 * expression. This queue can have any of the following characters:
	 * { '(', ')', '+', '*'} or any single digit number. Evaluate this expression and
	 * return the result. For example, for the expression:
	 * "(((1+2)*(3+1))+(1*(2+2)))", each of these characters would be in the
	 * q. As you recursively evaluate characters from the expression, you will
	 * remove the characters from the q. After evaluating the above expression,
	 * you should return 16. You are guaranteed that there are NO two digit numbers,
	 * and that the expression is well formed (parenthesis match, etc...). Do not use any
	 * loops. Do not use any data structures besides the q passed in as a parameter.
	 * @param q
	 * @return The result of the mathematical expression.
	 */
	public static int evaluate(Queue<Character> q) {
		
		if (q.isEmpty()) {
			
			return 0;
		}
		
		char ch = q.remove();
		
		if (Character.isDigit(ch)) {
			
			int ans = Character.getNumericValue(ch);
			
			if (q.isEmpty()) {
				
				return ans;
				
			}
			
			ch = q.remove();
			
			if (ch == '+') {
				
				return ans + evaluate(q);
				
			}
			else if (ch == '*') {
				
				return ans * evaluate(q);
				
			}else {
				return ans;
			}
			
		}
		
		else {
			int ans = 0;
			
			if (ch == '(') {
				
				ans = evaluate(q);
				
			}
			
			if (!q.isEmpty()) {
				ch = q.remove();
				
				if (ch == '+') {
					
					return ans + evaluate(q);
					
				}
				else if (ch == '*') {
					
					return ans * evaluate(q);
					
				}else {
					return ans;
				}
		}
		
			return ans;
	}
		
	}

	/**
	 * Write a recursive function that accepts a stack of integers and
	 * replaces each int with two copies of that integer. For example,
	 * calling repeatStack and passing in a stack of { 1, 2, 3} would change
	 * the stack to hold { 1, 1, 2, 2, 3, 3}. Do not use any loops. Do not use
	 * any data structures other than the stack passed in as a parameter.
	 * @param stack
	 */
	public static void repeatStack(Stack<Integer> stack) {
		
		// Checking to see if the stack is full
		
		if (!stack.isEmpty()) {
			
			// Popping value off of the stack
			
			int value = stack.pop();
			
			// Recursing through, then pushing value on to the stack twice
			repeatStack(stack);
			
			stack.push(value);
			stack.push(value);
		}
		
	}
	

	/**
	 * Write a recursive function that accepts a Queue<Integer>. It
	 * should change every int in this queue to be double its original
	 * value. You may NOT use loops or any other data structures besides
	 * the queue passed in as a parameter. You may use a helper function.
	 * @param q
	 */
	public static void doubleElements(Queue<Integer> q) {
		
		doubleElementsHelper(q, q.size());
		
	}
	
	public static void doubleElementsHelper(Queue<Integer> q, int lengthOfStack) {
		
		// Base Case: Checking to see if the stack has elements in it
		
		if (lengthOfStack > 0) {
			
			// Removing value from stack and multiplying it by 2.
			
			int value = q.remove();
			q.add(value * 2);
			
			// Recursing, this time with a stack 1 element smaller.
			
			doubleElementsHelper(q, lengthOfStack - 1);
			
		}
		
	}

}
