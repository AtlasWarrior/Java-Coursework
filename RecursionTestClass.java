/*
 * This file will hold all of your testcases. Remember, to run all
 * of your tests, right-click on 'RunTests.java' and select 'Run As' ->
 * JUnit Test.
 */
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

public class RecursionTestClass {
	
	/*
	 * Here I have provided an example of one of the tests that I
	 * would write. For each of your tests, leave a brief comment
	 * above the test specifying its purpose. For example, for this
	 * test, I might write, "indexOf_test1 tests when s2 is not a 
	 * substring of s1. This should return -1."
	 */
    @Test
    public void test_indexOf_test1() {
        int result = Recursion.indexOf("Hello", "World");
        System.out.println("indexOf(Hello, World), got " + result);
        assertEquals(-1, result);
    }
    
    /*
     * indexOf_test2 tests when s2 is actually located within s1. 
     * This should return 1.
     */
    @Test
    public void test_indexOf_test2() {
        int result = Recursion.indexOf("Hello", "ell");
        System.out.println("indexOf(Hello, ell), got " + result);
        assertEquals(1, result);
    }
    
    /*
     * indexOf_test3 checks to see when s1 is exactly equal to s2.
     * This should return 0.
     */
    @Test
    public void test_indexOf_test3() {
        int result = Recursion.indexOf("Hello", "Hello");
        System.out.println("indexOf(Hello, Hello), got " + result);
        assertEquals(0, result);
    }
  
    
    /*
     * test_evaluate_1 tests a general input that the program may see.
     * This input has multiple open and close parentheses, along with
     * addition and multiplication symbols. This should return 16
     */
    @Test
    public void test_evaluate_1() {
        Queue<Character> stack = new LinkedList<Character>();
        stack.add('(');
        stack.add('(');
        stack.add('(');
        stack.add('1');
        stack.add('+');
        stack.add('2');
        stack.add(')');
        stack.add('*');
        stack.add('(');
        stack.add('3');
        stack.add('+');
        stack.add('1');
        stack.add(')');
        stack.add(')');
        stack.add('+');
        stack.add('(');
        stack.add('1');
        stack.add('*');
        stack.add('(');
        stack.add('2');
        stack.add('+');
        stack.add('2');
        stack.add(')');
        stack.add(')');
        stack.add(')');
        int ans = Recursion.evaluate(stack);
        System.out.println("Running Evaluate got: " + ans);
        assertEquals(16, ans);
    }
    
    /*
     * test_evaluate_3 tests when the input is a singular digit.
     * This should return 2.
     */
    @Test
    public void test_evaluate_2() {
        Queue<Character> stack = new LinkedList<Character>();
        stack.add('2');
        int ans = Recursion.evaluate(stack);
        System.out.println("Running Evaluate got: " + ans);
        assertEquals(2, ans);
    }
    
    /*
     * test_evaluate_3 tests the case where there is nothing in the stack.
     * This should return 0.
     */
    @Test
    public void test_evaluate_3() {
        Queue<Character> stack = new LinkedList<Character>();
        int ans = Recursion.evaluate(stack);
        System.out.println("Running Evaluate got: " + ans);
        assertEquals(0, ans);
    }
    
    /*
     * test_evaluate_4 tests a smaller case similar to test 1 as a
     * simple sanity check. This should return 3.
     * 
     */
    @Test
    public void test_evaluate_4() {
        Queue<Character> stack = new LinkedList<Character>();
        stack.add('(');
        stack.add('1');
        stack.add('+');
        stack.add('2');
        stack.add(')');
        int ans = Recursion.evaluate(stack);
        System.out.println("Running Evaluate got: " + ans);
        assertEquals(3, ans);
    }
    
    /*
     * test_evaluate_5 tests the case where larger numbers are being multiplied.
     * This should return 1620.
     */
    @Test
    public void test_evaluate_5() {
        Queue<Character> stack = new LinkedList<Character>();
        stack.add('(');
        stack.add('9');
        stack.add('*');
        stack.add('9');
        stack.add(')');
        stack.add('*');
        stack.add('(');
        stack.add('4');
        stack.add('*');
        stack.add('5');
        stack.add(')');
        int ans = Recursion.evaluate(stack);
        System.out.println("Running Evaluate got: " + ans);
        assertEquals(1620, ans);
    }
    
    /*
     * test_evaluate_6 tests a rather odd case where a large number of
     * open and close parentheses surround a singular digit.
     * This should return 6.
     */
    @Test
    public void test_evaluate_6() {
        Queue<Character> stack = new LinkedList<Character>();
        stack.add('(');
        stack.add('(');
        stack.add('(');
        stack.add('(');
        stack.add('(');
        stack.add('6');
        stack.add(')');
        stack.add(')');
        stack.add(')');
        stack.add(')');
        stack.add(')');
        int ans = Recursion.evaluate(stack);
        System.out.println("Running Evaluate got: " + ans);
        assertEquals(6, ans);
    }
    
    
    /*
     * test_removeEvenNumbers_1 tests the case where all
     * numbers in the stack are even and are set to be removed.
     * This should return 4.
     */
    @Test
    public void test_removeEvenNumbers_1() {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	stack.push(2);
    	stack.push(2);
    	stack.push(2);
    	stack.push(2);
    	
    	int ans = Recursion.removeEvenNumbers(stack, 5);
    	
    	assertEquals(4, ans);
    	
    }
    
    /*
     * test_removeEvenNumbers_2 tests the case where some
     * numbers in the stack are even and only a certain amount are removed.
     * This should return 2.
     */
    @Test
    public void test_removeEvenNumbers_2() {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.push(4);
    	stack.push(5);
    	stack.push(6);
    	stack.push(7);
    	stack.push(8);
    	
    	int ans = Recursion.removeEvenNumbers(stack, 2);
    	
    	System.out.println("Removed " + ans + " even numbers");
    	
    	assertEquals(2, ans);
    	
    }
    
    /*
     * test_removeEvenNumbers_3 tests the case where all
     * numbers in the stack are odd and there are more than 0 numbers
     * requested to be removed.
     * This should return 0.
     */
    
    @Test
    public void test_removeEvenNumbers_3() {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	
    	int ans = Recursion.removeEvenNumbers(stack, 2);
    	
    	System.out.println("Removed " + ans + " even numbers");
    	
    	assertEquals(0, ans);
    	
    }
    
    /*
     * test_evenDigits_1 tests the case where the inputted number
     * is negative. This should return 68.
     */
    @Test
    public void test_evenDigits_1() {
    	int num = -3695938;
    	
    	int ans = Recursion.evenDigits(num);
    	
    	System.out.println("Number before: " + num);
    	System.out.println("Number after: " + ans);
    	
    	assertEquals(68, ans);
    }
    
    /*
     * test_evenDigits_1 tests the case where the inputted number
     * consists of all even numbers and must return the same inputted value. 
     * This should return 246802468.
     */
    @Test
    public void test_evenDigits_2() {
    	int num = 246802468;
    	
    	int ans = Recursion.evenDigits(num);
    	
    	System.out.println("Number before: " + num);
    	System.out.println("Number after: " + ans);
    	
    	assertEquals(246802468, ans);
    }
    
    /*
     * test_repeatStack_1 tests the case where all values are different.
     * This should return [1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8]
     */
    @Test
    public void test_repeatStack_1() {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	stack.push(1);
    	stack.push(2);
    	stack.push(3);
    	stack.push(4);
    	stack.push(5);
    	stack.push(6);
    	stack.push(7);
    	stack.push(8);
    	
    	System.out.println("Stack before: " + stack);
    	
    	Recursion.repeatStack(stack);
    	
    	System.out.println("Stack after: " + stack);
    	
    	
    }
    
    /*
     * test_repeatStack_2 is a sanity test where all values in the stack
     * are similar. 
     * This should return [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
     */
    @Test
    public void test_repeatStack_2() {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	stack.push(1);
    	
    	System.out.println("Stack before: " + stack);
    	
    	Recursion.repeatStack(stack);
    	
    	System.out.println("Stack after: " + stack);
    }
    
    /*
     * test_repeatStack_4 tests the case where the stack is completely
     * empty. This should return [].
     */
    @Test
    public void test_repeatStack_4() {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	System.out.println("Stack before: " + stack);
    	
    	Recursion.repeatStack(stack);
    	
    	System.out.println("Stack after: " + stack);
    	
    	
    }
    
    /*
     * test_doubleElements_1 tests a rather normal input where all values
     * are positive numbers and will be doubled.
     * This should return [4,8,12,16]
     */
    @Test
    public void test_doubleElements_1() {
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	q.add(2);
    	q.add(4);
    	q.add(6);
    	q.add(8);
    	
    	System.out.println("Queue before: " + q);
    	
    	Recursion.doubleElements(q);
    	
    	System.out.println("Queue after: " + q);
    	
    	
    }
    
    /*
     * test_doubleElements_2 tests a case where the inputted stack
     * is completely empty. This should return [].
     */
    @Test
    public void test_doubleElements_2() {
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	    	
    	System.out.println("Queue before: " + q);
    	
    	Recursion.doubleElements(q);
    	
    	System.out.println("Queue after: " + q);
    	
    	
    }
    
    /*
     * test_doubleElements_3 tests a case where all values added into
     * the stack are negative. This should return [1,4,9,16].
     */
    @Test
    public void test_doubleElements_3() {
    	
    	Queue<Integer> q = new LinkedList<Integer>();
    	
    	q.add(-1);
    	q.add(-2);
    	q.add(-3);
    	q.add(-4);
    	
    	System.out.println("Queue before: " + q);
    	
    	Recursion.doubleElements(q);
    	
    	System.out.println("Queue after: " + q);
    	
    	
    }
      
}
