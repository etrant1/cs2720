/* 

Test cases

1. Input is NULL / empty. 
If the user failed to enter a valid size
while (size < 0 || size == NULL) {
    System.out.println("Please allocate valid space.")
    Re-prompt user
}
2. Input is / is not valid
try {
    Integer.pargeInt(input[i]);
} catch (NumberFormatException e) {
    System.out.println(input + " is not a valid input.")
    i--; decrement counter for re-do
    (for loop will reprompt for valid input)
}

*/
import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many elements: ");
        int size = scanner.nextInt();

        int[] input = new int[size];
        for(int i = 0; i < size; i++)
        {   
            System.out.printf("Enter a number for element [%d] : ",i);
            input[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println("\nInput: " + Arrays.toString(input));
        
        // merge sort
        input = mergesort(input);
        System.out.println("Sorted: " + Arrays.toString(input));
        
        // remove duplcates
        System.out.print("No duplicates: ");
        removeDuplicates(input);
    }

    private static int[] mergesort(int[] n) {
        // return if input can no longer be split
        if(n.length <= 1) return n;

        // locate midpoint of array and use it as a split point
        int midpoint = (n.length / 2);
    
        // allocate space for split
        int[] left = new int[midpoint];
        int[] right = new int[n.length - midpoint];

        // populate split arrays from input
        for (int i = 0; i < left.length; i++) left[i] = n[i];
        for (int i = 0, j = midpoint; i < right.length; i++) right[i] = n[j++];
        
        // recursively sort left and right halves then save them
        left = mergesort(left);
        right = mergesort(right);

        // combine sorted sub arrays and return the result
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        // k pointer places values in the result
        // lp tracks values on the left half
        // rp tracks values on the right half
        int lp = 0, rp = 0, k = 0;

        // run comparisons while the left AND right have elements
        while (lp < left.length && rp < right.length)
        {
            if (left[lp] <= right[rp]) {
                result[k++] = left[lp++];
            }
            else {
                result[k++] = right[rp++];
            };
        };
        
        // append leftovers to result array 
        while (lp < left.length) result[k++] = left[lp++];
        while (rp < right.length) result[k++] = right[rp++];

        return result;
    }
        
    private static void removeDuplicates(int[] n) {
        // initialize a pointer to track the end of the inplace subarray
        int p = 0;  

        // overwrite values of the original array to build out the subarray
        for (int cur = 0; cur < n.length - 1; cur++)
        {
            // if next value is unique
            if (n[cur] != n[cur + 1]) 
            {
                // overwrite the current index of the subarray with the unique value, then move the pointer up
                n[p++] = n[cur];
            }
        }

        // add the last unique value of the array to the subarray and move the pointer up
        n[p++] = n[n.length - 1]; 

        // output array elements up to the pointer 
        for (int i = 0; i < p; i++)
        {
            System.out.print(n[i] + " ");
        }

        System.out.println();
    }
}
