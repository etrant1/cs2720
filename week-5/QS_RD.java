import java.util.Arrays;
import java.util.Scanner;

class QS_RD 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for length of array
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();

        // Allocating space
        int[] input = new int[size];

        // Populating array
        for (int i = 0; i < size; i++) 
        {
            System.out.printf("input[%d] : ",i);
            input[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println("Before: " + Arrays.toString(input));
        quicksort(input, 0, size - 1);

        System.out.println("After quicksort: " + Arrays.toString(input));

        System.out.print("After removeDuplicates: ");
        removeDuplicates(input);

    }
    
    // Quick sort
    private static void quicksort(int[] a, int lowIndex, int highIndex)
    {
        // Exit case, single element arrays are sorted by nature
        if (lowIndex > highIndex) return;

        // Select a pivot point to which everything to the pivot's left is smaller and to its right is larger
        int pivot = a[highIndex]; 

        // Pointers to target elements for swap in the low and high ends of the sub array
        int lp = lowIndex;
        int rp = highIndex;

        // Call to partition helper function
        partition(a, lp, rp, pivot, lowIndex, highIndex);
    }

    // Partition helper
    private static void partition(int[] a, int lp, int rp, int pivot, int lowIndex, int highIndex) { 
        // Monitor if the left pointer and right pointer have met (we will swap the pivot with this meeting point)
        while (lp < rp) 
        {
            // Move forward until a number greater than the pivot is hit
            while (a[lp] <= pivot && lp < rp) lp++;
            
            // Move backwards until a number less than the pivot is hit
            while (a[rp] >= pivot && lp < rp) rp--;
            
            // Swap left and right pointer values
            swap(a, lp, rp);
        }

        // In case the selected pivot is the highest element, prevent misplacement
        if(a[lp] > a[highIndex]) {
			swap(a, lp, highIndex);
		}
		else {
			lp = highIndex;
		}

        // Recursive calls to sort left and right halves
        quicksort(a, lowIndex, lp-1);
        quicksort(a, lp+1, highIndex);
    }

    // Swap helper
    private static void swap(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp; 
    }

    // removeDuplicates, in place
    private static void removeDuplicates(int[] a) {
        // Intialize a pointer to track the size of the subarray
        int ptr = 0;  
        // Transverse the array
        for (int cur = 0; cur < a.length-1; cur++)
        {
            // Check if the next value is unique
            if (a[cur] != a[cur+1]) 
            {
                // Build the subarray by overwriting old values
                a[ptr] = a[cur];
                // Increment the size of the subarray
                ptr++; 
            }
        }

        // Grab the last unique value
        a[ptr] = a[a.length-1]; 
        ptr++;

        // Output the resulting sub-array
        for (int i = 0; i < ptr; i++)
        {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}