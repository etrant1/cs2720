import java.util.Arrays;
import java.util.Random;

/* TODO
* Comments for elaborate recursion
* Comment for weird case of highIndex being the pivot
* Comment test cases 
* Polish
*/


class QS_RD 
{
    public static void main(String[] args) {
        Random random = new Random();
        int[] input = random.ints(10, 1, 10).toArray();

        System.out.println("Before: " + Arrays.toString(input));
        quicksort(input, 0, input.length - 1);
        System.out.println("After quicksort: " + Arrays.toString(input));
        System.out.print("After removeDuplicates: ");
        removeDuplicates(input);

    }
    
    // Quick sort
    private static void quicksort(int[] a, int lowIndex, int highIndex)
    {
        if (lowIndex > highIndex) return;

        int pivot = a[highIndex]; // target to compare against

        int lp = lowIndex;
        int rp = highIndex;

        System.out.println("Partitioning...");
        partition(a, lp, rp, pivot, lowIndex, highIndex);
    }

    // Partition helper
    private static void partition(int[] a, int lp, int rp, int pivot, int lowIndex, int highIndex) { 
        while (lp < rp) 
        {
            while (a[lp] <= pivot && lp < rp)
            {
                lp++;
            }
            while (a[rp] >= pivot && lp < rp)
            {
                rp--;
            }
            swap(a, lp, rp);
        }

        if(a[lp] > a[highIndex]) {
			swap(a, lp, highIndex);
		}
		else {
			lp = highIndex;
		}

        quicksort(a, lowIndex, lp - 1);
        quicksort(a, lp+1, highIndex);
    }

    // Swap helper
    private static void swap(int[] a, int index1, int index2) {
        System.out.println("Swapping...");
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp; 
    }

    // removeDuplicates
    private static void removeDuplicates(int[] a) {
        int ptr = 0;  
        for (int cur = 0; cur < a.length - 1; cur++)
        {
            if (a[cur] != a[cur + 1]) 
            {
                a[ptr] = a[cur];
                ptr++; 
            }
        }

        a[ptr] = a[a.length - 1]; 
        ptr++;

        for (int i = 0; i < ptr; i++)
        {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}