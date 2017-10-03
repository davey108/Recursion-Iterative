import java.util.Date;

/**
 *  Performs various operations for practice with arrays
 *  and Java 
 */
 class IterationCode {
 /**
  *  Reverse an array.
  *  
  *  Why are you doing this? Arrays are really critical to
  *  all programming. You need to see common scenarios like
  *  this a lot before you will become fast at using them.
  *  
  *  @param input the array to reverse
  *  @return the revered array
  *  @throws IllegalArgumentException if the input array is null
  */ 
 public static int[] arrayReverse(int[] input) {
  if(input == null){
   throw new IllegalArgumentException();
  }  
  int index = 0;
  int [] output = new int[input.length];
  if(input.length == 0){
    return output;
  }
  // moving backward and putting in each index
  // from back to front
  for(int i = input.length-1; i > -1; i--){
   output[index] = input[i];
   index++;
  }
  return output;
 }
 
 /**
  *  Determine whether an array of characters is a palindrome.
  *  
  *  Why are you doing this? Arrays are really critical to
  *  all programming. You need to see common scenarios like
  *  this a lot before you will become fast at using them.
  *  
  *  @param input the array to check
  *  @return whether or not the array is a palindrome
  *  @throws IllegalArgumentException if the input array is null
  */ 
 public static boolean arrayPalindrome(char[] input) {
  if(input == null){
   throw new IllegalArgumentException();
  }
  // moving to each index but also checking
  // the corresponding end index (so if index 0, check index length -1)
  for(int i = 0; i<input.length; i++){
   if(input[i] != input[input.length-1 - i]){
    return false;
   }
  }
  return true;
 }
 
 /**
  *  Replicate each element in an array some number of times.
  *  For example, the array input of [1,2,2,3] and numTimes of
  *  2 would result in the array [1,1,2,2,2,2,3,3].
  *  
  *  Why are you doing this? Arrays are really critical to
  *  all programming. You need to see common scenarios like
  *  this a lot before you will become fast at using them.
  *  
  *  @param input the array to expand
  *  @return an array with replicated elements
  *  @throws IllegalArgumentException if the input array is null or the number of replications is less than 1
  */
 public static int[] replicateElements(int[] input, int numTimes) {
  if(numTimes<1 || input == null){
   throw new IllegalArgumentException();
  }
  if(input.length == 0){
    int [] a = new int [0];
    return a;
  }
  // create new array with total num of items(hence length) * the number
  // of times we want to multiply
  int [] output = new int[input.length * numTimes];
  int outputIndex = 0;
  // loop through the original array and let the item at each index
  // append to the new array numEach times
  // @param pushCount the number of time the element
  // has been pushed into the new array, only stop if it reaches 0 aka fulfill the numTimes requirement
  // @param outputIndex the index mover of the new array, it keeps moving
  for(int i = 0; i< input.length; i++){
   int pushCount = numTimes; 
   // keep pushing in the new array until it reaches numTimes then move onto the next index of original
   // and restart pushCount (aka the numTimes count for that element)
   while(pushCount != 0){
    output[outputIndex] = input[i];
    pushCount --;
    outputIndex ++;
   }
  }
  return output;
 }
 
 /**
  *  Remove consecutive duplicates in an array. For example,
  *  the array input of [1,2,2,2,3,3,2] should return the array
  *  [1,2,3,2].
  *  
  *  Why are you doing this? Arrays are really critical to
  *  all programming. You need to see common scenarios like
  *  this a lot before you will become fast at using them.
  *  
  *  @param input the array to remove consecutive duplicates from
  *  @return the reduced array
  *  @throws IllegalArgumentException if the input array is null
  */
 // if input.length == 0, should we return the empty array?
 public static int[] removeConsecDuplicates(int[] input) {
  if(input == null){
   throw new IllegalArgumentException();
  }
  if(input.length == 0){
    int [] a = new int[0];
    return a;
  }
  // account for the fact that this code only
  // account for the diff infront, not behind
  int countDiff = 1;
  // loop through and count the number of difference number
  for(int i = 1; i< input.length; i++){
   if(input[i] != input[i-1]){
    countDiff++;
   }
  }
  int [] output = new int[countDiff];
  int countIndex = 0;
  // loop through and add in all the difference
  for(int i = 1; i<input.length; i++){
   if(input[i] != input[i-1]){
    output[countIndex] = input[i-1];
    countIndex++;
   }
  }
  // just like the count, account for fact that
  // we will never add the final value of input array
  // so do it here
  output[countIndex] = input[input.length-1];
  return output;
 }
 
 /**
  *  Drop every nth element from an array. For example,
  *  the array input of [1,2,2,7,8,1,77] and n = 3 should
  *  result in: [1,2,7,8,77].
  *  
  *  Why are you doing this? Arrays are really critical to
  *  all programming. You need to see common scenarios like
  *  this a lot before you will become fast at using them.
  *  
  *  @param input the array to drop elements from
  *  @param n which elements to drop (every nth)
  *  @return the reduced array
  *  @throws IllegalArgumentException if the input is null or n is less than 1
  */
 // pattern multiplier * n - 1
 public static int[] removeEveryNthElem(int[] input, int n) {
  if(input == null || n < 1){
   throw new IllegalArgumentException();
  }
  // if n is outside of array, then just return the array(can't remove anything)
  if(n > input.length){
   return input;
  }
  // if length is 1, the smallest that can be remove is the very first
  // element itself so save time in the code and just return an empty array
  if(input.length == 1){
   int [] output = new int[0];
   return output;
  }
  // a multiplier to move to each n index
  int mover = 1;
  // count total number of nth
  int count = 0;
  for(int i = 0; i<input.length; i++){
   if(i == mover*n-1){
    mover++;
    count++;
   }
  }
  // create a new array with nth "removed"
  int [] output = new int[input.length-count];
  mover = 1;
  int index = 0;
  // a loop that append the other elements to new array
  // and skip the one that is marked as nth element(because those
  // do not exist in the new array)
  for(int i = 0; i<input.length; i++){
   if(i == mover*n-1){
    mover++;
   }
   else{
    output[index] = input[i];
    index++;
   }
  }
  return output;
 }
 
 /**
  *  Slice out a certain part of the array from a given
  *  start index to a given end index (inclusive). For example,
  *  if the input array is [1,2,3,4,5,6,7] and the start index
  *  is 2 and end index is 3, the resulting array will containing
  *  [3,4].
  *  
  *  Why are you doing this? Arrays are really critical to
  *  all programming. You need to see common scenarios like
  *  this a lot before you will become fast at using them.
  *  
  *  @param input the array to take a slice from
  *  @param startIndex the index to start from (inclusive)
  *  @param endIndex the index to end at (inclusive)
  *  @return the slice of the array requested
  *  @throws IllegalArgumentException if the input array is null, or either index is invalid
  */ 
 public static char[] slice(char[] input, int startIndex, int endIndex) {
  if(input == null || startIndex < 0 || startIndex > input.length-1 || endIndex < 0 || endIndex > input.length-1){
   throw new IllegalArgumentException();
  }
  char [] output;
  // given char [] b = {'a','b','c','d','e','f'} --> length = 6
  // 6-3 + 2? = 5 if slice(b,3,1)  
  // should yield {'d','e','f','a','b'} --> because we going forward (backward is weird)
  // what would happen if slice(b,2,1}? 
  // if length = 6 --> 6-2 + 2? = 6
  // so formula for if endIndex < startIndex is array.length - startIndex + endIndex + 1
  if(endIndex < startIndex){
    int size = input.length-startIndex + endIndex + 1;
    output = new char[size];
    int index = 0;
    for(int i = startIndex; i < input.length; i++){      
       output[index] = input[i];
       index++;
       // we want to go back to beginning of array --> going around
       if(i == input.length - 1){
         i = -1;
       }
       // we want to stop here if it reached the endIndex
       else if( i == endIndex){
         break;
       }     
    }
  }
  // for all the other regular occurence (aka startIndex < endIndex or == )
  else{
    // plus 1 because end is inclusive
    int size = endIndex - startIndex + 1;
    output = new char [size];
    int index = 0;
    // loop through and add in all those from start to end
    for(int i = startIndex; i < endIndex + 1; i++){
      output[index] = input[i];
      index++;
    }
  }
  return output;
 }
 
 /**
  *  Reverse byte ordering. One hex character represents one nibble (4 bits,
  *  or half a byte), so two hex characters is used to represent a single
  *  byte. If you want to reverse the bytes you need to reverse the string
  *  in pairs of nibbles not in individual nibbles.
  *  
  *  For example, the hex: AE3F20F0 represents 4 bytes: AE, 3F, 20, and F0
  *  To reverse those bytes we would need to return: F0, 20, 3F, and AE (F0203FAE)
  *  
  *  Why are you doing this? Look up big-endian to little-endian conversion.
  *  Also, this is more practice with arrays...
  *  
  *  @param input a character array representing a string of bytes stored as hex
  *  @return the revered byte ordering
  *  @throws IllegalArgumentException if the input array is null or contains an odd number of elements
  */
 
 public static char[] reverseByteOrdering(char[] input) {
  // check for odd or null
  if(input == null || input.length % 2 == 1){
   throw new IllegalArgumentException();
  }
  // check for 0 length, return an empty one because nothing to reverse
  if(input.length == 0){
    char [] a = new char[0];
    return a;
  }  
  char [] output = new char[input.length]; 
  // indicate the index to start adding into the new output array
   int index = 0;
   // loop through every 2nd element from the back and add in that 2nd
   // element first then the one before it (in a normal front to back fashion then that is the element after it)
   // aka {'F','8','A','C'} then the loop will add 'A' first then 'C'
   // start at 2nd to the last element and decrement by 2
   for(int i = input.length-2; i > -1; i -=2){
    output[index] = input[i];    
    output[++index] = input[i+1];
    index++;
   }   
  return output;
 }
 

 /**
  *  Return a size1 x size2 array of Date objects (elements
  *  should not be null).
  *  
  *  Why are you doing this? Multi-dimensional arrays of objects require
  *  slightly different proceedures to initialize them than primitives.
  *  
  *  @param size1 first dimension of the array
  *  @param size2 second dimension of the array
  *  @return a size1 x size2 array of Date objects with no null elements
  *  @throws IllegalArgumentException if either size is less than 0
  */
 public static Date[][] multiDimDateArray(int size1, int size2) {
  // check if either size are invalid
  if(size1 < 0 || size2 < 0){
   throw new IllegalArgumentException();
  }  
  Date [][] output = new Date [size1][size2];
  // if either is 0, nothing can be add so just give back the 2D array
  if(size1 == 0 || size2 == 0){
    return output;
  }  
  // if the input is something addable then go and add
  // each Date object to it
  for(int i = 0; i< output.length; i++){
   for(int j = 0; j< output[i].length; j++){
    output[i][j] = new Date();
   }
  }
  return output;
 } 
 
 /**
  *  Count the number of nulls in an array of objects.
  *  
  *  Why are you doing this? It is always important to check in
  *  an array of objects for null elements, so you need to know
  *  how to do this.
  *  
  *  @param inputArray the array to look for nulls in
  *  @return the number of elements of the array which are null
  *  @throws IllegalArgumentException if the input array is null
  */
 public static int nullsInArray(Object[] inputArray) {
  if(inputArray == null){
   throw new IllegalArgumentException();
  }
  int countNull = 0;
  // the loop count for number of null in the array and return it
  for(Object i : inputArray){
   // if it is truly null, then this would work
   if (i == null){
    countNull ++;
   }
  }
  return countNull;
 }
 
 /**
  *  Returns an array of objects containing some number of StringBuffer,
  *  NullPointerException, ArrayIndexOutOfBoundsException, and Date objects
  *  (in that order). For example, input of 2 would result in an array
  *  containing 2 StringBuffers, 2 NullPointerExceptions,
  *  2 ArrayIndexOutOfBoundsExceptions, and 2 Dates.
  *  
  *  Note that all of these objects can be constructed with a zero parameter
  *  constructor.
  *  
  *  Why are you doing this? Object is the parent of all classes in
  *  the Java hierarchy. No, really, every class. That includes things like
  *  exceptions as well as dates and utility classes. That means an Object 
  *  array is incredibly powerful and you should understand how to make one.
  *  
  *  @param numEach the number of each object to put into a the array
  *  @return an array of size numEach*4 containing numEach StringBuffer, NullPointerException, ArrayIndexOutOfBoundsException, and Date objects
  *  @throws IllegalArgumentException if numEach < 0
  */
 public static Object[] multiObjectArray(int numEach) {
   // check for invalid numEach
  if(numEach < 0){
   throw new IllegalArgumentException();
  }
  // if numEach is 0, nothing to add.
  if(numEach == 0){
   Object [] output = new Object[0];
   return output;
  }
  // make an array with 4 types of object * numEach
  Object [] output = new Object[numEach*4];
  // where to start adding in new output []
  int index = 0;
  // count how many of the same type of Object has 
  // been added into the array and only reset if
  // the number of added type is equal to numEach
  int count = 0;
  // a loop that add in all 4 different type of 
  // object numEach time. The inner while loop
  // make it keep adding until count == numEach
  // then reset count and move onto next type.
  for(int i = 0; i < 4; i++){
   while(count != numEach){
     if(i == 0){
       output[index] = new StringBuffer();
     }
     else if(i == 1){
       output[index] = new NullPointerException();
     }
     else if(i==2){
       output[index] = new ArrayIndexOutOfBoundsException();
     }
     else if(i==3){
       output[index] = new Date();
     }
    index++;
    count++;
   }
   count = 0;
  }
  return output;
 }
 
 /**
  *  Returns a sorted list of objects given two arrays
  *  that are already sorted.
  *  
  *  Why are you doing this? This is part of a larger
  *  program we've studdied...
  *  
  *  @param array1 a sorted array
  *  @param array2 a second sorted array
  *  @return a single sorted array which combines the other two
  *  @throws IllegalArgumentException if either array is null or not sorted
  */
 public static int[] join(int[] array1, int[] array2){
  // check case for if array == null or not sorted
  if(array1 == null || array2 == null || !sortArray(array1) || !sortArray(array2)){
     throw new IllegalArgumentException();
  }
  // if either array is empty, then just return the other one
  if(array1.length == 0){
    return array2;
  }
  if(array2.length == 0){
    return array1;
  }
  int [] result = new int [array1.length + array2.length];
  // tracking index of left and right array (aka array1 & array2)
  int left = 0;
  int right = 0;
  // a loop to take the according element from left or right array
  // only take from left is right has run out of element or if left still
  // has element and that element in left is less than or equal to elements in right
  // and increase either left or right index to take the next one
  for(int i = 0; i < result.length; i++){
   if(right >= array2.length || left < array1.length && array1[left] <= array2[right]){
    result[i] = array1[left];
    left++;
   }
   else{
    result[i] = array2[right];
    right++;
   }
  }
  return result;
 }
// a helper method to check if the array is sorted
public static boolean sortArray(int [] array){
 for(int i = 1; i < array.length; i++){
  if(array[i] < array[i-1]){
   return false;
  }
 }
 return true;
}

}