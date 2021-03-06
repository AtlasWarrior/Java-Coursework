
public class Drill03 {

	/*
	 * Takes a string and two characters as parameters.
	 * Returns a string that is the same as the passed in string
	 * except that all occurrences of the first character are replaced
	 * with the second.
	 * You must use recursion to solve this problem.
	 */
	public static String replaceAll(String s, char from, char to) {
		if(s.isEmpty()) {
			return "";
	        }
		else {
			char firstCharacter = s.charAt(0);
			if(firstCharacter == from){
				firstCharacter = to;
	        }
	            return firstCharacter + replaceAll(s.substring(1,s.length()), from, to);
	        }
	    }
		

	/*
	 * Takes an integer as a parameter.
	 * Returns true if the digits are in sorted order ascending.
	 * Returns false otherwise.
	 * You must use recursion to solve this problem.
	 */
	public static boolean digitsSorted(int x) {
		
		if (x < 0) {
			x = -x;
		}
		
		if (x == 0) {
			return true;
		}
		
		else {
			int last = x % 10;
			
			x = x / 10;
			
			int secondLast = x % 10;
			
			if (secondLast > last) {
				return false;
			}
			else {
				return digitsSorted(x);
			}
		}
		
	}

	/*
	 * Write a recursive function which returns the input string
	 * but with adjacent duplicate char- acters removed. Do not use
	 * any String functions other than .charAt(), .length(), .isEmpty()
	 * and .substring(). Do not use any loops. We recommend you use a
	 * helper function so we have provided the helper function header
	 * below
	 * You must use recursion to solve this problem.
	 */
	public static String removeAdjacentDuplicateChars(String s) {
		
		if (s.length() <= 1) {
			return s;
		}
		if (s.charAt(0) == s.charAt(1)) {
			return removeAdjacentDuplicateChars(s.substring(1));
			
		}
		else {
			return s.charAt(0) + removeAdjacentDuplicateChars(s.substring(1));
		}
		
	}
	// Note that the helper function is 'private' since no other code
	// outside of this file needs to call this method.
	private static String removeHelper(String s, int index) {
		return "";
	}

	/*
	 * Write a recursive function that returns the number of occurrences
	 * of an integer ???n??? inside of an array of integers. You may not use
	 * loops or any array functions. You may use array.length to determine
	 * the length of the array. We recommend you use a helper similar to the
	 * one above. It would be useful if your helper function kept track of
	 * which index in the array you are currently checking.
	 * You must use recursion to solve this problem.
	 */
	public static int countOccurrences(int[] arr, int n) {
		
		return 0;
	

	}

}
