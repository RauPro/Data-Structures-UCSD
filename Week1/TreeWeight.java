import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TreeWeight {
    public static class Height {
        int n;
        ArrayList<ArrayList<Integer>> children;
        int root;
        void read() {
            FastScanner fs = new FastScanner();
            n = fs.nextInt();
            children = new ArrayList<ArrayList<Integer>>(n);
            for(int i = 0;i< n;i++)
                children.add(new ArrayList<Integer>());
            for (int i = 0; i < n; i++) {

                int parent = fs.nextInt();
                if(parent == -1)
                    root = i;
                else {
                    children.get(parent).add(i);
                }
            }
        }

        int compute(int root){
            int max = 0;
            for (int i = 0;i < children.get(root).size();i++){
                max = Math.max(max,compute(children.get(root).get(i)));
            }
            return max + 1;
        }
        int computeHeight() {
            return compute(root);
        }
    }
    public static void main(String[] args) {
        Height tree = new Height();
        tree.read();
        System.out.println(tree.computeHeight());
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
