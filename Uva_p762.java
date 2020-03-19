import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Uva_p762 {
    static LinkedList<String> list[] = new LinkedList[100005];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean primra = false;
        while (input.hasNext()){
            int edges = input.nextInt();
            Map<String,Integer> map = new HashMap<String,Integer>();
            int mark = 1;
            for(int i = 0;i < 100005;i++){
                list[i] = new LinkedList<String>();
            }
            for(int i = 0;i < edges;i++){
                String s1 = input.next();
                String s2 = input.next();
                if(map.get(s1) == null){
                    map.put(s1,mark);
                    mark++;
                }
                if(map.get(s2) == null){
                    map.put(s2,mark);
                    mark++;
                }
                list[map.get(s1)].add(s2);
                list[map.get(s2)].add(s1);
            }
//            for(Map.Entry m : map.entrySet()){
//                System.out.println(m.getKey() + " " + m.getValue());
//            }
            String src = input.next();
            String dest = input.next();
            if(primra){
                System.out.println();
            }
            primra = true;
            LinkedList<String> queue = new LinkedList<String>();
            boolean[] visited = new boolean[100005];
            String[] parent = new String[100005];
            queue.add(src);
            boolean con = false;
            if(map.get(src) != null && map.get(dest) != null){
                visited[map.get(src)] = true;
                while (!queue.isEmpty()){
                    String curr = queue.poll();
                    for(String s : list[map.get(curr)]){
                        if(!visited[map.get(s)]){
                            queue.add(s);
                            visited[map.get(s)] = true;
                            parent[map.get(s)] = curr;
                            if(s.compareTo(dest) == 0){
                                con = true;
                                break;
                            }
                        }
                    }
                    if(con){
                        break;
                    }
                }
            }


            if(!con){
                System.out.println("No route");
            }
            else{
                LinkedList<String> ans = new LinkedList<String>();
                String curr = dest;
                ans.add(curr);
                while (true){
                    curr = parent[map.get(curr)];
                    ans.add(curr);
                    if(curr.compareTo(src) == 0){
                        break;
                    }
                }
                Collections.reverse(ans);
                for(int i = 0;i < ans.size()-1;i++){
                    System.out.println(ans.get(i) + " " + ans.get(i+1));
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
