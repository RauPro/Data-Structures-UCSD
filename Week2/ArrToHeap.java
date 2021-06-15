import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ArrToHeap {
	private static List<Swap> swaps;
	static int[] data;
	static int n;
	static class Swap {
		int index1;
		int index2;

		public Swap(int index1, int index2) {
			this.index1 = index1;
			this.index2 = index2;
		}
	}
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
		n = fs.nextInt();
		data = fs.readArray(n);
		generateSwaps();
		System.out.println(swaps.size());
		for (Swap s: swaps){
			System.out.println(s.index1+" "+s.index2);
		}
    }


	static void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && greater(j, j+1)) {
				j++;
			}
			if (!greater(k, j)) {
				break;
			}
			swap(data, k, j);
			k = j;
		}
	}

	static boolean greater(int i, int j) {
		return data[i] > data[j];
	}

	static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
		swaps.add(new Swap(i - 1, j - 1));
	}
	static void generateSwaps() {
		swaps = new ArrayList<Swap>();

		for (int i = n / 2; i >= 1; i--) {
			sink(i);
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
            int[] a = new int[n+1];
            for (int i = 1; i <= n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
