import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Uva_p10653 {

    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        while (true){
            int rows = input.nextInt();
            int columns = input.nextInt();
            if(rows == 0 && columns == 0){
                 break;
            }
            int[][] grid = new int[rows][columns];
            int[][] level = new int[rows][columns];
            boolean[][] visited = new boolean[rows][columns];
            int rowsEffected = input.nextInt();
            for(int i = 0;i < rowsEffected;i++){
                int rowNo = input.nextInt();
                int numOfMines = input.nextInt();
                for(int j = 0;j < numOfMines;j++){
                    int pos = input.nextInt();
                    grid[rowNo][pos] = 1;
                }
            }
            int srcX = input.nextInt();
            int srcY = input.nextInt();
            int destX = input.nextInt();
            int destY = input.nextInt();
            level[srcX][srcY] = 0;
            visited[srcX][srcY] = true;
            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(new Node(srcX,srcY));
            int leftX = 0;
            int leftY = 0;
            int rightX = 0;
            int rightY = 0;
            int bottomX = 0;
            int bottomY = 0;
            int topX = 0;
            int topY = 0;
            while (!queue.isEmpty()){
                Node curr = queue.poll();
                if(curr.y > 0){
                    leftX = curr.x;
                    leftY = curr.y - 1;
                    if(!visited[leftX][leftY]){
                        if(grid[leftX][leftY] != 1){
                            queue.add(new Node(leftX,leftY));
                            visited[leftX][leftY] = true;
                            level[leftX][leftY] = level[curr.x][curr.y] + 1;
                            if(leftX == destX && leftY == destY){
                                break;
                            }
                        }
                    }
                }
                if(curr.y < columns-1){
                    rightX = curr.x;
                    rightY = curr.y + 1;
                    if(!visited[rightX][rightY]){
                        if(grid[rightX][rightY] != 1){
                            queue.add(new Node(rightX,rightY));
                            visited[rightX][rightY] = true;
                            level[rightX][rightY] = level[curr.x][curr.y] + 1;
                            if(rightX == destX && rightY == destY){
                                break;
                            }
                        }
                    }
                }
                try {
                    if(curr.x > 0){
                        topX = curr.x-1;
                        topY = curr.y;
                        if(!visited[topX][topY]){
                            if(grid[topX][topY] != 1){
                                queue.add(new Node(topX,topY));
                                visited[topX][topY] = true;
                                level[topX][topY] = level[curr.x][curr.y] + 1;
                                if(topX == destX && topY == destY){
                                    break;
                                }
                            }
                        }
                    }
                }
                catch (Exception e){
                    System.out.println(curr.x + " " + curr.y);
                    System.out.println(topX + " " + topY);
                }

                if(curr.x < rows-1){
                    bottomX = curr.x + 1;
                    bottomY = curr.y;
                    if(!visited[bottomX][bottomY]){
                        if(grid[bottomX][bottomY] != 1){
                            queue.add(new Node(bottomX,bottomY));
                            visited[bottomX][bottomY] = true;
                            level[bottomX][bottomY] = level[curr.x][curr.y] + 1;
                            if(bottomX == destX && bottomY == destY){
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println(level[destX][destY]);
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
