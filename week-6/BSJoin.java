/*
Test cases:
1. No input
if (a1 == NULL || a2 == NULL) {
    System.out.println("No input");
    Re-prompt user for input to both arrays
}

2. Missing a second input
if (a2.length < 1 || a2 == NULL){
    return a1;
}

3. Input array length of 1 for both arrays
bsjoin(a1,a2);
print the combined result 
*/
import java.util.Arrays;

public class BSJoin {
    public static void main(String[] args) {
        int[] a1 = {1,5,6,6,9,9,9,11,11,21};
        int[] a2 = {6,6,9,11,21,21,21};

        System.out.println("Input 1: " + Arrays.toString(a1));
        System.out.println("Input 2: " + Arrays.toString(a2));

        System.out.println("Binary-Search-Join result: " + Arrays.toString(bsjoin(a1,a2)));
    }

    private static int[] bsjoin(int[] n, int[] m) {
        int[] result = new int[n.length * m.length];

        // pointer to track the end of the result array for clean up
        int k = 0;
        // n is treated as an array of querys to the 'index' m
        for (int query : n) {
            // first ensure the query is unique and if its not, move from the current query
            if(k > 0 && query == result[k-1]) continue;
            // if the query exists and is unique, add it to result and move the pointer up
            if(binarySearch(m, 0, m.length, query) > -1) result[k++] = query;
        }

        // clean up the final result by only keeping values up to the cutoff
        int[] temp = new int[k];
        for(int i = 0; i < k; i++) {
            temp[i] = result[i];
        }

        // overwrite result with the temp array
        result = temp;

        return result;
    }
    private static int binarySearch(int[] a, int start, int end, int query){
        // if we cannot split any further, the element does not exist here
        if (start > end) return -1;
        
        int midpoint = (start + end) / 2;

        // if we've found the query in the array, return its index
        if (a[midpoint] == query) return midpoint;
        // if the query is smaller than the midpoint, check the left before the midpoint
        if (query < a[midpoint]) return binarySearch(a, start, midpoint - 1, query);
        // if the query is larger than the midpoint, check the right after the midpoint
        if (query > a[midpoint]) return binarySearch(a, midpoint + 1, end, query);

        // if we've still found nothing
        return -1;
    }
}

/* 
Optimization to O(n + m)
If we wanted to leverage the fact the the inputs are already stored and obtain O(n + m) time complexity we could:
1. We must ensure programmically there are no duplicates in the first array (linear time operation) O(n)
2. We must ensure programmically there are no duplicates in the second array (linear time operation) O(m)
3. We must allocate enough space to hold the arrays, and join them without unsorting them or worrying about duplicates
4. Finally, we return the result which will consist of all the duplicates found by iterating over the array of the step prior
*/