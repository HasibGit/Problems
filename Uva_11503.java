import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Uva_11503 {

    static int[] parent;
    static int[] rank;
    static int[] res;
    static class Edge{
        String src;
        String dest;
        Edge(String src,String dest){
            this.src = src;
            this.dest = dest;
        }
    }
    static int find(int x){
        if(parent[x] == x){
            return x;
        }
        else{
          parent[x] = find(parent[x]);
          return parent[x];
        }
    }
    static int union(int u,int v){
        int xRoot = find(u);
        int yRoot = find(v);
        if(xRoot == yRoot){
            return res[xRoot];
        }
        else{
            if(rank[xRoot] == rank[yRoot]){
                parent[xRoot] = yRoot;
                rank[yRoot]++;
                res[yRoot] += res[xRoot];
                return res[yRoot];
            }
            else if(rank[xRoot] < rank[yRoot]){
                parent[xRoot] = yRoot;
                res[yRoot] += res[xRoot];
                return res[yRoot];
            }
            else if(rank[xRoot] > rank[yRoot]){
                parent[yRoot] = xRoot;
                res[xRoot] += res[yRoot];
                return res[xRoot];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        while (t > 0){
            int edges = input.nextInt();
            ArrayList<Edge> list = new ArrayList<Edge>();
            Set<String> set = new HashSet<String>();
            for(int i = 0;i < edges;i++){
                String src = input.next();
                String dest = input.next();
                list.add(new Edge(src,dest));
                set.add(src);
                set.add(dest);
            }
            ArrayList<String> list2 = new ArrayList<String>(set);
            Map<String,Integer> map = new HashMap<String,Integer>();
            parent = new int[list2.size()];
            rank = new int[list2.size()];
            res = new int[list2.size()];
            for(int i = 0;i < list2.size();i++){
                map.put(list2.get(i),i);
                parent[i] = i;
                rank[i] = 0;
                res[i] = 1;
            }
            for(Edge e : list){
                String s1 = e.src;
                String s2 = e.dest;
                System.out.println(union(map.get(s1),map.get(s2)));
            }
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
