// All good now, printing and comment all done

import java.util.Scanner;  // Import the Scanner class

class Counter{ // Class for counter
  int add = 0;
  int min = 0;
  int mod = 0;
  int ass = 0;
  int func = 0;
  int ret = 0;
  int arr = 0;
  int com = 0;
}

// Class of the algorithm
public class Ques2 {

    // Method overloading to slice character from string (not the last character)
    public static String slice(String s, int head, int tail, Counter val) {

        String sub = s.substring(head, tail);
        //COUNTER: 1 assign, 1 function call
        val.ass += 1;
        val.func += 1;

        //COUNTER: 1 function return
        val.ret += 1;
        return sub;
    }

    // Return the index which tells which bucket it belongs to
    public static int indexSearch(String s, Counter val) {

        // Convert String to character
        char c = s.charAt(0);
        //COUNTER: 1 assign, 1 function call
        val.ass += 1;
        val.func += 1;

        // Convert to index
        int ascii = (int)c - 96;
        //COUNTER: 1 assign, 1 minus
        val.ass += 1;
        val.min += 1;

        //COUNTER: 1 function return
        val.ret += 1;
        return ascii; 
    }

    // Method to print the array in a beautiful way
    // s: array, counter: at which nth pass we are, noOfElements: number of elements in the array, max: max length of the string
    public static void print(String[][] s, int counter, int noOfElements, int max) {

        // To prevent the printing from overflowing fromt he table (printing purpose)
        int limit = 0;

        // To print which round of passing is now
        int noOfAstricks = max - (counter % max);
        for (int i = 0; i < noOfAstricks; i++) {
            System.out.print("*");
        }
        System.out.println();

        // To print which pass is now
        System.out.println("Pass: " + (max - (counter % max)));
        for (int i = 0; i < 160; i++) {
            System.out.print("-");
        }

        // To print in a table format
        System.out.printf("%n|%-15s|%-87s|", "    Buckets  ", "\t\t\t\t\t\t\t\t  Elements");
        System.out.println();
        for (int i = 0; i < 160; i++) {
            System.out.print("-");
        }
        System.out.println();

        // To print out the array in a beautiful way
        // i stands for which bucket we wish to write
        for (int i = 0; i < 27; i++) {

            // Convert to ASCII character
            char ascii = (char) (i + 96); 
            System.out.printf("|\t%-8s|\t", ascii);

            // Print out the element inside the bucket (array)
            // k stands for columns (which bucket) we are at
            for (int k = 0; k < 27; k++) {

                // j stands for which row (which element in the bucket) we are writing
                for (int j = 0; j < noOfElements; j++) {

                    // Only write when we are at the right bucket which we are at the right bucket
                    if (k == i) {

                        // Make the printing to the next line if the element is printed too much
                        if (limit > 6) {
                            System.out.printf("\n|\t%-8s|\t", "");
                            limit = 0;
                        }

                        // To prevent showing the null value
                        if (s[j][k] != null) {
                            System.out.printf("%-2s %-15s", "·", s[j][k]);
                            limit++;
                        }
                    }
                }

                // To reset the printing for the next row
                limit = 0;
            }
            System.out.println();
        }

        // Just for formatting
        for (int i = 0; i < 160; i++) {
            System.out.print("-");
        }
        System.out.println("\n\n");
    }

    // Method to print the final result
    public static void FinalPrint(String[][] s) {

        // User friendly message
        System.out.println("Final Result after Radix sort: ");

        // To prevent over printing
        int length = (s.length*20);
        if (length >= 238) {
            length = 238;
        }

        // For formatting purpose
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();

        // To print the final result
        for (int i = 0; i < 27; i++) { 
            for (int j = 0; j < s.length; j++) {
                if (s[j][i] != null) {
                    System.out.printf("  ·  %-15s", s[j][i]);
                }
            }
        }
        System.out.println();

        // Just to print beautifully
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println("\n\n");
    }

    // To clear the array after printing before the next pass
    public static void clearArray(String[][] array, Counter val) {

        // clear the array1 for the next pass
        for (int j = 0; j < array.length; j++) { 
            //COUNTER: for loop (1 assign, 1 compare, 1 addition, 1 function call)
            val.ass += 1;
            val.com += 1;
            val.add += 1;
            val.func += 1;

            for (int i = 0; i < 27; i++) {
                //COUNTER: for loop (1 assign, 1 compare, 1 addition)
                val.ass += 1;
                val.com += 1;
                val.add += 1;
                array[j][i] = null;
                //COUNTER: 1 assign, 1 array lookup
                val.ass += 1;
                val.arr += 1;
            }
            //COUNTER: end loop (1 assign, 1 compare)
            val.ass += 1;
            val.com += 1;
        }
        //COUNTER: end loop (1 assign, 1 compare, 1 function call)
        val.ass += 1;
        val.com += 1;
        val.func += 1;
    }

    // To obtain the user input to sort it
    public static String[][] input(Counter val) {

        // To obtain the user input
        Scanner sc = new Scanner(System.in);
        
        // User friendly message
        System.out.print("Please enter the string: ");

        // To obtain the user input
        String input = sc.nextLine();

        // convert to lower case
        input = input.toLowerCase(); 
        //COUNTER: 1 assign
        //val.ass += 1;
        System.out.println();

        // To split the string into an array, user input will be seperated by spacing
        String[] inputed = input.split(" ");
        //COUNTER: 1 assign
        //val.ass += 1;
        String[][] array = new String[inputed.length][27];

        // Convert input into 2D-array
        for (int i = 0; i < inputed.length; i++) {
            //COUNTER: for loop (1 assign, 1 compare, 1 addition)
            /*val.ass += 1;
            val.com += 1;
            val.add += 1;*/
            for (int j = 0; j < 27; j++) {
                //COUNTER: for loop (1 assign, 1 compare, 1 addition)
                /*val.ass += 1;
                val.com += 1;
                val.add += 1;*/

                //COUNTER: if condition (1 compare)
                //val.com += 1;
                if (j == 0) {
                    array[i][j] = inputed[i];
                    //COUNTER: 2 array lookup, 1 assign
                    /*val.arr += 2;
                    val.ass += 1;*/
                }
            }
            //COUNTER: end loop (1 assign, 1 compare)
            /*val.ass += 1;
            val.com += 1;*/
        }
        //COUNTER: end loop (1 assign, 1 compare)
        /*val.ass += 1;
        val.com += 1;*/
        
        //COUNTER: 1 function return
        //val.ret += 1;
        return array;
    }

    // To count the longest element 
    public static int countMaxLength(String[][] s, Counter val) {

        // Initialization
        int max = 0, length;
        //COUNTER: 1 assign
        val.ass += 1;

        // To traverse through the array
        // i is row, j is column
        for (int i = 0; i < s.length; i++) {
            //COUNTER: for loop (1 assign, 1 compare, 1 addition, 1 function call)
            val.ass += 1;
            val.com += 1;
            val.add += 1;
            val.func += 1;
            for (int j = 0; j < 27; j++) {
                //COUNTER: for loop (1 assign, 1 compare, 1 addition)
                val.ass += 1;
                val.com += 1;
                val.add += 1;

                // Only count the row because it is not sorted yet the array passed to this method)
                //COUNTER: if condition (1 compare)
                val.com += 1;
                if (j == 0) {
                    length = s[i][j].length();
                    //COUNTER: 1 assign, 1 array lookup, 1 function call
                    val.ass += 1;
                    val.arr += 1;
                    val.func += 1;

                    //COUNTER: if condition (1 compare)
                    val.com += 1;
                    if (max < length) { 
                        max = length;
                        //COUNTER: 1 assign
                        val.ass += 1;
                    }
                }
            }
            //COUNTER: end loop (1 assign, 1 compare)
            val.ass += 1;
            val.com += 1;
        }
        //COUNTER: end loop (1 assign, 1 compare, 1 function call)
        val.ass += 1;
        val.com += 1;
        val.func += 1;

        // To return the maximum length of the string
        //COUNTER: 1 function return
        val.ret += 1;
        return max;
    }

    // Method to pass the array to sort it
    public static String[][] Pass(int counter, String[][] array1, int max, Counter val) {

        // To pass the array to another array to sort it
        String[][] array2 = new String[array1.length][27];
        // COUNTER: 1 function call, 1 assign, length*27 array lookup
        val.func += 1;
        val.ass += 1;
        val.arr += (array1.length*27);

        // To store the sliced string
        String sub;

        // To specified which bucket to be put into
        int index;

        // To trace the row
        int row = 0;
        //COUNTER: 1 assign
        val.ass += 1;

        // To specify the index of the array that we are tracing
        for (int j = 0; j < 27; j++) {
            //COUNTER: for loop (1 assign, 1 compare, 1 addition)
            val.ass += 1;
            val.com += 1;
            val.add += 1;

            // Trace array column by column
            for (int n = 0; n < 27; n++) {
                //COUNTER: for loop (1 assign, 1 compare, 1 addition)
                val.ass += 1;
                val.com += 1;
                val.add += 1;

                // Trace the array row by row
                for (int i = 0; i < array1.length; i++) {
                    //COUNTER: for loop (1 assign, 1 compare, 1 addition, 1 function call)
                    val.ass += 1;
                    val.com += 1;
                    val.add += 1;
                    val.func += 1;

                    // Only do opetarion if the element inside the bucket is not null
                    //COUNTER: if condition (1 array lookup, 1 compare)
                    val.arr += 1;
                    val.com += 1;
                    if (array1[i][n] != null) {

                        // To count the number of charcter in the string
                        int count = array1[i][n].length();
                        //COUNTER: 1 assign, 1 array lookup, 1 function call
                        val.ass += 1;
                        val.arr += 1;
                        val.func += 1;

                        // Enter if the string count(length) is lower than the counter(max length)
                        //COUNTER: if condition (1 minus, 1 compare)
                        val.min += 1;
                        val.com += 1;
                        if ((count - 1) >= counter) {
                            
                            //COUNTER: if conditon (1 compare)
                            val.com += 1;
                            if (counter < max) {

                                // To slice the string
                                sub = slice(array1[i][n], (counter), (counter + 1), val);
                                //COUNTER: 1 assign, 1 function call, 1 array lookup, 1 addition
                                val.ass += 1;
                                val.func += 1;
                                val.arr += 1;
                                val.add += 1;

                                // To obtain the index
                                index = indexSearch(sub, val);
                                //COUNTER: 1 function call, 1 assign
                                val.func += 1;
                                val.ass += 1;

                                // Sort the item into the right bucket when transfering it to another array
                                //COUNTER: if condition (1 compare)
                                val.com += 1;
                                if (index == j) {
                                    array2[row][index] = array1[i][n];
                                    row++;
                                    //COUNTER: 2 array lookup, 2 assign, 1 addition
                                    val.arr += 2;
                                    val.ass += 2;
                                    val.add += 1;
                                }
                            }

                        // Enter when the string length of the particular element is shorter than the counter (the max length)
                        } else {

                            // Assign an empty bin into the array
                            sub = "`";
                            //COUNTER: 1 assign
                            val.ass += 1;
                            index = indexSearch(sub, val);
                            //COUNTER: 1 function call
                            val.func += 1;

                            // Sort the item into the right bucket when transfering it to another array
                            //COUNTER: if condition (1 compare)
                            val.com += 1;
                            if (index == j) {
                                array2[row][index] = array1[i][n];
                                row++;
                                //COUNTER: 2 array lookup, 2 assign, 1 addition
                                val.arr += 2;
                                val.ass += 2;
                                val.add += 1;
                            }
                        }
                    } else {
                        continue;
                    }
                }
                //COUNTER: end loop (1 assign, 1 compare, 1 function call)
                val.ass += 1;
                val.com += 1;
                val.func += 1;
            }
            //COUNTER: end loop (1 assign, 1 compare)
            val.ass += 1;
            val.com += 1;

            // Reset the row to 0 so that the next column can insert start from the first row
            row = 0;
            //COUNTER: 1 assign
            val.ass += 1;
        }
        //COUNTER: end loop (1 assign, 1 compare)
        val.ass += 1;
        val.com += 1;

        // Print out the passing process
        print(array2, counter, array1.length, max);

        // Clear the array after printing before the next pass
        //COUNTER: 1 function call
        val.func += 1;
        clearArray(array1, val);

        //COUNTER: 1 function return
        val.ret += 1;
        return array2;
    }

    // Method to pass the array to the final to know the final result
    public static String[][] getFinal (String[][] s, int length, Counter val) {

        // Pass the array to a final array to print out the final result
        String Final[][] = new String[length][27];
        // COUNTER: 1 assign, length*27 array lookup
        val.ass += 1;
        val.arr += (length*27);

        for (int j = 0; j < length; j++) {
            //COUNTER: for loop (1 assign, 1 compare, 1 addition)
            val.ass += 1;
            val.com += 1;
            val.add += 1;

            for (int k = 0; k < 27; k++) {
                //COUNTER: for loop (1 assign, 1 compare, 1 addition)
                val.ass += 1;
                val.com += 1;
                val.add += 1;

                Final[j][k] = s[j][k];
                //COUNTER: 1 assign, 2 array lookup
                val.ass += 1;
                val.arr += 2;
            }
            //COUNTER: end loop (1 assign, 1 compare)
            val.ass += 1;
            val.com += 1;
        }
        //COUNTER: end loop (1 assign, 1 compare)
        val.ass += 1;
        val.com += 1;

        val.ret += 1;
        return Final;
    }

    // Main method to run the program
    public static void main(String args[]) {

        Counter counter = new Counter();
        // Initialize the needed arrays (2D-array)
        String initialize[][] = input(counter);
        //COUNTER: 1 function call and 1 assign
        /*counter.ass += 1;
        counter.func += 1;*/
        String array1[][] = new String[initialize.length][27];
        // COUNTER: 1 function call, 1 assign, length*27 array lookup
        counter.func += 1;
        counter.ass += 1;
        counter.arr += (initialize.length*27);
        String array2[][] = new String[initialize.length][27];
        // COUNTER: 1 function call, 1 assign, length*27 array lookup
        counter.func += 1;
        counter.ass += 1;
        counter.arr += (initialize.length*27);
        String Final[][] = new String[initialize.length][27];
        // COUNTER: 1 function call, 1 assign, length*27 array lookup
        counter.func += 1;
        counter.ass += 1;
        counter.arr += (initialize.length*27);

        // Variable to store the max length of the elements in the array
        int max;

        // To count the max length of the string in the array
        max = countMaxLength(initialize, counter);
        //COUNTER: 1 function call and 1 assign
        counter.ass += 1;
        counter.func += 1;

        // To pass the array from one to another to sort it
        // Start from the last character to the first character (Obeying radix sort)
        // i is the counter to count the number (awhich character we are accessing) of passes and decrementing the counter
        //COUNTER: for loop initialization (1 minus, 1 assign)
        counter.min += 1;
        counter.ass += 1;
        for (int i = max - 1; i >= 0; i--) {
            //COUNTER: for loop (1 compare, 1 minus, 1 assign)
            counter.com += 1;
            counter.min += 1;
            counter.ass += 1;
            
            //COUNTER: if condition (1 minus, 1 compare)
            counter.min += 1;
            counter.com += 1;
            // If it is not the first pass
            if (i < max - 1) {

                // The passing of array varies depending on the maximum length
                // If the longest length of element in the array is odd
                //COUNTER: if condition (1 compare, 1 modulus)
                counter.com += 1;
                counter.mod += 1;
                if (max % 2 != 0) {

                    // If the counter (passing round) is even
                    //COUNTER: if condition (1 compare, 1 modulus)
                    counter.com += 1;
                    counter.mod += 1;
                    if (i % 2 == 0) {

                        // To pass the array to another array to sort it
                        array1 = Pass(i, array2, max, counter);
                        //COUNTER: 1 function call and 1 assign
                        counter.func += 1;
                        counter.ass += 1;

                        // To transfer the array to the final array to track the final result
                        Final = getFinal(array1, initialize.length, counter);
                        //COUNTER: 2 function call, 1 assign
                        counter.func += 2;
                        counter.ass += 1;
                    } 
                    
                    // If the counter (passing round) is odd
                    else {
                        // To pass the array to another array to sort it
                        array2 = Pass(i, array1, max, counter);
                        //COUNTER: 1 function call and 1 assign
                        counter.func += 1;
                        counter.ass += 1;

                        // To transfer the array to the final array to track the final result
                        Final = getFinal(array2, initialize.length, counter);
                        //COUNTER: 2 function call, 1 assign
                        counter.func += 2;
                        counter.ass += 1;
                    }
                }

                // If the longest length of element in the array is even
                else {

                    // If the counter (passing round) is odd
                    //COUNTER: if condition (1 compare, 1 modulus)
                    counter.com += 1;
                    counter.mod += 1;
                    if (i % 2 != 0) {

                        // To pass the array to another array to sort it
                        array1 = Pass(i, array2, max, counter);
                        //COUNTER: 1 function call and 1 assign
                        counter.func += 1;
                        counter.ass += 1;

                        // To transfer the array to the final array to track the final result
                        Final = getFinal(array1, initialize.length, counter);
                        //COUNTER: 2 function call, 1 assign
                        counter.func += 2;
                        counter.ass += 1;
                    } 
                    
                    // // If the counter (passing round) is even
                    else {

                        // To pass the array to another array to sort it
                        array2 = Pass(i, array1, max, counter);
                        //COUNTER: 1 function call and 1 assign
                        counter.func += 1;
                        counter.ass += 1;

                        // To transfer the array to the final array to track the final result
                        Final = getFinal(array2, initialize.length, counter);
                        //COUNTER: 2 function call, 1 assign
                        counter.func += 2;
                        counter.ass += 1;
                    }
                }

            // Enter if it is the first pass (last character)
            //COUNTER: if condition (1 compare, 1 minus)
            counter.com += 1;
            counter.min += 1;
            } else if (i == max - 1) {

                // To pass the initialize array to another array to sort it
                array1 = Pass(i, initialize, max, counter);
                //COUNTER: 1 function call and 1 assign
                counter.func += 1;
                counter.ass += 1;
            }
        }
        //COUNTER: end loop (1 compare)
        counter.com += 1;

        // Print out the final result
        FinalPrint(Final);
        System.out.println("Number of addtion operation = " + counter.add);
        System.out.println("Number of minus operation = " + counter.min);
        System.out.println("Number of modulus operation = " + counter.mod);
        System.out.println("Number of assignment operation = " + counter.ass);
        System.out.println("Number of function call operation = " + counter.func);
        System.out.println("Number of function return operation = " + counter.ret);
        System.out.println("Number of array lookup operation = " + counter.arr);
        System.out.println("Number of comparison operation = " + counter.com);
        System.out.println("Total number of primitive operation = " + (counter.add+counter.min+counter.mod+counter.ass+counter.func+counter.ret+counter.arr+counter.com));
    }
}