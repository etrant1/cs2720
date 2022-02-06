import java.util.Arrays;

public class RemoveDuplicates
{
    public static void main(String[] args) {
        int[] input = {50, 11, 33, 21, 40, 50, 40, 40, 21};
        System.out.printf("Input: %s\n",Arrays.toString(input));

        bubbleSort(input);
        removeDups(input);
    }    

    public static void bubbleSort(int[] arr) {
        // Bubble sort with early termination

        for (int i = 0; i < arr.length - 1; i++)
        {
            boolean swapped = false; 
            for (int j = 0; j < (arr.length - 1) - i; j++)
            {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                }
            }
            if (swapped == false) break;
        }

        System.out.printf("Sorted: %s\n",Arrays.toString(arr));
    }

    public static void removeDups(int[] arr) {
        /*
        Task: Remove duplicates from a sorted array in O(N) time and O(1) space.

        Approach: Overwrite the original array's duplicate elements such that no elements are repeated.
        Then, load the array into stdout up to the last unique element of the sub-array.
        */

        int ptr = 0; // Initialize a variable to serve as a moving pointer which will track the end of the sub-array 
        for (int cur = 0; cur < arr.length - 1; cur++)
        {
            if (arr[cur] != arr[cur + 1]) // If the next index is not a duplicate of the current index
            {
                arr[ptr] = arr[cur]; // Set the index of the sub array to the current index
                ptr++; // Then move the pointer up
            }
            /* 
            Until a unique value is found, the pointer does not move and the sub-array does not change.
            
            This approach's space complexity is constant as the procedure does not allocate additional space
            and uses only what it was provided.
            */
        }

        arr[ptr] = arr[arr.length - 1]; // Grab the last element of the original array
        ptr++; // Move the pointer up to accomodate

        System.out.print("No Duplicates: ");

        for (int i = 0; i < ptr; i++) // Load the array into stdout up to the last unique element of the sub-array.
        {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}