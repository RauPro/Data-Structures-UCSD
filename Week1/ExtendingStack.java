import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ExtendingStack {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int t= fs.nextInt();
        Stack<Integer> stack = new Stack<>();

        while (t!=0){
            int aws = 0;
            String instruction = fs.next();
            if (instruction.equals("push")){
                int n = fs.nextInt();
                stack.push(n);
            }else if(instruction.equals("max")){
                for (int i= 0; i < stack.size(); i++) {
                    aws=Math.max(aws,stack.get(i));
                }
                System.out.println(aws);
            }else if(instruction.equals("pop")){
                stack.pop();
            }
            t--;
        }
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
