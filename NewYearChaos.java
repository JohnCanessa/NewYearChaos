import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 
 */
public class NewYearChaos {


    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     * Failed to pass initial test set.
     */
    public static void minimumBribes0(List<Integer> q) {

        // **** initialization ****
        int bribes = 0;

        // **** traverse the q forwards ****
        for (int i = 0; i < q.size() - 1; i++) {

            // **** person (for ease of use) ****
            int p = q.get(i);

            // **** check if this person used a bribe ****
            if (p - (i + 1) > 0 ) {

                // ???? ????
                System.out.println("<<< p: " + p + " (p - (i + 1)): " + (p - (i + 1)));

                // **** check if this person is chaotic ****
                if (p - (i + 1) >= 3) {
                    System.out.println("Too chaotic");
                    return;
                }

                // **** increment the bribe count ****
                bribes += (p - (i + 1));
            }
        }

        // **** display # of bribes ****
        System.out.println(bribes);
    }

    
    /**
     * Auxiliary function.
     * Swaps two elements in the array.
     * Was: Integer[] and then swapped to int[]
     */
    static private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i]  = arr[j];
        arr[j]  = tmp;
    }


    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     * 
     * Execution: O(n)
     */
    public static void minimumBribes(List<Integer> q) {

        // **** initialization ****
        int bribes  = 0;
        int tmp     = 0;

        // **** generate array from queue (for ease of use) ****
        // Integer[] arr = q.toArray(Integer[]::new);
        int[] arr = new int[q.size()];
        for (int i = 0; i < arr.length; i++)
            arr[i] = q.get(i);

        // ???? ????
        System.out.println("<<< bribes: " + bribes + " arr: " + Arrays.toString(arr));

        // **** traverse the array backwards swapping people back in place ****
        for (int i = arr.length - 1; i > 0; i--) {

            // **** person in proper place in the queue ****
            if (arr[i] == (i + 1))
                continue;

            // **** swap people one appart ****
            else if (arr[i - 1] == (i + 1)) {

                // **** ****
                // swap(arr, i - 1, i);
                tmp         = arr[i - 1];
                arr[i - 1]  = arr[i];
                arr[i]      = tmp;

                // **** increment bribe count ****
                bribes++;
            }

            // **** swap people two appart ****
            else if (arr[i - 2] == (i + 1)) {

                // **** ****
                // swap(arr, i - 2, i - 1);
                tmp         = arr[i - 2];
                arr[i - 2]  = arr[i - 1];
                arr[i - 1]  = tmp;

                // swap(arr, i - 1, i);
                tmp         = arr[i - 1];
                arr[i - 1]  = arr[i];
                arr[i]      = tmp;

                // **** increment bribe count ****
                bribes += 2;
            }

            // **** too many swaps ****
            else {
                System.out.println("Too chaotic");
                return;
            }

            // ???? ????
            System.out.println("<<< bribes: " + bribes + " arr: " + Arrays.toString(arr));
        }

        // **** display # of bribes ****
        System.out.println(bribes);
    }


    /**
     * Test scaffold
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** skip # of test cases ****
        br.readLine();

        // **** skip # of elements in the queue ****
        br.readLine();

        // **** read the list of integers ****
        List<Integer> q = Arrays.stream(br.readLine().trim().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

        // **** close buffered reader ****
        br.close();

        // ???? ????
        System.out.println("main <<< q: " + q.toString());

        // **** call the function of interest which displays result ****
        minimumBribes(q);
    }
}