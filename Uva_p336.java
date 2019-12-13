import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Uva_p336 {
    static int bfs(int start,LinkedList<Integer>[] list,int[] level,int noOfNodes){
        int found = 0;
        boolean[] visited = new boolean[noOfNodes];
        visited[start] = true;
        found++;
        level[start] = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        while (!queue.isEmpty()){
            int top = queue.poll();
            for(int i : list[top]){
                if(!visited[i]){
                    visited[i] = true;
                    found++;
                    level[i] = level[top] + 1;
                    queue.add(i);
                }
            }
        }
        return found;
    }
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int edges,src,dest,id,u,v,x,ttl,cs = 1;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        while (true){
            edges = input.nextInt();
            if(edges == 0){
                break;
            }
            else{
                map.clear();
                id = 0;
                LinkedList<Integer>[] list = new LinkedList[1000];
                for(int i = 0;i < 1000;i++){
                    list[i] = new LinkedList<Integer>();
                }
                for(int i = 0;i < edges;i++){
                    src = input.nextInt();
                    if(!map.containsKey(src)){
                        map.put(src,id);
                        id++;
                    }
                    dest = input.nextInt();
                    if(!map.containsKey(dest)){
                        map.put(dest,id);
                        id++;
                    }
                    u = map.get(src);
                    v = map.get(dest);
                    list[u].add(v);
                    list[v].add(u);
                }
                int noOfNodes = map.size();
                while (true){
                    x = input.nextInt();
                    ttl = input.nextInt();
                    if(x == 0 && ttl == 0){
                        break;
                    }
                    else{
                        int[] level = new int[map.size()];
                        int start = map.get(x);
                        int found = bfs(start,list,level,noOfNodes);
                        int count = 0;
                        for(int i : level){
                            if(i > ttl){
                                count++;
                            }
                        }
                        count = count + map.size() - found;
                        System.out.println("Case " + cs + ": " + count + " nodes not reachable from node " +  x + " with TTL = " + ttl + ".");
                        cs++;
                    }
                }
            }
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
