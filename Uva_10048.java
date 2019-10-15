import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;
public class Uva_10048 {

    public static void main(String[] args) {
        FastReader input = new FastReader();
        boolean blank = false;
        int t = 1;
        while (true){
            int nodes = input.nextInt();
            int edges = input.nextInt();
            int query = input.nextInt();
            int[][] matrix = new int[nodes+1][nodes+1];
            if(nodes == 0 && edges == 0 && query == 0)
                break;
            else{
                for(int i = 1;i <= nodes;i++){
                    for(int j = 1;j <= nodes;j++){
                        matrix[i][j] = Integer.MAX_VALUE;
                        matrix[j][i] = Integer.MAX_VALUE;
                    }
                }
                for(int i = 0;i < edges;i++){
                    int src = input.nextInt();
                    int dest = input.nextInt();
                    int weight = input.nextInt();
                    matrix[src][dest] = weight;
                    matrix[dest][src] = weight;
                }
                for(int k = 1;k <= nodes;k++){
                    for(int i = 1;i <= nodes;i++){
                        for(int j = 1;j <= nodes;j++){
                            matrix[i][j] = matrix[j][i] = Math.min(matrix[i][j],Math.max(matrix[i][k],matrix[k][j]));
                        }
                    }
                }
            }
            if(blank)
            System.out.println();

            blank = true;
            System.out.println("Case #" + t);
            for(int i = 1;i <= query;i++){
                int src = input.nextInt();
                int dest = input.nextInt();
                if(matrix[src][dest] == Integer.MAX_VALUE){
                    System.out.println("no path");
                }
                else{
                    System.out.println(matrix[src][dest]);
                }
            }
           t++;
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
