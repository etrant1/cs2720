import java.util.ArrayList;
import java.util.Arrays;

public class DeDuplicate
{
    /* 
    -- test cases
    $ Array does not exist error
    $ Single element arrays are already sorted (n==1)
    $ User made arrays (scan loop)
    $ User dictates array length?
    */

    public static void main(String[] args) {
        int[] arr = {50, 11, 33, 21, 40, 50, 40, 40, 21};
        int N = arr.length;

        System.out.printf("Input: %s\n",Arrays.toString(arr));

        // bubble sort O(n^2)
        for (int i = 0; i < N - 1; i++)
        {
            for (int j = 0; j < (N - 1) - i; j++)
            {
                // swap
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.printf("Sorted: %s\n",Arrays.toString(arr));

        int j = 0;
        for (int cur = 0; cur < N - 1; cur++)
        {
            if (arr[cur] != arr[cur+1])
            {
                arr[j] = arr[cur];
                j++;
            }
        }

        arr[j] = arr[N-1];
        j++;  

        System.out.print("Removed Duplicates: [ ");

        for (int i = 0; i < j; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }    
}