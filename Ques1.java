//format, printing, comment done

import java.util.Scanner; //import Scanner class

class Counter{ // Class for counter
  int add = 0; //addtion
  int mul = 0; //multiplication
  int div = 0; //division
  int mod = 0; //modulus
  int ass = 0; //assignment
  int func = 0; //function call
  int arr = 0; //array lookup
  int com = 0; //compare
}

//class of algorithm
public class Ques1 {

  // method to print the array in a beautiful way
  // to showcase how the element is sorted pass by pass
  // arr: array, numOfPass: at which nth pass we are
  public static void printPass(Integer[][] arr, int numOfPass) {
    System.out.println();
    System.out.println();
    System.out.println();

    // To prevent the printing from overflowing from the table (printing purpose)
    int limit = 0; 

    // To print which round of passing is now
    for (int i = 0; i < numOfPass; i++) {
      System.out.print("*");
    }
    System.out.println();

    // To print which pass is now
    System.out.println("Pass: " + numOfPass);
    for (int i = 0; i < 160; i++) {
      System.out.print("-");
    }

    //Print in table format
    System.out.printf("%n|%-15s|%-87s|", "    Buckets  ", "\t\t\t\t\t\t\t\t  Elements");
    System.out.println();
    for (int i = 0; i < 160; i++) {
      System.out.print("-");
    }
    System.out.println();

    // To print out the array in a beautiful way
    // i stands for which bucket we wish to write
    for (int i = 0; i < 10; i++) {
      System.out.printf("|\t%-8s|\t", i);
      
      // Print out the element inside the bucket (array)
      // k stands for rows (which element in the bucket) we are at
      for (int k = 0; k < arr.length; k++) {
        // j stands for columns (which bucket) we are writing
        for (int j = 0; j < 10; j++) {
          // Only write when we are at the right bucket which we are at the right bucket
          if (j == i) {
            // Make the printing to the next line if the element is printed too much
            if (limit > 6) {
              System.out.printf("\n|\t%-8s|\t", "");
              limit = 0;
            }

            // To prevent showing the null value
            if (arr[k][j] != null) {
              System.out.printf("%-2s %-15s", "·", arr[k][j]);
              limit++;
            }
          }
        }
        //reset the printing for next row
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

  //method to print final result
  public static void printFinal(Integer[][] finalArr) {
    System.out.println();
    System.out.println();
    System.out.println();
    //user friendly message
    System.out.println("Sorted List(Final Answer): ");

     // To prevent over printing
    int length = (finalArr.length*20);

    if (length >= 238) {
      length = 238;
    }

     // For formatting purpose
    for (int i = 0; i < length; i++) {
      System.out.print("-");
    }
    System.out.println();

    // To print final result
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < finalArr.length; j++) {
        if (finalArr[j][i] != null) {
          System.out.printf("  ·  %-15s", finalArr[j][i]);
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

  // method to do the passing of the array from one array to another array
  public static void passingArray(Integer[][] Array1, Integer[][] Array2, int m, int d, Counter val) {
    int row = 0; //to trace the row, if there are elements that will put into the same bucket, the latest entered element will insert into the next row
    //COUNTER: 1 assign
    val.ass += 1;
    for (int digit = 0; digit < 10; digit++) { // trace the digit, and use it for element arrangement purpose
      //COUNTER: for loop (1 assign, 1 compare, 1 addition) 
      val.ass += 1;
      val.com += 1;
      val.add += 1;
      for (int i = 0; i < 10; i++) { // use to trace the array column by column
        //COUNTER: for loop (1 assign, 1 compare, 1 addition)
        val.ass += 1;
        val.com += 1;
        val.add += 1;
        for (int j = 0; j < Array1.length; j++) { // use to trace the array row by row
          //COUNTER: for loop (1 assign, 1 compare, 1 function call, 1 addition)
          val.ass += 1;
          val.com += 1;
          val.add += 1;
          val.func += 1; 

          //COUNTER: if condition (1 array lookup, 1 compare)
          val.arr += 1;
          val.com += 1;
          if (Array1[j][i] == null) { //if no value, skip
            break;
          }
          //COUNTER: if condition (1 array lookup, 1 modulus, 1 division, 1 compare)
          val.arr += 1;
          val.mod += 1;
          val.div += 1;
          val.com += 1;
          if (((Array1[j][i] % m) / d) == digit) { // To decide whether the element need to put at which column based on the digit we slice out from the input
            Array2[row][digit] = Array1[j][i]; // Pass the element of one array to another array to the correct place
            row++;
            //COUNTER: 2 array lookup, 2 assign, 1 addition
            val.arr += 2;
            val.ass += 2;
            val.add += 1;
          }
        }
        // COUNTER: end loop (1 assign, 1 compare, 1 function call)
        val.ass += 1;
        val.com += 1;
        val.func += 1;
      }
      // COUNTER: end loop (1 assign, 1 compare)
      val.ass += 1;
      val.com += 1;
      row = 0; // Reset the row to 0 so that the next column can insert start from the first row
      // COUNTER: 1 assign
      val.ass += 1;
    }
    // COUNTER: end loop (1 assign, 1 compare)
    val.ass += 1;
    val.com += 1;
  }

  //method that use to trace the passing of the array and call the passingArray method to operate the passing
  public static void sortAscending(Integer[][] initialArray, int maxLoop, Counter val) {
    Integer[][] array1 = new Integer[initialArray.length][10]; //array1 initialise (2D array)
    // COUNTER: 1 function call, 1 assign, length*10 array lookup
    val.func += 1;
    val.ass += 1;
    val.arr += (initialArray.length*10);
    Integer[][] array2 = new Integer[initialArray.length][10]; //array2 initialise (2D array)
    // COUNTER: 1 function call, 1 assign, length*10 array lookup
    val.func += 1;
    val.ass += 1;
    val.arr += (initialArray.length*10);

    int currentLoop = 0; // use to trace the loop and for the printing number of pass
    int modulus = 10; // use to slice out the digit
    int division = 1; //use to slice out the digit
    //COUNTER: 3 assign, 2 function call
    val.ass += 3;
    val.func += 2;

    while (maxLoop > 0) { //stop the passing when reached the max loop
      //COUNTER: while loop (1 compare)
      val.com += 1;
      maxLoop--; // to trace the number of looping
      //COUNTER: 1 addition, 1 assign
      val.add += 1;
      val.ass += 1;

      // COUNTER: if condition (1 compare)
      val.com += 1;
      if (currentLoop == 0) { // if it is the first loop, pass the element in the initialise array into first array
        passingArray(initialArray, array1, modulus, division, val); // call the passing method to operate the passing
        currentLoop++; // trace the current loop
        printPass(array1, currentLoop); //print the array after passing to showcase the step by step arrangement
        // COUNTER: 1 function call, 1 addition, 1 assign 
        val.func += 1;
        val.add += 1;
        val.ass += 1;

      } else if (currentLoop % 2 == 1) { //from array1 pass to array2
        // COUNTER: else if condition (1 modulus, 1 compare)
        val.mod += 1;
        val.com += 1;

        array2 = new Integer[initialArray.length][10]; //to clear the array 
        // COUNTER: 1 function call, 1 assign, length*10 array lookup
        val.func += 1;
        val.ass += 1;
        val.arr += (initialArray.length*10);

        passingArray(array1, array2, modulus, division, val); // call the passing method to operate the passing
        currentLoop++; // trace the current loop
        printPass(array2, currentLoop); //print the array after passing to showcase the step by step arrangement
        // COUNTER: 1 function call, 1 addition, 1 assign
        val.func += 1;
        val.add += 1;
        val.ass += 1;

      } else { //from array2 pass to array1
        // COUNTER: else if condition (1 modulus, 1 compare)
        val.mod += 1;
        val.com += 1;

        array1 = new Integer[initialArray.length][10]; //to clear the array
        // COUNTER: 1 function call, 1 assign, length*10 array lookup
        val.func += 1;
        val.ass += 1;
        val.arr += (initialArray.length*10);

        passingArray(array2, array1, modulus, division, val); // call the passing method to operate the passing
        currentLoop++; // trace the current loop
        printPass(array1, currentLoop); //print the array after passing to showcase the step by step arrangement
        // COUNTER: 1 function call, 1 addition, 1 assign
        val.func += 1;
        val.add += 1;
        val.ass += 1;
      }
      modulus *= 10; // increase the value to slice the digit in next place value, for example, from tens digit to hundreds digit
      division *= 10; // increase the value to slice the digit in next place value, for example, from tens digit to hundreds digit
      // COUNTER: 2 multiplication, 2 assign
      val.mul += 2;
      val.ass += 2;
    }
    // COUNTER: end loop (1 compare)
    val.com += 1;

    // COUNTER: if condition (1 modulus, 1 assign)
    val.mod += 1;
    val.ass += 1;
    if (currentLoop % 2 == 0) { //to see whether the final answer is in which array
      printFinal(array2); // print array2 if it is in array2
    } else {
      printFinal(array1); // print array1 if it is in array2
    }
  }

  public static void main(String[] args) {
    Counter counter = new Counter();
    Scanner sc = new Scanner(System.in); // to receive input from user
    System.out.print("Please enter the number (separate by comma): "); //user friendly message
    String input = sc.nextLine(); // to receive input from user
    String[] inputNumber = input.split(","); //separate the input with the ',' into an array, as we prompt user to use ',' to separate the number
    //COUNTER: 1 assign
    //counter.ass += 1;
  
    Integer[][] initialise = new Integer[inputNumber.length][10]; // initialise 2D array as a preparation to start the sorting
    // COUNTER: 1 function call, 1 assign, length*10 array lookup
    counter.func += 1;
    counter.ass += 1;
    counter.arr += (inputNumber.length*10);

    for (int i = 0; i < inputNumber.length; i++) { //looping to convert the string to integer
      // COUNTER: for loop (1 assign, 1 compare, 1 addition)
      /*counter.ass += 1;
      counter.com += 1;
      counter.add += 1;*/

      initialise[i][0] = Integer.parseInt(inputNumber[i]); //convert the string to integer
      // COUNTER: 1 array lookup, 1 assign
      /*counter.arr += 1;
      counter.ass += 1;*/
    }
    // COUNTER: end loop (1 assign, 1 compare)
    /*counter.ass += 1;
    counter.com += 1;*/

    int max = initialise[0][0]; //assign the first element of the array as the largest input
    // COUNTER: 1 array lookup, 1 assign
    counter.arr += 1;
    counter.ass += 1;

    for (int i = 0; i < inputNumber.length; i++) { // find the largest value first to use for count the number of loop needed
      // COUNTER: for loop (1 assign, 1 compare, 1 addition, 1 function call)
      counter.ass += 1;
      counter.com += 1;
      counter.add += 1;
      counter.func += 1;

      // COUNTER: if condition (1 compare, 1 array lookup)
      counter.com += 1;
      counter.arr += 1;
      if (max < initialise[i][0]) { // to find the largest value
        max = initialise[i][0];
        // COUNTER: 1 assign, 1 array lookup
        counter.ass += 1;
        counter.arr += 1;
      }
    }
    // COUNTER: end loop (1 assign, 1 compare, 1 function call)
    counter.ass += 1;
    counter.com += 1;
    counter.func += 1;

    int maxDigit = 0; // to count how many loop we need for this algorithm
    // COUNTER: 1 assign
    counter.ass += 1;

    while (max > 0) { // loop until the max is smaller than 0 
      // COUNTER: while loop (1 compare)
      counter.com += 1;

      max = max / 10;
      maxDigit++; //count the number of loop we need
      // COUNTER: 1 division, 2 assign, 1 addition
      counter.div += 1;
      counter.ass += 2;
      counter.add += 1;
    }
    // COUNTER: end loop (1 compare)
    counter.com += 1;

     // COUNTER: function call
    counter.func += 1;
    sortAscending(initialise, maxDigit, counter); //pass the information to start the sorting algorithm

    System.out.println("Number of addtion operation = " + counter.add);
    System.out.println("Number of multiplication operation = " + counter.mul);
    System.out.println("Number of division operation = " + counter.div);
    System.out.println("Number of modulus operation = " + counter.mod);
    System.out.println("Number of assignment operation = " + counter.ass);
    System.out.println("Number of function call operation = " + counter.func);
    System.out.println("Number of array lookup operation = " + counter.arr);
    System.out.println("Number of comparison operation = " + counter.com);
    System.out.println("Total number of primitive operation = " + (counter.add+counter.mul+counter.div+counter.mod+counter.ass+counter.func+counter.arr+counter.com));
  }
}
