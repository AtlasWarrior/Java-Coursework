import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Drill02 {
	
	/* -------- Stacks/Queues -------- */
 
	/*
	 * Given a stack as input, return a stack that has the same
	 * values, but in reverse order.
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
	static Stack<Integer> reverseStack(Stack<Integer> in) {
		
		Stack<Integer> stackNew = new Stack<Integer>();
		
		while (!in.empty()) {
			stackNew.push(in.peek());
			in.pop();
		}
		
		return stackNew;
		
	}

	/*
	 * Given a queue, return a new queue that has the same values in
	 * reverse order.
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
	static Queue<Integer> reverseQueue(Queue<Integer> in) {
		
		Stack<Integer> pushToStack = new Stack<Integer>();
		
		Queue<Integer> newQueue = new LinkedList<Integer>();	
		
		while (!in.isEmpty()) {
			pushToStack.push(in.peek());
			in.remove();
		}
		
		while (!pushToStack.empty()) {
			newQueue.add(pushToStack.pop());
		}
		
		
		return newQueue;
	}
	
	
	/* -------- Recursion -------- */

	/*
	 * Takes a number of characters to print as a parameter and returns
	 * a String with one or two asterisks in the middle surrounded by
	 * alligators.
	 * See the file included in this project: drill02-README.md
	 * Remember you can always view the testcases in this project for
	 * expected results.
	 */
    public static String zigzag(int n) {
    	
    	if (n == 1)
    		return "*";
    	else if (n == 2)
    		return "**";
    	else {
    		String str = "<";
    		str += zigzag(n-2);
    		return str + ">";
    	}
    				
    	
    }

    /*
     * Takes a String and a character as parameters and returns
     * the string with all copies of the character moved to the end
     * and capitalized.
     * See the file included in this proejct: drill02-README.md
     * Remember you can always view the testcases in this project for
	 * expected results.
     */
    public static String moveToEnd(String s, char c) {
    	
    	if (s.length() == 0)
    		return "";
    		
    	if (s.charAt(0) == c) {
    		s = s.substring(1);
    		s = s + Character.toUpperCase(c);
    		}
    	
    	return s.charAt(0) + moveToEnd(s.substring(1), c);
    	
    	
    	
    }

}
