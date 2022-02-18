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

public class LoopJoin {
    public static void main(String[] args) {
        int[] a1 = {1,5,6,6,9,9,9,11,11,21};
        int[] a2 = {6,6,9,11,21,21,21};

        System.out.println("Input 1: " + Arrays.toString(a1));
        System.out.println("Input 2: " + Arrays.toString(a2));

        System.out.println("Loop-join result: " + Arrays.toString(loopjoin(a1,a2)));
    }

    private static int[] loopjoin(int[] n, int[] m) {
        // allocate worst case space for result array
        int[] result = new int[n.length * m.length];

        // create a pointer to track the joined array size
        int k = 0;

        // compare every element in n to m
        for (int x : n) {
            for (int y : m) {
                // if the join candidate is not unique to the result array, move to the next candidate
                if (k > 0 && x == result[k-1]) break;
                // if the join candidate is unique to the result array, add it to the result, and move the pointer 'k' up
                if (x == y) result[k++] = x;
            }
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
}