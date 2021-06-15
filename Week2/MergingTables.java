import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergingTables {
    static int maximumNumberOfRows = -1;

   static void merge(Table destination, Table source) {
        Table realDestination = destination.getParent();
        Table realSource = source.getParent();
        if (realDestination == realSource) {
            return;
        }
        if (realDestination.rank < realSource.rank){
            realDestination.parent = realSource;
            realSource.numberOfRows+=realDestination.numberOfRows;
            realDestination.numberOfRows=0;
        }
        else if (realDestination.rank > realSource.rank){
            realSource.parent = realDestination;
            realDestination.numberOfRows+=realSource.numberOfRows;
            realSource.numberOfRows=0;
        }
        else {
            realSource.parent = realDestination;
            realDestination.numberOfRows+=realSource.numberOfRows;
            realSource.numberOfRows=0;
            realDestination.rank++;  // if the rank are equal
        }

        int total = realDestination.numberOfRows + realSource.numberOfRows;
        if (total > maximumNumberOfRows) {
            maximumNumberOfRows = total;
        }

    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        Table[] arr = new Table[n];
        int[] rows = fs.readArray(n);
        for (int i=0; i<n;i++) {
            arr[i] = new Table(rows[i]);
            maximumNumberOfRows = Math.max(maximumNumberOfRows, rows[i]);
        }
        for (int i = 0; i < m; i++) {
            int destination = fs.nextInt() - 1;
            int source = fs.nextInt() - 1;
            merge(arr[destination], arr[source]);
            System.out.println(maximumNumberOfRows);
        }

    }
    static class Table {
        Table parent;
        int rank;
        int numberOfRows;

        Table(int numberOfRows) {
            this.numberOfRows = numberOfRows;
            rank = 0;
            parent = this;
        }

        Table getParent() {
            if (parent != this) {
                parent= parent.getParent();
            }
            return parent;
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
