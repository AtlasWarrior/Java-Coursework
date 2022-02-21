/* 
 * AUTHOR: Benjamin Nylen
 * FILE: WordSearch.java
 * ASSIGNMENT: PA1 - WordSearch
 * COURSE: CSc 210; Section 01; Spring 2022
 * PURPOSE: This program reads in two different text files as
 * arguments, one being a dictionary of words and the second being
 * a wordsearch board. The dictionary text file must contain only one
 * word per line. For the grid file, the first two lines must specify
 * the amount of rows, followed by the amount of columns on the board.
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class WordSearch {

    private static final int MIN_WORD_LENGTH = 3;

    public static void main(String[] args) throws FileNotFoundException {

        // Read in dictionary file using a scanner (args[0])

        Scanner dictionaryFile = new Scanner(new File(args[0]));

        // Create HashSet of strings containing all words from dictionary

        Set<String> wordSet = new HashSet<String>();

        // While loop to add words

        while (dictionaryFile.hasNext()) {
            wordSet.add(dictionaryFile.nextLine());
        }

        // Read grid file in similar to how dictionary file is read

        Scanner gridFile = new Scanner(new File(args[1]));

        // Reading first digit in gridfile

        int length = Integer.parseInt(gridFile.nextLine());

        // Reading 2nd digit in gridfile

        int width = Integer.parseInt(gridFile.nextLine());

        // Create ArrayList of found words

        List<String> foundWords = new ArrayList<String>();

        // Function calls to create 2D array, and check for words

        String[][] grid = readGridFile(gridFile, length, width);
        checkLeftRight(grid, wordSet, foundWords);
        checkRightLeft(grid, wordSet, foundWords, width);
        checkUpDown(grid, wordSet, foundWords, length);
        checkDownUp(grid, wordSet, foundWords, width);

        // Printing out all found words

        for (String word : foundWords)
            System.out.println(word);

    }

    /*
     * A method which takes in the inputted gridfile as a parameter,
     * and creates a grid of strings containing each character from
     * the board.
     * 
     * @param gridFile, is the file containing the word search board.
     * 
     * @param length, is the amount of columns on the board
     * 
     * @param width, is the amount of rows on the board
     * 
     * @return grid, which is a 2D array containing all characters
     * located on the word search board.
     */
    private static String[][] readGridFile(Scanner gridFile, int length,
            int width) {

        // Create an array of characters to represent a single row on the board

        String[] letters = new String[width];

        // Instantiating the creation of the 2D array

        String[][] grid = new String[length][width];

        // Creating index, which will be used to place each character in the
        // right place

        int index = 0;

        // Looping through each line in grid file
        while (gridFile.hasNext()) {
            // Creating a variable to hold the entirety of the line in a string
            String line = gridFile.nextLine();
            // Splitting the created string into an array of characters
            letters = line.split(" ");
            // Using a for loop bounded by the length of the row to add
            // to the grid.
            for (int i = 0; i < letters.length; i++) {
                grid[index][i] = letters[i];
                }
            index += 1;
        }

        return grid;
    }

    // To check in opposite directions from normal, create a method that
    // flips the entirety of the grid, and then call checkLeftRight

    /*
     * This is a method that is utilized to check left to right
     * on the board for a word and add it to the ArrayList of
     * found words.
     * 
     * @param grid, which is a 2D array containing all characters
     * located on the word search board.
     * 
     * @param wordSet, is a HashSet which contains every word from
     * the inputted dictionary file.
     * 
     * @param foundWords, is an ArrayList containing all valid words
     * found within the word search board.
     */

    private static void checkLeftRight(String[][] grid, Set<String> wordSet,
            List<String> foundWords) {

        // Creating isWord which will be used to determine if word should
        // be added to foundWords.
        boolean isWord;

        // Grabs the initial row that is being searched for
        for (int i = 0; i < grid.length; i++) {
            // Grabs the letters used to search for a word
            for (int j = 0; j < grid[i].length; j++) {
                // Creating a blank string to be added to
                String wordCreate = "";
                // Holds spot so that we are able to check for words in a
                // factorial
                // type way.
                for (int k = j; k < grid[i].length; k++) {
                    // Holds the row for searching, while grabbing letters
                    // ahead of the initial letter
                    String startLetter = grid[i][k];
                    // Adding to the blank string
                    wordCreate += startLetter;
                if (wordCreate.length() >= MIN_WORD_LENGTH) {
                    // Checking if word is greater than min length
                    isWord = checkForWord(wordCreate, grid, wordSet);
                    // method call to check if word is valid, should return
                    // boolean
                    if (isWord)
                        foundWords.add(wordCreate);
                }
            }

            }
        }
    }

    /*
     * This is a method that is utilized to check right to left
     * on the board for a word and add it to the ArrayList of
     * found words.
     * 
     * @param grid, which is a 2D array containing all characters
     * located on the word search board.
     * 
     * @param wordSet, is a HashSet which contains every word from
     * the inputted dictionary file.
     * 
     * @param foundWords, is an ArrayList containing all valid words
     * found within the word search board.
     */

    private static void checkRightLeft(String[][] grid, Set<String> wordSet,
            List<String> foundWords, int width) {
        boolean isWord;
        String reverse;
        //

        // Grabs the initial row that is being searched for
        for (int i = 0; i < grid.length; i++) {
            // Grabs the letters used to search for a word
            for (int j = grid[i].length - 1; j >= 0; j--) {
                // Creating a blank string to be added to
                String wordCreate = "";
                // Holds spot so that we are able to check for words in a
                // factorial
                // type way.
                for (int k = j; k >= 0; k--) {
                    // Holds the row for searching, while grabbing letters
                    // ahead of the initial letter
                    String startLetter = grid[i][k];
                    // Adding to the blank string
                    wordCreate += startLetter;
                    // Checking if word is greater than min length
                    if (wordCreate.length() >= MIN_WORD_LENGTH) {
                        isWord = checkForWord(wordCreate, grid, wordSet);
                        if (isWord)
                            foundWords.add(wordCreate);
                    }

                    }
                }
            }

            }

        /*
         * This is a method that is utilized to check up to down
         * on the board for a word and add it to the ArrayList of
         * found words.
         * 
         * @param grid, which is a 2D array containing all characters
         * located on the word search board.
         * 
         * @param wordSet, is a HashSet which contains every word from
         * the inputted dictionary file.
         * 
         * @param foundWords, is an ArrayList containing all valid words
         * found within the word search board.
         */

    private static void checkUpDown(String[][] grid, Set<String> wordSet,
            List<String> foundWords, int length) {
        boolean isWord;
        // Grabs the initial row that is being searched for
        for (int i = 0; i < length; i++) { // previously grid.length
            // Grabs the letters used to search for a word
            for (int j = 0; j < grid[i].length - 1; j++) { // previously
                                       // grid[i].length - 1
                String wordCreate = "";
                for (int k = j; k < length; k++) {
                    String startLetter = grid[k][i];
                    wordCreate += startLetter;
                    if (wordCreate.length() >= MIN_WORD_LENGTH) {
                        isWord = checkForWord(wordCreate, grid, wordSet);
                        if (isWord)
                            foundWords.add(wordCreate);
                    }
                }

            }
        }
    }


    /*
     * This is a method that is utilized to check down to up
     * on the board for a word and add it to the ArrayList of
     * found words.
     * 
     * @param grid, which is a 2D array containing all characters
     * located on the word search board.
     * 
     * @param wordSet, is a HashSet which contains every word from
     * the inputted dictionary file.
     * 
     * @param foundWords, is an ArrayList containing all valid words
     * found within the word search board.
     */

    private static void checkDownUp(String[][] grid, Set<String> wordSet,
            List<String> foundWords, int width) {
        boolean isWord;

        String reverse;
        // Grabs the initial row that is being searched for
        for (int i = 0; i < width; i++) {
            // Grabs the letters used to search for a word
            // for (int j = grid[i].length - 1; j >= 0; j--) { // previously
            // grid[i].length -
            for (int j = grid.length - 1; j >= 0; j--) { // 1
                String wordCreate = "";
                for (int k = j; k < grid.length; k++) {
                    String startLetter = grid[k][i];
                    wordCreate += startLetter;
                    if (wordCreate.length() >= MIN_WORD_LENGTH) {
                        isWord = checkForWord(wordCreate, grid, wordSet);
                        if (isWord)
                            foundWords.add(wordCreate);
                    }
                }
            }

            }
        }

    /*
     * A method that is utilized to check if a given string within
     * the word search board is a valid word by looking through
     * the HashSet of all words from the dictionary file. If the
     * word is found to be in the dictionary, this function will
     * return a boolean (true) to the method it was called from
     * so that the method knows to add the word to the found words
     * data structure. If the word is not found, the method returns
     * false.
     * 
     * @param word, is a string given to the method from the other
     * check functions.
     * 
     * @param grid,which is a 2D array containing all characters
     * located on the word search board.
     * 
     * @param wordSet, is a HashSet which contains every word from
     * the inputted dictionary file.
     */

    private static boolean checkForWord(String word, String[][] grid,
            Set<String> wordSet) {
        for (String element : wordSet) {
            if (word.toLowerCase().equals(element.toLowerCase()))
                return true;
        }
        return false;

    }

}

