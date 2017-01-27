/** The class StringArrayTools implements a variety of basic array tasks
  * using an array of strings.
  * 
  * The array has a fixed length MAX_STRINGS but the actual number of elements
  * that are used can vary.
  */

import java.util.Scanner;

public class StringArrayTools
{
  
  private String[] arrayData;
  private int arrayCount;
  public final int MAX_STRINGS = 100;
  
  // ------------------ CONSTRUCTOR ----------------------------
  /** The contsructor merely creates the array.
    * It does not fill it with any data.  That is left up to 
    * the fillKeyboard method.
    */
  public StringArrayTools ()
  {
    arrayData = new String[MAX_STRINGS];
    arrayCount = 0;
  }
  
  /** Returns the number of objects in the array.
    * @return the count of items in the array. */
  public int getCount ()
  {
    return arrayCount;
  }
  
  // ------------------- METHODS TO FILL THE ARRAY -------------------------
  /** Adds an element to the end of the array. 
    * @param n The element to add
    * @return whether the element was successfully added
    */
  public boolean addItem (String n)
  {
    if (arrayCount < MAX_STRINGS)
    {
      arrayData[arrayCount] = n;
      arrayCount++;
      return true;
    }
    else
      return false;
  }
  
  /** Fills the array with strings entered by the user
    * @param nums the array to fill.  Returns a modified array.
    */
  public void fillKeyboard ()
  {
    Scanner keyboard = new Scanner(System.in);
    System.out.println ("Please enter strings on separate lines, presssing enter between each");
    System.out.println ("Press enter twice to signal the end of the list.");
    
    arrayCount = 0;
    String n = keyboard.nextLine();
    while (n.length() != 0)                 // stop input when user enters -1
    {
      addItem(n);
      n = keyboard.nextLine();
    }
    keyboard.close();
  }
  
  // -------------------- METHODS TO WORK WITH THE ARRAY --------------------------
  /** Prints the array, spaces between strings.
    */
  public void printArray ()
  {
    for (int i = 0; i < arrayCount; i++)
      System.out.println(arrayData[i]);
    System.out.println();
  }
  
 /** Get the largest value in an integer array
   * @return the maximum value of the integer array 
   **/
  public String getMax() {
   String max = arrayData[0];
   for (int i = 0; i < arrayCount; i++) {
    if (arrayData[i].compareTo(max) > 0)
     max = arrayData[i];
   }
   return max;
  }
 /** Get the index of the largest element of the integer array
   *@return the index of the maximum value of the integer array
   **/
  public int getMaxIndex() {
    String max = arrayData[0];
    int index = 0;
   for (int i = 0; i < arrayCount; i++) {
     if (arrayData[i].compareTo(max) > 0){
     max = arrayData[i];
     index = i;
     }
     }
   return index;
  }
 /** Get the smallest value in an integer array
   * @return the minimum value of the integer array 
   **/
  public String getMin() {
   String min = arrayData[0];
   for (int i = 0; i < arrayCount; i++) {
    if (arrayData[i].compareTo(min) < 0)
     min = arrayData[i];
   }
   return min;
  }
 /** Get the index of the smallest element of the integer array
   *@return the index of the minimum value of the integer array
   **/
  public int getMinIndex() {
    String min = arrayData[0];
    int index = 0;
   for (int i = 0; i < arrayCount; i++) {
     if (arrayData[i].compareTo(min) < 0){
     min = arrayData[i];
     index = i;
     }
     }
   return index;
  }
  /** Finds the minimun starting from a certain position
    * @param start the index from which to start searching for the minimun
    * @return pos the index of the minimun string startinf from position start
    **/
 public int getMinIndex(int start) {
   String min = arrayData[0];
   int pos = start;
   for (int i = 0; i < arrayCount; i++) {
     if (arrayData[i].compareTo(min) < 0)
     pos = i;
     }
   return pos;
  }
  /** Sorts the array in order from least to greatest
    **/
 public void sort() {
   int pos = 0;
   while (pos < arrayCount-1){
     int min = getMinIndex(pos);
     String swap = arrayData[min];
     arrayData[min] = arrayData[pos];
     arrayData[pos] = swap; 
     pos++; 
   }
 }
  /** Tests the various array tools */
  public static void main (String[] args)
  {
    StringArrayTools myArray = new StringArrayTools();
    myArray.fillKeyboard ();
    myArray.printArray ();
    System.out.println ("There are " + myArray.getCount() + " strings in the array.");
    
    // Un-comment these lines one at a time after you have written the appropriate code
    //System.out.println ("The largest item is " + myArray.getMax() ); 
    //System.out.println ("The largest item is at index " + myArray.getMaxIndex());

    //System.out.println ("The smallest item is " + myArray.getMin() );
    System.out.println ("The smallest item is at index " + myArray.getMinIndex());
    
    myArray.sort();
    myArray.printArray();
  }
}
