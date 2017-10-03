/**
 *  Performs various operations for practice with recursion.
 *
 */
class RecursionCode {
 /**
  *  Determine whether an array of characters is a palindrome.
  *  
  *  Hint: you may want a helper method for this.
  *  
  *  @param input the array to check
  *  @return whether or not the array is a palindrome
  *  @throws IllegalArgumentException if input array is null
  */
 public static boolean arrayPalindrome(char[] input) {
  RecursionCodeSampleTests.hasRecursion();
  // check for null case
  if(input == null){
    throw new IllegalArgumentException();
  }
  // check for empty array case, return true because nothing is
  // still consider palindrome (same case as 1, 0 is also "itself")
  if(input.length == 0){
    return true;
  }
  // call helper recursive method to check front and back
  return checkIndexPalindrome(input,0,input.length-1); 
 }
 // Helper method for the above
 // Recursive that check the array front and back index and moving inner
 // Has 3 base cases:
 // 1. If front and end index is the same, meaning checking the same number so true
 // 2. If approach the inner most pair then check if they are same, if same, give true, if not, give false
 // 3. If approach any pair that are not equal, exit by returning false
 public static boolean checkIndexPalindrome(char [] input, int beginning, int end){
   RecursionCodeSampleTests.hasRecursion();
   // base case 1
   if(beginning == end){
     return true;
   }
   // base case 2
   if(end - beginning == 1){
     if(input[beginning] == input[end]){
       return true;
     }
     return false;
   }
   else{
     // base case 3
     if(input[beginning] != input[end]){
       return false;
     }
     // if everything is smooth, keep checking inner pairs
     return checkIndexPalindrome(input,beginning+1,end-1);
   }
 }
 
 /**
  *  Count the number of nulls in an array of objects.
  *  
  *  Hint: you may want a helper method for this.
  *  
  *  @param inputArray the array to look for nulls in
  *  @return the number of elements of the array which are null
  */
 public static int nullsInArray(Object[] inputArray) {
  RecursionCodeSampleTests.hasRecursion();
  // check for null case and 0 length
  if(inputArray == null){
    return 0;   
  } 
  if(inputArray.length == 0){
    return 0;
  }
  // call on recursive helper method
  return nullCountTotal(inputArray,0,0);  
 }
 // recursive helper method
 // Take in 3 params
 // @param array the array to check for number of nulls
 // @param count the total of null count thus far
 // @param startIndex the index of the element to check if it is null or not
 // Has 1 base case 
 // if the check index is the end index of the array, then check if it is null
 // if is, add 1 to count and return
 // else if the current spot is null, keep counting but return with +1 (for that spot)
 // or if the current spot is not, just keep recursively counting
 public static int nullCountTotal(Object [] array, int count, int startIndex){
   RecursionCodeSampleTests.hasRecursion();
   // base case 1
   if(startIndex == array.length-1){
     if(array[startIndex] == null){
       return 1;
     }
     return 0;
   }
   else{
     // if the current index is null, then add in after the recursive returns
     if(array[startIndex] == null){
       return 1+ nullCountTotal(array,count,startIndex+1);
     }
     // if not, continue counting recursively without adding
     else{
       return nullCountTotal(array,count,startIndex+1);
     }
   }
 }
 
 /**
  *  Count number of 0s in linked list of ints (starting at
  *  a given node);
  *  
  *  Hint: you don't need a "helper" method for this.
  *  
  *  @param head the head of the linked list
  *  @return the number of 0s in the linked list
  */
 // Has 2 base cases
 // if input head is null, throw exception since it is not even a linked list
 // if approach end of a link list, if the head value is 0, return 1, if not, return 0
 // if not base cases then check if the current value at is 0, then add 1 and recurse (so 1 can be add later)
 // if not base cases and current value is not 0, then just call recurse
 public static int zerosInLinkedList(Node head) {
  RecursionCodeSampleTests.hasRecursion();
  // base case 1
  if(head == null){
    return 0;
  }
  // base case 2
  if(head.next == null){
    if(head.value == 0){
      return 1;
    }
    return 0;
  }
  // others, +1 if value is 0 and recurse or just recurse if value at is not 0
  else{    
    if(head.value == 0){
      return 1 + zerosInLinkedList(head.next);
    }
    else{
      return zerosInLinkedList(head.next);
    }
  }  
 }
 
 /**
  *  Multiply all the values in a linked list of ints (starting
  *  at a given node);
  *  
  *  Hint: you don't need a "helper" method for this.
  *  Note: DO NOT USE the exception thrown to control your recursion!
  *  
  *  @param head the head of the linked list
  *  @return product of all the values in the linked list
  *  @throws IllegalArgumentException if head is null
  */
 // Has 3 base cases
 // 1. If head is null, throw exception because it isn't even a linked list
 // 2. If approach end, return the head value
 // 3. If a head value is 0, just return 0 (to save the performance time and 0 multiply anything is 0)
 // If not base case then just multiply the head value with the recursive call 
 public static int multiplyNodes(Node head) {
   RecursionCodeSampleTests.hasRecursion();
   // Base case 1
   if(head == null){
     throw new IllegalArgumentException();
   }
   // Base case 2
   if(head.next == null){
     return head.value* 1;
   }
   // Base case 3
   if(head.value == 0){
     return 0;
   }
   // If the linked list is still going
   else{
     return head.value * multiplyNodes(head.next);
   }  
 }
 
 /**
  *  Merge sort
  *  
  *  Note: Pseudocode given in class. DO NOT TAKE CODE FROM THE INTERNET!
  *  Note: DO NOT USE the exception thrown to control your recursion!
  *  Note: You'll want a helper method for this
  *  Note: It is permitted to copy make copies of the array
  *   or portions of the array for this method only.
  *  
  *  @param array the array to be sorted
  *  @throws IllegalArgumentException if list is null
  */
 public static void mergeSort(int[] array){
   RecursionCodeSampleTests.hasRecursion();   
   if(array == null){
     throw new IllegalArgumentException();
   }  
   // only do this if length > 1 because 1 or 0 is already sorted
   // split the array into halves using the 2 helpers splitLeft and splitRight
   // and recalling the recursive on those 2 parts so keep splitting until only 1 is left
   // then use merge to merge both parts together in right order (or sorted order)
   if(array.length > 1){     
     int [] left = splitLeft(array);
     int [] right = splitRight(array);  
     mergeSort(left);
     mergeSort(right);
     merge(array,left,right);
   }  
 }
 
 // split the array into left part, this 1 will have
 // the lesser amount if the length is odd
 public static int [] splitLeft(int [] array){
   RecursionCodeSampleTests.hasRecursion();
   int point = array.length/2;
   int [] left = new int[point];
   for(int i = 0; i < point; i++){
     left[i] = array[i];
   }
   return left;
 }
 
 // split array into right part
 // this part will have 1 more than left is length is odd
 public static int [] splitRight(int [] array){
   RecursionCodeSampleTests.hasRecursion();
   int point = 0;
   // where to start at the left index because the array index
   // adding in will be different
   int index = 0;
   int [] right = new int[0];
   // a case for if length of total array is odd
   // then make the length for right side longer by 1 
   if(array.length%2 == 1){
     point = array.length/2 + 1;
     right = new int[point];
     for(int i = point-1; i < array.length; i++){
       right[index] = array[i];
       index++;
     }
   }
   else{
     point = array.length/2;
     right = new int[point];
     for(int i = point; i < array.length; i++){
       right[index] = array[i];
       index++;
     }
   }
   return right;
 }
 
 // Third helper method to merge the 2 sides together
 public static void merge(int [] array, int [] left, int [] right){
   RecursionCodeSampleTests.hasRecursion();
   // Indexes to keep track of left and right side
   int leftI = 0;
   int rightI = 0;
   // Looping through the original array size and reorganize the element
   // only change and take from left side if right side run out or if left side element is less than or equal to right and left is still available
   // else take from right and increment the indexes so we know not to take the same spot again (like it is gone)
   for(int i = 0; i < array.length; i++){
     if(rightI >= right.length|| leftI < left.length && left[leftI] <= right[rightI]){     
       array[i] = left[leftI];
       leftI ++;
     }
     else{
       array[i] = right[rightI];
       rightI ++;
     }
   }
 }
 
 /**
  *  Insertion sort
  *  
  *  Note: Pseudocode given in class for iterative version. DO NOT TAKE CODE FROM THE INTERNET!
  *  Note: DO NOT USE the exception thrown to control your recursion!
  *  Note: You'll want at least one helper method for this
  *  Hint: You may actually want two recursive functions, one doing
  *   the job of the outer loop in the iterative version, and one
  *   doing the job of the inner loop in the iterative version.
  *  
  *  @throws IllegalArgumentException if list is null
  *  @param array the array to be sorted
  */
 public static void insertionSort(int[] array) {
  RecursionCodeSampleTests.hasRecursion();
  if(array == null){
    throw new IllegalArgumentException();
  }
  // if array length is 0 or 1, don't do anything because it is already sorted
  if(array.length == 0 || array.length == 1){
    return;
  }
  // call to first recursive mover to start the sorting
  else{
    // start at index 1 because the first one is sorted, so we care to check the one after and beyond only
    outerMover(array,1);
  }
 }
 
 // act as the outer for loop in iterative version
 // Has 1 base case
 // 1. Stop and return if the index is the array length or aka the end of the array
 // If not base case, then call to innerSort and let it do the sorting
 // then afterward, call recursive again but moving onto the next index so innerSort and sort that index
 public static void outerMover(int [] array, int index){
   RecursionCodeSampleTests.hasRecursion();
   if(index == array.length){
     return;
   }
   else{
     // index - 1 because we want to check the current index compare to previous
     innerSort(array,index,index-1);
     outerMover(array,index+1);
   }
 }
 
 // Second recursive helper method that does the sorting job of inner for loop in iterative version
 // Has 2 base case
 // 1. If the current index is more than or equal to previous, then it is sorted so return
 // 2. If the previous is 0 (meaning we have sort the number to beginning of array) so return because we don't want out of bound
 // If not base case, then switch the place of both and recurse itself again but with -1 indexes because
 // we need to check the indexes before until it reaches the base cases.
 public static void innerSort(int [] array, int at, int previous){
   RecursionCodeSampleTests.hasRecursion();
   // Base case 1
   if(array[at] >= array[previous]){
     return;
   }
   else if(array[at] < array[previous]){
     int temp = array[previous];
     array[previous] = array[at];
     array[at] = temp;
     // Base case 2 (meaning the current number is now infront of the array because it is the smallest)
     if(previous == 0){
       return;
     }
     // recursion call, the current index is move back by 1 and previous is too moved back because we are going
     // backward to compare
     innerSort(array,at-1,previous-1);
   }
 }
 /**
  *  Do not change this class!
  */
 static class Node {
  public int value;
  public Node next;
  
  public Node(int value) {
   this.value = value;
  }
  
  public void setNext(Node n) {
   next = n;
  }
 }
}