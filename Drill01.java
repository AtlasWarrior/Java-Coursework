/*
 * You will test these functions just like you ran your code for drill00.
 * Right-click on either the 'RunTests.java' file, or the 'Drill01TestClass.java'
 * file in your 'Package Explorer' sidebar on the left. It will provide many options, go
 * to the line that says 'Run As', then choose 'JUnit Test'. In your left sidebar, you
 * should see another tab 'JUnit' with your test results like we saw in class.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Drill01 {
	
	/* -------- Arrays -------- */
	
	/*
	 * Return the item at the index specified by the 
	 * parameter 'index'. Only do this if 'index' exists
	 * in your array. i.e. first check to make sure the
	 * array is big enough to contain such an index. If
	 * the array does not contain this index, return -1.
	 */
	static int getElementAtIndex(int index, int[] array) {
		if (array.length < index)
			return -1;
		else
			return array[index];
	}
	
	/*
	 * Return the sum of all the values in the given array.
	 */
	static int sumValues(int[] array) {
		int sum = 0;
		for (int arrayvalue : array) {
			sum += arrayvalue;
		}
		return sum;
	}
	
	/*
	 * Return a new array that doubles every element in the 
	 * given array.
	 */
	static int[] doubleElements(int[] array) {
		// TODO: Implement the doubleElements method
		return null;
	}
	
	/* -------- Lists -------- */
	
	/*
	 * Return the item at the index specified by the 
	 * parameter 'index'. Only do this if 'index' exists
	 * in your list. i.e. first check to make sure the
	 * list is big enough to contain such an index. If
	 * the list does not contain this index, return -1.
	 */
	static int getElementAtIndex(int index, List<Integer> list) {
		// TODO: Implement the getElementAtIndex method
		return -1;
	}
	
	/*
	 * Return the sum of all the values in the given list.
	 */
	static int sumValues(List<Integer> list) {
		// TODO: Implement the sumValues method
		return -1;
	}
	
	/*
	 * Return a new list that doubles every element in the 
	 * given list.
	 */
	static List<Integer> doubleElements(List<Integer> list) {
		// TODO: Implement the doubleElements method
		return new ArrayList<>();
	}

	/* -------- Sets -------- */
	
	/*
	 * Return whether the given set contains the given value.
	 */
	static boolean setContains(Set<Integer> set, int val) {
		// TODO: Implement the setContains method
		return false;
	}
	
	/*
	 * Return a new set containing the intersection 
	 * (common elements) of the given sets.
	 */
	static Set<Integer> setIntersection(Set<Integer> set1, Set<Integer> set2) {
		// TODO: Implement the setIntersection method
		return new HashSet<>();
	}
	
	/*  -------- HashMaps -------- */
	
	/*
	 * Given a string, return a map with each character as 
	 * a key and the number of times that character appears 
	 * in the string as the value.
	 */
	static Map<Character, Integer> characterCount(String s) {
		// TODO: Implement the characterCount method
		return new HashMap<>();
	}
	
	/*
	 * Given a mapping of cities to their population, return the city
	 * with the largest population. If the given map is empty, return 
	 * an empty string.
	 */
	static String largestPopulation(Map<String, Integer> cities) {
		// TODO: Implement the largestPopulation method
		return "";
	}

}
