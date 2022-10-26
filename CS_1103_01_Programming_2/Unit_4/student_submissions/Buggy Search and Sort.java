import java.util.Arrays;

public class BuggySearchAndSort {
	
	public static void main(String[] args) {
		
		int[] A = new int[10];
		for (int i = 0; i < 10; i++)
			A[i] = 1 + (int)(10 * Math.random());
		
		int[] B = A.clone();
		int[] C = A.clone();
		int[] D = A.clone();
		
		System.out.print("The array is:");
		printArray(A);
		
		if (contains(A,5))
			System.out.println("This array DOES contain 5.");
		else
			System.out.println("This array DOES NOT contain 5.");
		
		Arrays.sort(A); 
		System.out.print("Sorted by Arrays.sort():  ");
		printArray(A); 
		bubbleSort(B);
		System.out.print("Sorted by Bubble Sort:    ");
		printArray(B);
		selectionSort(C);
		System.out.print("Sorted by Selection Sort: ");
		printArray(C);	
		insertionSort(D);
		System.out.print("Sorted by Insertion Sort: ");
		printArray(D);

	}
	
	/**
	 * Tests whether an array of ints contains a given value.
	 * @param array a non-null array that is to be searched
	 * @param val the value for which the method will search
	 * @return true if val is one of the items in the array, false if not
	 */
	public static boolean contains(int[] array, int val) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == val)
				return true;
			else
				return false;
		}
		return false;
	}
	
	/**
	 * Sorts an array into non-decreasing order.  This inefficient sorting
	 * method simply sweeps through the array, exchanging neighboring elements
	 * that are out of order.  The number of times that it does this is equal
	 * to the length of the array.
	 */
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-1; j++) {//<--- i instead of j
                            /*
                                So basically the wrong initialization variable was being incremented
                                so i changed i for j and that was the fix
                            */
				if (array[j] > array[j+1]) { // swap elements j and j+1
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * Sorts an array into non-decreasing order.  This method uses a selection
	 * sort algorithm, in which the largest item is found and placed at the end of 
	 * the list, then the second-largest in the next to last place, and so on.
	 */
	public static void selectionSort(int[] array) {
		for (int top = array.length - 1; top > 0; top--) {
			int positionOfMax = 0;
			for (int i = 1; i <= top; i++) {
				if (array[i] > array[positionOfMax])//<--- change array[1] to array[i]
                            /*
                                    The array index was set at 1 so that the left part of the expression
                                    inside the IF was always the same value of the second item of the array
                                    
                            */
					positionOfMax = i;
			}
			int temp = array[top];  // swap top item with biggest item
			array[top] = array[positionOfMax];
			array[positionOfMax] = temp;
		}
	}
	
	/**
	 * Sorts an array into non-decreasing order.  This method uses a standard
	 * insertion sort algorithm, in which each element in turn is moved downwards
	 * past any elements that are greater than it.
	 */
	public static void insertionSort(int[] array) {
		for (int top = 1; top < array.length; top++) {
			int temp = array[top];  // copy item that into temp variable
			int pos = top - 1;
			while (pos >= 0 && array[pos] > temp) {//<-- pos > 0   to   pos >= 0
                            /*
                                    inside the while loop expression pos was never allowed to get to 0
                                    so I changed pos > 0   to   pos >= 0
                            */
				   // move items that are bigger than temp up one position
				array[pos+1] = array[pos];
                                array[pos] = temp;//<<<<--------moved this from after the while loop
                                /*
                                    array[pos] = temp; was placed outside the loop block
                                    so the that item of the array was never taken care of in the right place
                                    right above here
                            */
				pos--;
			}
//			array[pos] = temp;  // place temp into last vacated position <<<<<---------moved inside while loop before pos--
		}
	}
	
	/**
	 * Outputs the ints in an array on one line, separated by spaces,
	 * with a line feed at the end.
	 */
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println();
	}

}