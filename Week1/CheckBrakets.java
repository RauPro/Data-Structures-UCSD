import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CheckBrakets {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        String str=fs.next();
        int index=0,a=0;
        boolean balance=true;
        char top;
        char[] str1 = str.toCharArray();
        Stack<Character> s1 = new Stack<>();
        while(index<str1.length) {
            if (s1.empty())
                a=index;
            if(str1[index]=='['||str1[index]=='{'||str1[index]=='(')
                s1.push(str1[index]);
            else
            {
                if((str1[index]==']'||str1[index]=='}'||str1[index]==')'))
                {
                    if(s1.empty())
                    {
                        balance=false;
                        break;
                    }
                    else
                    {
                        top=s1.pop();
                        if(( top =='[' && str1[index]!=']')||( top=='{' && str1[index]!='}')||( top=='(' && str1[index]!=')'))
                        {
                            balance=false;
                            break;
                        }
                    }
                }
            }
            index+=1;
        }
        if(balance&&s1.empty())
            System.out.println("Success");
        else
        {
            if((index>=str1.length)&&!s1.empty())
                System.out.println(a+1);
            else
                System.out.println(index+1);
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
