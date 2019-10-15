import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Uva_10685 {
    static int[] res = new int[5001];
    static int[] parent = new int[5001];
    static int find(int x){
        if(parent[x] == x)
            return x;
        else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
    static void union(int u,int v){
        int rootX = find(u);
        int rootY = find(v);
       // System.out.println("Rootx : " + rootX + "rootY : " + rootY);
        if(rootX != rootY){
            parent[rootX] = rootY;
            res[rootY] += res[rootX];
        }
     }
    public static void main(String[] args) {
        FastReader input = new FastReader();
        while (true){
            int c = input.nextInt();
            int r = input.nextInt();
            if(c == 0 && r == 0){
                break;
            }
            Map<String,Integer> map = new HashMap<String,Integer>();
            for(int i = 0;i < c;i++){
                String s = input.nextLine();
                map.put(s,i);
                res[i] = 1;
                parent[i] = i;
            }
            for(int i = 0;i < r;i++){
                String s1 = input.next();
                String s2 = input.next();
                union(map.get(s1),map.get(s2));
            }
            int max = Integer.MIN_VALUE;
            for(int i = 0;i < c;i++){
                max = Math.max(max,res[i]);
            }
            System.out.println(max);
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
