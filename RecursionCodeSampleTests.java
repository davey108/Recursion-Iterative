import java.io.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class RecursionCodeSampleTests {
	static ByteArrayOutputStream localOut, localErr;
	static PrintStream sysOut, sysErr;
	
	// Determine what the newline is on the running system
	String newline = System.getProperty("line.separator");

	//set the print streams we will be using
	@BeforeClass
	public static void setup() throws Exception {
		sysOut = System.out;
		sysErr = System.err;
	}

	//before every test is run, reset the streams to capture stdout/stderr
	@Before
	public void setupStreams() {
		localOut = new ByteArrayOutputStream();
		localErr = new ByteArrayOutputStream();
		System.setOut(new PrintStream(localOut));
		System.setErr(new PrintStream(localErr));
	}

	//after every test, restore stdout/stderr
	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
		System.setOut(sysOut);
		System.setErr(sysErr);
	}
	
	//make sure returns false when not palindrome
	@Test(timeout=2000)
	public void arrayPalindrome01() {
		//set up array
		char[] exampleArray = {'h','e','l','l','o'};
		
		//test
		assertFalse(RecursionCode.arrayPalindrome(exampleArray));
	}
	
	//make sure returns true when palindrom
	@Test(timeout=2000)
	public void arrayPalindrome02() {
		//set up array
		char[] exampleArray = {'r','a','c','e','c','a','r'};
		
		//test
		assertTrue(RecursionCode.arrayPalindrome(exampleArray));
	}
	
	//throws correct exception
	@Test(expected=IllegalArgumentException.class,timeout=2000)
	public void arrayPalindrome03() {
		RecursionCode.arrayPalindrome(null);
	}
	
	//make sure recursive calls are happening
	@Test(timeout=2000)
	public void arrayPalindromeRecursionCheck() {
		//expected output
		String expected = "Recursion for: arrayPalindromeRecursionCheck";
		
		//actual output
		char[] exampleArray = {'r','a','c','e','c','a','r'};
		RecursionCode.arrayPalindrome(exampleArray);
		String output = localOut.toString();
		
		//assert
		assertTrue(output.startsWith(expected));
	}
	
	//count number of nulls works when all null
	@Test(timeout=2000)
	public void nullsInArray01() {
		//set up array
		Object[] exampleArray = new Object[20];
		
		//test
		int num = RecursionCode.nullsInArray(exampleArray);
		assertEquals(20, num);
	}
	
	//count number of nulls works when only some are null
	@Test(timeout=2000)
	public void nullsInArray02() {
		//set up array
		Object[] exampleArray = {new Object(), new Object(), null, new Object()};
		
		//test
		int num = RecursionCode.nullsInArray(exampleArray);
		assertEquals(1, num);
	}
	
	//make sure recursive calls are happening
	@Test(timeout=2000)
	public void nullsInArrayRecursionCheck() {
		//expected output
		String expected = "Recursion for: nullsInArrayRecursionCheck";
		
		//actual output
		Object[] exampleArray = {new Object(), new Object(), null, new Object()};
		RecursionCode.nullsInArray(exampleArray);
		String output = localOut.toString();
		
		//assert
		assertTrue(output.startsWith(expected));
	}
	
	//count number 0s when linked list is null
	@Test(timeout=2000)
	public void zerosInLinkedList01() {
		int num = RecursionCode.zerosInLinkedList(null);
		assertEquals(0, num);
	}
	
	//count number 0s when linked list has all 0s
	@Test(timeout=2000)
	public void zerosInLinkedList02() {
		RecursionCode.Node n = new RecursionCode.Node(0);
		n.setNext(new RecursionCode.Node(0));
		
		int num = RecursionCode.zerosInLinkedList(n);
		assertEquals(2, num);
	}
	
	//count number 0s when linked list has some 0s
	@Test(timeout=2000)
	public void zerosInLinkedList03() {
		RecursionCode.Node n = new RecursionCode.Node(0);
		RecursionCode.Node n1 = new RecursionCode.Node(1);
		n.setNext(n1);
		n1.setNext(new RecursionCode.Node(0));
		
		int num = RecursionCode.zerosInLinkedList(n);
		assertEquals(2, num);
	}
	
	//count number 0s when linked list has no 0s
	@Test(timeout=2000)
	public void zerosInLinkedList04() {
		RecursionCode.Node n = new RecursionCode.Node(1);
		RecursionCode.Node n1 = new RecursionCode.Node(5);
		n.setNext(n1);
		n1.setNext(new RecursionCode.Node(-1));
		
		int num = RecursionCode.zerosInLinkedList(n);
		assertEquals(0, num);
	}
	
	//make sure recursive calls are happening
	@Test(timeout=2000)
	public void zerosInLinkedListRecursionCheck() {
		//expected output
		String expected = "Recursion for: zerosInLinkedListRecursionCheck";
		
		//actual output
		RecursionCode.Node n = new RecursionCode.Node(1);
		RecursionCode.Node n1 = new RecursionCode.Node(5);
		n.setNext(n1);
		n1.setNext(new RecursionCode.Node(-1));
		RecursionCode.zerosInLinkedList(n);
		String output = localOut.toString();
		
		//assert
		assertTrue(output.startsWith(expected));
	}
	
	//throws correct exception
	@Test(expected=IllegalArgumentException.class,timeout=2000)
	public void multiplyNodes01() {
		RecursionCode.multiplyNodes(null);
	}
	
	//multiplies correctly
	@Test(timeout=2000)
	public void multiplyNodes02() {
		RecursionCode.Node n = new RecursionCode.Node(5);
		n.setNext(new RecursionCode.Node(0));
		
		int num = RecursionCode.multiplyNodes(n);
		assertEquals(0, num);
	}
	
	//multiplies correctly
	@Test(timeout=2000)
	public void multiplyNodes03() {
		RecursionCode.Node n = new RecursionCode.Node(4);
		RecursionCode.Node n1 = new RecursionCode.Node(2);
		n.setNext(n1);
		n1.setNext(new RecursionCode.Node(3));
		
		int num = RecursionCode.multiplyNodes(n);
		assertEquals(24, num);
	}
	
	//make sure recursive calls are happening
	@Test(timeout=2000)
	public void multiplyNodesRecursionCheck() {
		//expected output
		String expected = "Recursion for: multiplyNodesRecursionCheck";
		
		//actual output
		RecursionCode.Node n = new RecursionCode.Node(4);
		RecursionCode.Node n1 = new RecursionCode.Node(2);
		n.setNext(n1);
		n1.setNext(new RecursionCode.Node(3));
		RecursionCode.multiplyNodes(n);
		String output = localOut.toString();
		
		//assert
		assertTrue(output.startsWith(expected));
	}
	
	//throws correct exception
	@Test(expected=IllegalArgumentException.class,timeout=2000)
	public void mergeSort01() {
		RecursionCode.mergeSort(null);
	}
	
	//sorts list
	@Test(timeout=2000)
	public void mergeSort02() {
		int[] array = {4,3,0,1,2,-1,4,2,44,1,-22};
		int[] expected = {-22,-1,0,1,1,2,2,3,4,4,44};
		
		RecursionCode.mergeSort(array);
		assertArrayEquals(expected, array);
	}
	
	//make sure recursive calls are happening
	@Test(timeout=2000)
	public void mergeSortRecursionCheck() {
		//expected output
		String expected = "Recursion for: mergeSortRecursionCheck";
		
		//actual output
		int[] array = {4,3,0,1,2,-1,4,2,44,1,-22};
		RecursionCode.mergeSort(array);
		String output = localOut.toString();
		
		//assert
		assertTrue(output.startsWith(expected));
	}
	
	//throws correct exception
	@Test(expected=IllegalArgumentException.class,timeout=2000)
	public void insertionSort01() {
		RecursionCode.insertionSort(null);
	}
	
	//sorts list
	@Test(timeout=2000)
	public void insertionSort02() {
		int[] array = {4,3,0,1,2,-1,4,2,44,1,-22};
		int[] expected = {-22,-1,0,1,1,2,2,3,4,4,44};
		
		RecursionCode.insertionSort(array);
		assertArrayEquals(expected, array);
	}
	
	//make sure recursive calls are happening
	@Test(timeout=2000)
	public void insertionSortRecursionCheck() {
		//expected output
		String expected = "Recursion for: insertionSortRecursionCheck";
		
		//actual output
		int[] array = {4,3,0,1,2,-1,4,2,44,1,-22};
		RecursionCode.insertionSort(array);
		String output = localOut.toString();
		
		//assert
		assertTrue(output.startsWith(expected));
	}
	
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("RecursionCodeSampleTests");
	}
	
	public static void hasRecursion() {
		StackTraceElement[] trace = Thread.currentThread().getStackTrace();
		String method1 = trace[2].getMethodName();
		String method2 = trace[3].getMethodName();
		String method3 = trace[4].getMethodName();
		
		if(method1.equals(method2) && method2.equals(method3)) {
			for(int i = trace.length-1; i > 0; i--)
				if(trace[i].getMethodName().endsWith("RecursionCheck"))
					System.out.println("Recursion for: " + trace[i].getMethodName());
		}
	}
}