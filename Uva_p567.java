/*
1 3
2 3 4
3 4 5 6
1 6
1 7
2 12 13
1 8
2 9 10
1 11
1 11
2 12 17
1 14
2 14 15
2 15 16
1 16
1 19
2 18 19
1 20
1 20
5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class Uva_p567 {
    static LinkedList<Integer> list[];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testSet = 1;
        while (input.hasNext()){
            list = new LinkedList[21];



            for(int i = 1;i < 21;i++){
                list[i] = new LinkedList<Integer>();
            }

            // making graph
            int x = input.nextInt();
            while (x > 0){
                int j = input.nextInt();
                try {
                    list[1].add(j);
                    list[j].add(1);
                }
                catch (Exception e){
                    System.out.println(j + " sda");
                }
                x--;
            }


            for(int i = 2;i <= 19;i++){
                        int numOfNodes = input.nextInt();
                        while (numOfNodes > 0){
                                int node = input.nextInt();
                                try {
                                    list[i].add(node);
                                    list[node].add(i);
                                }
                                catch (Exception e){
                                    System.out.println(i + " " + node + " fuck");
                                }

                                numOfNodes--;
                        }
            }

            int query = input.nextInt();
            System.out.println("Test Set #" + testSet);
            for(int i = 0;i < query;i++){
                int src = input.nextInt();
                int dest = input.nextInt();
                int[] level = new int[21];
                boolean[] visited = new boolean[21];
                LinkedList<Integer> queue = new LinkedList<Integer>();
                level[src] = 0;
                visited[src] = true;
                queue.add(src);
                boolean found = false;
                while (!queue.isEmpty()){
                    int curr = queue.poll();
                    for(int j : list[curr]){
                        if(!visited[j]){
                            visited[j] = true;
                            queue.add(j);
                            level[j] = level[curr] + 1;
                            if(j == dest){
                                found = true;
                                break;
                            }
                        }
                    }
                    if(found){
                        break;
                    }
                }
                System.out.format("%2d to %2d: %d\n", src, dest, level[dest]);
            }
            System.out.println();
            testSet++;
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
