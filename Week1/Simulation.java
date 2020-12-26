import java.io.*;
import java.util.*;

class Simulation {

    static ArrayList<Integer> findKMaxElement(int[] arr,
                                              int k, int n)
    {
        // creating the max heap ,to get max element always
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Collections.reverseOrder());

        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;

        for (; i < k; i++)
            queue.add(arr[i]);

        // adding the maximum element among first k elements
        res.add(queue.peek());

        // removing the first element of the array
        queue.remove(arr[0]);

        // iterarting for the next elements
        for (; i < n; i++) {

            // adding the new element in the window
            queue.add(arr[i]);

            // finding & adding the max element in the
            // current sliding window
            res.add(queue.peek());

            // finally removing the first element from front
            // end of queue
            queue.remove(arr[i - k + 1]);
        }

        return res;

    }

    public static void main(String[] args)
    {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int arr[] = fs.readArray(n);
        int k = fs.nextInt();
        int size = arr.length;

        List<Integer> res = findKMaxElement(arr, k, size);
        for (int x : res)
            System.out.print(x + " ");
    }
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}