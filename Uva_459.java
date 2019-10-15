import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Uva_459 {

    static int[] p = new int[26];
    static int[] r = new int[26];

    static void init(int n){
        while (n >= 0){
            p[n] = n;
            r[n] = 1;
            n--;
        }
    }
    static int find(int x){
        if(p[x] == x)
            return x;
        else{
            p[x] = find(p[x]);
        }
        return p[x];
    }


    static int union(int x,int y){
        x = find(x);
        y = find(y);
        if(x != y){
            if(r[x] > r[y]){
                r[x] += r[y];
                p[y] = x;
            }
            else{
                r[y] += r[x];
                p[x] = y;
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        System.out.println();
        while (t > 0){
            String c = input.nextLine();
            char max = c.charAt(0);
            init(max - 'A');
            int ans = max - 'A' + 1;
            while (true){
                String s = input.nextLine();
                if(s.isEmpty()){
                    break;
                }
                ans -= union(s.charAt(0) - 'A',s.charAt(1) - 'A');
            }
            System.out.println(ans);
            t--;
        }
    }
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
