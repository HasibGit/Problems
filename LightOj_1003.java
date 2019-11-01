import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LightOj_1003 {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        LinkedList<Integer>[] list = new LinkedList[100000 + 5];
        for(int i = 0;i <= 100000;i++){
            list[i] = new LinkedList<Integer>();
        }
        int cs,m,val,i;
        String first,next;
        for(cs = 1;cs <= t;cs++){
            Map<String,Integer> map = new HashMap<String,Integer>();
            m = input.nextInt();
            val = 0;
            boolean con = true;
            for(i = 0;i < m;i++){
                first = input.next();
                next = input.next();
                if(map.get(first) == null){
                    map.put(first,val);
                    val++;
                }
                if(map.get(next) == null){
                    map.put(next,val);
                    val++;
                }
                if(list[map.get(first)].size() != 0){
                    for(int j : list[map.get(first)]){
                      //  System.out.print(j + " ");
                        if(j == map.get(next)){
                            con = false;
                        }
                    }
                }
                if(con){
                    list[map.get(next)].add(map.get(first));
                    //System.out.println(map.get(next) + " " + map.get(first));
                }
            }
            System.out.print("Case " + cs + ": ");
            if(con){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            for(i = 0;i <= 100000;i++){
                list[i].clear();
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
