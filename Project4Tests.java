import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
/* This class contains extensive test cases for both Iteration and Recursion classes codes*/
public class Project4Tests { 
  IterationCode testI = new IterationCode();
  RecursionCode testR = new RecursionCode(); 
  String message = "Completed";
  
  // the test cases for arrayReverse()
  @Test(timeout= 2000)
  public void arrayReverseTest1(){
    int [] input = {};
    assertArrayEquals(new int [] {},testI.arrayReverse(input));
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void arrayReverseTest2(){
    int [] input = null;
    testI.arrayReverse(input);    
  }
  @Test(timeout = 2000)
  public void arrayReverseTest3(){
    int [] input = {1,-1,0,4,5,8};
    int [] expected = {8,5,4,0,-1,1};
    assertArrayEquals(expected, testI.arrayReverse(input));
    assertArrayEquals(input,testI.arrayReverse(testI.arrayReverse(input)));
  }
  @Test(timeout = 2000)
  public void arrayReverseTest4(){
    int [] input = {0,0,0,0,0,0,-1,1,1,1,1,0,0,2,2};
    int [] expected = {2,2,0,0,1,1,1,1,-1,0,0,0,0,0,0};
    assertArrayEquals(expected, testI.arrayReverse(input));
    assertArrayEquals(input,testI.arrayReverse(expected));
  }
  @Test(timeout = 2000)
  public void arrayReverseTest5(){
    int [] input = {1};
    assertArrayEquals(input, testI.arrayReverse(input));
  }
  
  // the test cases for arrayPalindrome()
  @Test(timeout = 2000)
  public void arrayPalindromeTest1(){
    char [] input = new char [0];
    assertEquals(true,testI.arrayPalindrome(input));
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void arrayPalindromeTest2(){
    testI.arrayPalindrome(null);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void arrayPalindromeTest3(){
    char [] input = null;
    testI.arrayPalindrome(input);
  }
  @Test(timeout = 2000)
  public void arrayPalindromeTest4(){
    char [] input = {'a','B','C','d','f','d','C','B','a'};
    assertEquals(true,testI.arrayPalindrome(input));
  }
  @Test(timeout = 2000)
  public void arrayPalindromeTest5(){
    char [] input = {'a','b','6','a','7','6','B','a'};
    assertEquals(false,testI.arrayPalindrome(input));
  }
  @Test(timeout=2000)
  public void arrayPalindromeTest6(){
    char [] input = {'1','2'};
    assertEquals(false,testI.arrayPalindrome(input));
    char [] input2 = {'0'};
    assertEquals(true,testI.arrayPalindrome(input2));
    char [] input3 = {'1','1'};
    assertEquals(true,testI.arrayPalindrome(input3));
  }
  
  // test for replicateElements()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void replicateElementsTest1(){
    testI.replicateElements(new int [] {1,2,3,4,1,2,3,5}, -1);    
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void replicateElementsTest1a(){
    testI.replicateElements(new int [] {1,2,3,4,1,2,3,5}, 0);    
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void replicateElementsTest2(){
    int [] input = null;
    testI.replicateElements(input, 0);    
  }
  @Test(timeout=2000)
  public void replicateElementsTest3(){
    int [] input = {2};    
    assertArrayEquals(input,testI.replicateElements(input, 1));    
  }
  @Test(timeout = 2000)
  public void replicateElementsTest4(){
    int [] input = {0,-1,-1,2,0,5,-1,8,9};
    int [] output = {0,0,0,0,-1,-1,-1,-1,-1,-1,-1,-1,2,2,2,2,0,0,0,0,5,5,5,5,-1,-1,-1,-1,8,8,8,8,9,9,9,9};
    assertArrayEquals(output,testI.replicateElements(input,4));
  }
  @Test(timeout = 2000)
  public void replicateElementTest5(){
    int [] input = {1};
    int [] output = {1,1,1,1,1,1,1,1};
    assertArrayEquals(output,testI.replicateElements(input,8));
  }
  @Test(timeout=2000)
  public void replicateElementsTest6(){
    int [] input = {1,2,3,4,1,2,3,5};
    int [] output = {1,1,2,2,3,3,4,4,1,1,2,2,3,3,5,5};
    int [] output2 = {1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,4,4,4,4,4,4,1,1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,5,5,5,5,5,5};
    assertArrayEquals(output,testI.replicateElements(input,2));
    assertArrayEquals(output2,testI.replicateElements(testI.replicateElements(input,2),3));    
  }
  
  // test cases for removeConsecDuplicates
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void removeConsecDuplicatesTest1(){
    int [] input = null;
    testI.removeConsecDuplicates(null);    
  }
  @Test(timeout=2000)
  public void removeConsecDuplicatesTest2(){
    int [] input = {};
    assertArrayEquals(input,testI.removeConsecDuplicates(input));    
  }
  @Test(timeout=2000)
  public void removeConsecDuplicatesTest3(){
    int [] input = {1,2,3,4,5,6};
    assertArrayEquals(input,testI.removeConsecDuplicates(input));    
  }
  @Test(timeout=2000)
  public void removeConsecDuplicatesTest4(){
    int [] input = {1,1,2,3,3,4,5,6,5,5,1,1,0,2};
    int [] output = {1,2,3,4,5,6,5,1,0,2};
    assertArrayEquals(output,testI.removeConsecDuplicates(input));    
  }
  @Test(timeout=2000)
  public void removeConsecDuplicatesTest5(){
    int [] input = {1,1,1,1,1,1};
    assertArrayEquals(new int [] {1},testI.removeConsecDuplicates(input));    
  }
  @Test(timeout=2000)
  public void removeConsecDuplicatesTest6(){
    int [] input = {90,900,90,900,90,900,900};
    int [] output = {90,900,90,900,90,900};
    int [] input2 = {90,90,900,900,90,90,900,900,90,90,900,900};
    assertArrayEquals(output,testI.removeConsecDuplicates(input)); 
    assertArrayEquals(input2, testI.replicateElements(testI.removeConsecDuplicates(input),2));
  }
  
  // test case for remove nth element
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void removeEveryNthElemTest1(){
    int [] input = null;
    testI.removeEveryNthElem(input,1);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void removeEveryNthElemTest2(){
    int [] input = {1,2,3,4};
    testI.removeEveryNthElem(input,0);
  }
  @Test(timeout=2000)
  public void removeEveryNthElemTest3(){
    int [] input = {};
    assertArrayEquals(input,testI.removeEveryNthElem(input,4));
  }
  @Test(timeout=2000)
  public void removeEveryNthElemTest4(){
    int [] input = {2,3,5,7};
    assertArrayEquals(input,testI.removeEveryNthElem(input,5));
  }
  @Test(timeout=2000)
  public void removeEveryNthElemTest4a(){
    int [] input = {2,3,5,7};
    int [] output = {2,3,5};
    assertArrayEquals(output,testI.removeEveryNthElem(input,4));
  }
  @Test(timeout=2000)
  public void removeEveryNthElemTest5(){
    int [] input = {0,-1,5,6,9,100,80,20};
    int [] output = {0,-1,6,9,80,20};
    assertArrayEquals(output,testI.removeEveryNthElem(input,3));
  }
  @Test(timeout=2000)
  public void removeEveryNthElemTest6(){
    int [] input = {2,3,5,7,-1,-100,-1000,0,80,3};
    // {2,5,-1,-1000,80}
    //{2,5,-1000,80
    int [] output = {2,5,-1000,80};    
    assertArrayEquals(output,testI.removeEveryNthElem(testI.removeEveryNthElem(testI.removeEveryNthElem(input,2),6),3));
  }
  @Test(timeout=2000)
  public void removeEveryNthElemTest7(){
    int [] input = {2,2,3,3,5,5,6,7,7,3,3,2,2};
    // {2,2,3,3,5,5,7,7,3,3,2,2}
    // {2,3,5,7,3,2}
    int [] output = {2,2,3,3,5,5,7,7,3,3,2,2};    
    assertArrayEquals(output,testI.replicateElements(testI.removeConsecDuplicates(testI.removeEveryNthElem(input,7)),2));
  }
  @Test(timeout=2000)
  public void removeEveryNthElemTest8(){
    int [] input = {2,2,3,3,5,5,6,7,7,3,3,2,2};    
    int [] output = {};    
    assertArrayEquals(output,testI.removeEveryNthElem(input,1));
  }
  
  
  //Test case for slice
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void sliceTest0(){
    char [] input = {};     
    testI.slice(input,0,0);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void sliceTest1(){
    char [] input = null;     
    testI.slice(input,3,2);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void sliceTest2(){
    char [] input = {'h','e','l','l','o'};     
    testI.slice(input,8,4);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void sliceTest3(){
    char [] input = {'h','e','l','l','o'};     
    testI.slice(input,0,6);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void sliceTest4(){
    char [] input = {'h','e','l','l','o'};     
    testI.slice(input,0,-1);
  }
  @Test(timeout=2000)
  public void sliceTest5(){
    char [] input = {'h','e','l','l','o','N','i','s','a'};     
    char [] output = {'e','l','l','o','N'};
    assertArrayEquals(output,testI.slice(input,1,5));
  }
  @Test(timeout=2000)
  public void sliceTest6(){
    char [] input = {'N','u','m','b','e','r',' ','i','s',' ','1','2','3'};     
    char [] output = {'N','u','m','b','e','r',' ','i','s'};
    char [] output2 = {' ','i','s',' '};
    char [] output3 = {' '};
    char [] output4 = {'i','s',' ','1','2','3'};
    assertArrayEquals(output,testI.slice(input,0,8));
    assertArrayEquals(output2, testI.slice(input,6,9));
    assertArrayEquals(output3, testI.slice(input,9,9));
    assertArrayEquals(output4, testI.slice(input,7,12));
  }
  // backward case no?
  @Test(timeout=2000)
  public void sliceTest7(){
    char [] input = {'S','T','A','N','L','E','Y',' ','Y','E','L','N','A','T','S'};     
    char [] output = {'S','T','A','N','L','E','Y',' '};
    char [] output2 = {'N','A','T','S','S','T','A','N'};
    char [] output3 = {'S','S','T','A','N','L','E','Y',' ','Y','E','L','N','A','T'};
    assertArrayEquals(output,testI.slice(input,0,7));
    assertArrayEquals(output2, testI.slice(input,11,3));
    assertArrayEquals(output3, testI.slice(input,14,13));
  }
  
  // test case for reverseByteOrdering
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void reverseByteOrderingTest1(){
    char [] input = null;     
    testI.reverseByteOrdering(input);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void reverseByteOrderingTest2(){
    char [] input = {'F','A','B','8','0'};     
    testI.reverseByteOrdering(input);
  }
  @Test(timeout=2000)
  public void reverseByteOrderingTest3(){
    char [] input = {};     
    assertArrayEquals(input,testI.reverseByteOrdering(input));
  }
  @Test(timeout=2000)
  public void reverseByteOrderingTest4(){
    char [] input = {'F','8'};    
    assertArrayEquals(input,testI.reverseByteOrdering(input));
  }
  @Test(timeout=2000)
  public void reverseByteOrderingTest5(){
    char [] input = {'F','8','B','5','C','A','D','F'};  
    char [] output = {'D','F','C','A','B','5','F','8'};
    assertArrayEquals(output,testI.reverseByteOrdering(input));
  }
  @Test(timeout=2000)
  public void reverseByteOrderingTest6(){
    char [] input = {'B','5','B','5','F','8'};  
    char [] output = {'F','8','B','5','B','5'};
    assertArrayEquals(output,testI.reverseByteOrdering(input));
  }
  
  // test cases for multiDimDatArray
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void multiDimDateArrayTest1(){
    testI.multiDimDateArray(-1,0);
  }
  @Test(timeout=2000)
  public void multiDimDateArrayTest2(){
    Date [][] output = new Date[0][0];
    assertArrayEquals(output,testI.multiDimDateArray(0,0));
  }
  @Test(timeout=2000)
  public void multiDimDateArrayTest3(){
    Date [][] output = new Date[0][0];
    assertArrayEquals(output,testI.multiDimDateArray(0,0));
  }
  @Test(timeout=2000)
  public void multiDimDateArrayTest4(){
    Date [][] output = new Date[3][0];
    assertArrayEquals(output,testI.multiDimDateArray(3,0));
  }
  @Test(timeout=2000)
  public void multiDimDateArrayTest5(){    
    Date [][] userOutput = testI.multiDimDateArray(3,2);
    assertEquals(true, userOutput[2][1] instanceof Date);
    for(int i = 0; i < userOutput.length; i++){
      for(int j = 0; j< userOutput[i].length; j++){
        assertEquals(true,userOutput[i][j] instanceof Date);        
      }
    }
    String outputS = "Completed";
    assertEquals(outputS, message);
  }
  @Test(timeout=2000)
  public void multiDimDateArrayTest6(){    
    Date [][] userOutput = testI.multiDimDateArray(10,10);
    assertEquals(true, userOutput[0][0] instanceof Date);
    for(int i = 0; i < userOutput.length; i++){
      for(int j = 0; j< userOutput[i].length; j++){
        assertEquals(true,userOutput[i][j] instanceof Date);
      }
    }
    String outputS = "Completed";
    assertEquals(outputS, message);
  }  
  
  // test case for nullsInArray()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void nullsInArrayTest1(){
    Object [] input = null;
    testI.nullsInArray(input);
  }
  @Test(timeout=2000)
  public void nullsInArrayTest2(){
    Object [] input = new Object[0];
    assertEquals(0,testI.nullsInArray(input));
  }
  @Test(timeout=2000)
  public void nullsInArrayTest3(){
    Object [] input = {null,0,"Hello",new StringBuffer(),null,new Date(),new char [2]};;
    assertEquals(2,testI.nullsInArray(input));
  }
  @Test(timeout=2000)
  public void nullsInArrayTest4(){
    Integer [] a = new Integer[2];
    Object [] input = {null,new Object[2],null,null,0,a[0],"null"};
    assertEquals(4,testI.nullsInArray(input));
  }
  @Test(timeout=2000)
  public void nullsInArrayTest5(){
    Object [] a = new Integer[3];
    a[2] = 1000;
    char [] b = null;
    Object [] input = {null,0,null,null,0,a[2],b,null};
    assertEquals(5,testI.nullsInArray(input));
  }
  
  // test case for multiObjectArray()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void multiObjectArray1(){   
    testI.multiObjectArray(-5);
  }
  @Test(timeout=2000)
  public void multiObjectArray2(){
    Object [] output = new Object[0];
    assertArrayEquals(output,testI.multiObjectArray(0));
  }
  //2 StringBuffers, 2 NullPointerExceptions,
  //2 ArrayIndexOutOfBoundsExceptions, and 2 Dates.
  @Test(timeout=2000)
  public void multiObjectArray3(){
    Object [] output = testI.multiObjectArray(3);
    for(int i = 0; i < output.length; i++){
      if(i <= 2){
        assertEquals(true,output[i] instanceof StringBuffer);
      }
      else if(i > 2 && i <= 5){
        assertEquals(true,output[i] instanceof NullPointerException);
      }
      else if(i > 5 && i <= 8){
        assertEquals(true,output[i] instanceof ArrayIndexOutOfBoundsException);
      }
      else{
        assertEquals(true,output[i] instanceof Date);
      }
    }
  }
  @Test(timeout=2000)
  public void multiObjectArray4(){
    Object [] output = testI.multiObjectArray(1);    
    assertEquals(true,output[0] instanceof StringBuffer);
    assertEquals(true,output[1] instanceof NullPointerException);
    assertEquals(true,output[2] instanceof ArrayIndexOutOfBoundsException);
    assertEquals(true,output[3] instanceof Date);
  }
  
  // test case for join
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void joinTest1(){
    int [] input1 = null;
    int [] input2 = {1,2,3,4};
    testI.join(input1,input2);
  }
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void joinTest2(){
    int [] input1 = {5,6,7,8};
    int [] input2 = {1,3,4,-1};
    testI.join(input1,input2);
  }
  @Test(timeout=2000)
  public void joinTest3(){
    int [] input1 = {5,6,7,8,9};
    int [] input2 = {1,3,4,5,6,100,400};
    int [] output = {1,3,4,5,5,6,6,7,8,9,100,400};
    assertArrayEquals(output,testI.join(input1,input2));
  }
  @Test(timeout=2000)
  public void joinTest4(){
    int [] input1 = {5,6,7,8,9,10,40};
    int [] input2 = {1,3,4,50};
    int [] output = {1,3,4,5,6,7,8,9,10,40,50};
    assertArrayEquals(output,testI.join(input1,input2));
  }
  @Test(timeout=2000)
  public void joinTest5(){
    int [] input1 = {};
    int [] input2 = {1,3,4,50};
    int [] output = {1,3,4,50};
    assertArrayEquals(output,testI.join(input1,input2));
  }
  @Test(timeout=2000)
  public void joinTest6(){
    int [] input1 = {5,6,7,8,9,10,40};
    int [] input2 = {};
    int [] output = {5,6,7,8,9,10,40};
    assertArrayEquals(output,testI.join(input1,input2));
  }
  public void joinTest7(){
    int [] input1 = {5};
    int [] input2 = {1};
    int [] output = {1,5};
    assertArrayEquals(output,testI.join(input1,input2));
  }
  
  
  // RECURSION PART TESTS!
  
  
  
  // Test for arrayIsPalindrome()
  @Test(timeout = 2000)
  public void arrayPalindromeTestR1(){
    char [] input = new char [0];
    assertEquals(true,testR.arrayPalindrome(input));
  }  
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void arrayPalindromeTestR2(){
    char [] input = null;
    testR.arrayPalindrome(input);
  }
  @Test(timeout = 2000)
  public void arrayPalindromeTestR3(){
    char [] input = {'S','T','A','N','L','E','Y',' ','Y','E','L','N','A','T','S'};
    assertEquals(true,testR.arrayPalindrome(input));
  }
  @Test(timeout = 2000)
  public void arrayPalindromeTestR4(){
    char [] input = {'a','b','6','a','7','6','B','a'};
    assertEquals(false,testR.arrayPalindrome(input));
  }
  @Test(timeout=2000)
  public void arrayPalindromeTestR5(){
    char [] input = {'1','2'};
    assertEquals(false,testR.arrayPalindrome(input));
    char [] input2 = {'0'};
    assertEquals(true,testR.arrayPalindrome(input2));
    char [] input3 = {'1','1'};
    assertEquals(true,testR.arrayPalindrome(input3));
  }
  
  // Test cases for nullsInArray()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void nullsInArrayTestR1(){
    Object [] input = null;
    testR.nullsInArray(input);
  }
  @Test(timeout=2000)
  public void nullsInArrayTestR2(){
    Object [] input = new Object[0];
    assertEquals(0,testR.nullsInArray(input));
  }
  @Test(timeout=10000)
  public void nullsInArrayTestR3(){
    Object [] input = new Object[60];
    assertEquals(60,testR.nullsInArray(input));
  }
  @Test(timeout=10000)
  public void nullsInArrayTestR4(){
    Object a = new Object();
    Object [] input = {null,a,2,new Date(),null,null,0,400};
    assertEquals(3,testR.nullsInArray(input));
    a = null;
    input[1] = a;
    assertEquals(4,testR.nullsInArray(input));
  }
  @Test(timeout=10000)
  public void nullsInArrayTestR5(){
    Object [] input = {4,5,new Date(), new String(), new IterationCode(),new ArrayList()};
    assertEquals(0,testR.nullsInArray(input));
    for(int i = 0; i < input.length; i++){
      if(i%2 == 1){
        input[i] = null;
      }
    }
    assertEquals(3, testR.nullsInArray(input));
  }
  
  // test for zerosInLinkedList()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void zerosInLinkedListTestR1(){
    RecursionCode.Node n = null;
    testR.zerosInLinkedList(n);
  }
  @Test(timeout=2000)
  public void zerosInLinkedListTestR2(){
    RecursionCode.Node n = new RecursionCode.Node(0);
    RecursionCode.Node n1 = new RecursionCode.Node(10);
    RecursionCode.Node n2 = new RecursionCode.Node(-10);
    RecursionCode.Node n3 = new RecursionCode.Node(0);
    RecursionCode.Node n4 = new RecursionCode.Node(0);
    n.setNext(n1);
    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    n4.setNext(new RecursionCode.Node(400));
    assertEquals(3,testR.zerosInLinkedList(n));
    RecursionCode.Node n5 = new RecursionCode.Node(0);
    n5.setNext(n4);
    n3.setNext(n5);
    assertEquals(4,testR.zerosInLinkedList(n));
  }
  @Test(timeout=2000)
  public void zerosInLinkedListTestR3(){
    RecursionCode.Node n = new RecursionCode.Node(1);    
    assertEquals(0,testR.zerosInLinkedList(n));    
    n.setNext(new RecursionCode.Node(-40));
    assertEquals(0,testR.zerosInLinkedList(n));
  }
  @Test(timeout=2000)
  public void zerosInLinkedListTestR4(){
    int count = 0;
    int [] strange = new int[50];
    Random random = new Random();
    for(int i = 0; i<strange.length; i++){
      int value = random.nextInt(20);
      strange[i] = value;
      if(value == 0){
        count++;
      }
    }
    RecursionCode.Node n = new RecursionCode.Node(strange[0]);
    RecursionCode.Node current = n;
    for(int i = 1; i < strange.length; i++){
      RecursionCode.Node temp = new RecursionCode.Node(strange[i]);
      current.setNext(temp);
      current = temp;      
    }
    assertEquals(count,testR.zerosInLinkedList(n));
  }
  @Test(timeout=2000)
  public void zerosInLinkedListTestR5(){
    RecursionCode.Node n = new RecursionCode.Node(0);
    RecursionCode.Node current = n;
    for(int i = 1; i < 10; i++){
      RecursionCode.Node temp = new RecursionCode.Node(i);
      current.setNext(temp);
      current = temp;
    }
    assertEquals(1,testR.zerosInLinkedList(n));    
  }
  
  
  // test case for multiplyNodes()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void multiplyNodesTestR1(){
    RecursionCode.Node n = null;
    testR.multiplyNodes(n);
  }
  @Test(timeout=2000)
  public void multiplyNodesTestR2(){
    RecursionCode.Node n = new RecursionCode.Node(4);
    RecursionCode.Node n1 = new RecursionCode.Node(200);
    RecursionCode.Node n2 = new RecursionCode.Node(-1);
    RecursionCode.Node n3 = new RecursionCode.Node(-20);
    RecursionCode.Node n4 = new RecursionCode.Node(20);
    n.setNext(n1);
    n1.setNext(n2);
    n2.setNext(n3);
    n3.setNext(n4);
    assertEquals(320000,testR.multiplyNodes(n));
  }
  @Test(timeout=2000)
  public void multiplyNodesTestR4(){
    RecursionCode.Node n = new RecursionCode.Node(4);
    RecursionCode.Node n1 = new RecursionCode.Node(0);
    RecursionCode.Node n2 = new RecursionCode.Node(-1);
    n.setNext(n1);
    n1.setNext(n2);    
    assertEquals(0,testR.multiplyNodes(n));
  }
  @Test(timeout=2000)
  public void multiplyNodesTestR5(){
    RecursionCode.Node n = new RecursionCode.Node(4);
    RecursionCode.Node n1 = new RecursionCode.Node(40);
    RecursionCode.Node n2 = new RecursionCode.Node(-1); 
    n.setNext(n1);
    n1.setNext(n2);
    assertEquals(-160,testR.multiplyNodes(n));
    n2.setNext(new RecursionCode.Node(20));
    RecursionCode.Node n3 = new RecursionCode.Node(2);
    n3.setNext(n);
    assertEquals(-6400,testR.multiplyNodes(n3));    
  }
  @Test(timeout=2000)
  public void multiplyNodesTestR6(){
    int [] input = new int[20];
    Random rand = new Random();
    int multiplier = 1;
    int max = 10;
    int min = 1;
    for(int i = 0; i < input.length; i++){
      int temp = rand.nextInt((max-min)+1)+min;
      input[i] = temp;
      multiplier*=temp;
    }
    RecursionCode.Node n = new RecursionCode.Node(input[0]);
    RecursionCode.Node current = n;
    for(int i = 1; i < input.length; i++){
      RecursionCode.Node temp = new RecursionCode.Node(input[i]);
      current.setNext(temp);
      current = temp;
    }
    assertEquals(multiplier,testR.multiplyNodes(n));     
  }
  
  // test cases for mergeSort()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void mergeSortTestR1(){
    int [] input = null;
    testR.mergeSort(input);
  }
  @Test(timeout=2000)
  public void mergeSortTestR2(){
    int [] input = {1};
    int [] output = {1};
    testR.mergeSort(input);
    assertArrayEquals(output,input);
    int [] input2 = {};
    int [] output2 = {};
    testR.mergeSort(input2);
    assertArrayEquals(output2, input2);
  }
  @Test(timeout=2000)
  public void mergeSortTestR3(){
    int [] input = {-1,0,9,0,8,10,200,76,10,-100,-90,82,8,9,-100};
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.mergeSort(input);
    assertArrayEquals(output,input);
    
  }
  @Test(timeout=2000)
  public void mergeSortTestR4(){
    int [] input = {5,4,3,2,1,0,1,2,3,4,5};
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.mergeSort(input);
    assertArrayEquals(output,input);    
  }  
  @Test(timeout=2000)
  public void mergeSortTestR5(){
    int [] input = {-100,-79,-2000,-1,-2,-3,-60,-1,-20,-70,-59,-30};
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.mergeSort(input);
    assertArrayEquals(output,input);    
  }
  @Test(timeout=2000)
  public void mergeSortTestR6(){
    int [] input = new int[50];
    int [] output = new int[50]; 
    testR.mergeSort(input);
    assertArrayEquals(output,input);    
  }
  @Test(timeout=2000)
  public void mergeSortTestR7(){
    int [] input = new int[10];
    Random rand = new Random();
    int max = 100;
    int min = -60;
    for(int i = 0; i < input.length; i++){
      int temp = rand.nextInt((max-min)+1)+ min;
      input[i] = temp;
    }
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.mergeSort(input);
    assertArrayEquals(output,input);    
  }
  @Test(timeout=2000)
  public void mergeSortTestR8(){
    int [] input = new int[87];
    Random rand = new Random();
    int max = 1000;
    int min = -6000;
    for(int i = 0; i < input.length; i++){
      int temp = rand.nextInt((max-min)+1)+ min;
      input[i] = temp;
    }
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.mergeSort(input);
    assertArrayEquals(output,input);    
  }
  
  
  //test case for insertionSort()
  @Test(expected=IllegalArgumentException.class,timeout=2000)
  public void insertionSortTestR1(){
    int [] input = null;
    testR.insertionSort(input);
  }
  @Test(timeout=2000)
  public void insertionSortTestR2(){
    int [] input = {0};
    int [] output = {0};
    testR.insertionSort(input);
    assertArrayEquals(output,input);
    int [] input2 = {};
    int [] output2 = {};
    testR.insertionSort(input2);
    assertArrayEquals(output2,input2);
  }
  @Test(timeout=2000)
  public void insertionSortTestR3(){
    int [] input = {-10,-50,60,20,-1,0,1,5,-2,6000,20,6001,0,-50};
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.insertionSort(input);
    assertArrayEquals(output,input);
    
  }
  @Test(timeout=2000)
  public void insertionSortTestR4(){
    int [] input = {5,4,3,2,1,0,1,2,3,4,5};
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.insertionSort(input);
    assertArrayEquals(output,input);    
  } 
  @Test(timeout=2000)
  public void insertionSortTestR5(){
    int [] input = {-100,-79,-2000,-1,-2,0,-60,1,-20,-70,-59,-30};
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.insertionSort(input);
    assertArrayEquals(output,input);    
  }
  @Test(timeout=2000)
  public void insertionSortTestR6(){
    int [] input = new int[50]; 
    int [] output = new int[50];
    testR.insertionSort(input);
    assertArrayEquals(output,input);    
  }
  @Test(timeout=2000)
  public void insertionSortTestR7(){
    int [] input = new int[10];
    Random rand = new Random();
    int max = 100;
    int min = 20;
    for(int i = 0; i < input.length; i++){
      int temp = rand.nextInt((max-min)+1)+ min;
      input[i] = temp;
    }
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.insertionSort(input);
    assertArrayEquals(output,input);    
  }
  @Test(timeout=2000)
  public void insertionSortTestR8(){
    int [] input = new int[93];
    Random rand = new Random();
    int max = 600;
    int min = -600;
    for(int i = 0; i < input.length; i++){
      int temp = rand.nextInt((max-min)+1)+ min;
      input[i] = temp;
    }
    int [] output = Arrays.copyOf(input,input.length);
    Arrays.sort(output);
    testR.insertionSort(input);
    assertArrayEquals(output,input);    
  }
  
 
 public static void main(String args[]) {
  org.junit.runner.JUnitCore.main("Project4Tests");
 }
 
 
}