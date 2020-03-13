import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva_p439 {

    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            int[][] chessBoard = new int[9][9];
            String s = input.nextLine();
            int x1 = 0;
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;
            y1 = s.charAt(0) - 'a' + 1;
            x1 = Integer.parseInt(Character.toString(s.charAt(1)));

            y2 = s.charAt(3) - 'a' + 1;
            x2 = Integer.parseInt(Character.toString(s.charAt(4)));

            boolean[][] visited = new boolean[9][9];
            int[][] level = new int[9][9];

            LinkedList<Node> queue = new LinkedList<Node>();
         //   System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
            visited[x1][y1] = true;
            level[x1][y1] = 0;
            queue.add(new Node(x1,y1));

            while (!queue.isEmpty()){
                Node curr = queue.poll();
                int x = curr.x;
                int y = curr.y;

                int up1_x = x - 2;
                int up1_y = y - 1;  // up left
                if(up1_x >= 1 && up1_x <= 8 && up1_y >= 1 && up1_y <= 8){
                    if(!visited[up1_x][up1_y]){
                        visited[up1_x][up1_y] = true;
                        queue.add(new Node(up1_x,up1_y));
                        level[up1_x][up1_y] = level[x][y] + 1;
                        if(up1_x == x2 && up1_y == y2){
                           // System.out.println("got it");
                            break;
                        }
                    }
                }
                int up2_x = x - 2;
                int up2_y = y + 1;  // up right
                if(up2_x >= 1 && up2_x <= 8 && up2_y >= 1 && up2_y <= 8){
                    if(!visited[up2_x][up2_y]){
                        visited[up2_x][up2_y] = true;
                        queue.add(new Node(up2_x,up2_y));
                        level[up2_x][up2_y] = level[x][y] + 1;
                        if(up2_x == x2 && up2_y == y2){
                           // System.out.println("got it");
                            break;
                        }
                    }
                }

                int left1_x = x + 1;
                int left1_y = y - 2;  // left down
                if(left1_x >= 1 && left1_x <= 8 && left1_y >= 1 && left1_y <= 8){
                   // System.out.println("Here");
                    if(!visited[left1_x][left1_y]){
                        visited[left1_x][left1_y] = true;
                        queue.add(new Node(left1_x,left1_y));
                        level[left1_x][left1_y] = level[x][y] + 1;
                        if(left1_x == x2 && left1_y == y2){
                          //  System.out.println("got it");
                            break;
                        }
                    }
                }

                int left2_x = x - 1;
                int left2_y = y - 2;  // left up
                if(left2_x >= 1 && left2_x <= 8 && left2_y >= 1 && left2_y <= 8){
                    if(!visited[left2_x][left2_y]){
                        visited[left2_x][left2_y] = true;
                        queue.add(new Node(left2_x,left2_y));
                        level[left2_x][left2_y] = level[x][y] + 1;
                        if(left2_x == x2 && left2_y == y2){
                           // System.out.println("got it");
                            break;
                        }
                    }
                }

                int right1_x = x + 1;
                int right1_y = y + 2;  // right down
                if(right1_x >= 1 && right1_x <= 8 && right1_y >= 1 && right1_y <= 8){
                    if(!visited[right1_x][right1_y]){
                        visited[right1_x][right1_y] = true;
                        queue.add(new Node(right1_x,right1_y));
                        level[right1_x][right1_y] = level[x][y] + 1;
                        if(right1_x == x2 && right1_y == y2){
                            //System.out.println("got it");
                            break;
                        }
                    }
                }


                int right2_x = x - 1;
                int right2_y = y + 2;  // right up
                if(right2_x >= 1 && right2_x <= 8 && right2_y >= 1 && right2_y <= 8){
                    if(!visited[right2_x][right2_y]){
                        visited[right2_x][right2_y] = true;
                        queue.add(new Node(right2_x,right2_y));
                        level[right2_x][right2_y] = level[x][y] + 1;
                        if(right2_x == x2 && right2_y == y2){
                         //   System.out.println("got it");
                            break;
                        }
                    }
                }

                int down1_x = x + 2;
                int down1_y = y - 1;  // down left
                if(down1_x >= 1 && down1_x <= 8 && down1_y >= 1 && down1_y <= 8){
                    if(!visited[down1_x][down1_y]){
                        visited[down1_x][down1_y] = true;
                        queue.add(new Node(down1_x,down1_y));
                        level[down1_x][down1_y] = level[x][y] + 1;
                        if(down1_x == x2 && down1_y == y2){
                           // System.out.println("got it");
                            break;
                        }
                    }
                }

                int down2_x = x + 2;
                int down2_y = y + 1;  // down right
                if(down2_x >= 1 && down2_x <= 8 && down2_y >= 1 && down2_y <= 8){
                    if(!visited[down2_x][down2_y]){
                        visited[down2_x][down2_y] = true;
                        queue.add(new Node(down2_x,down2_y));
                        level[down2_x][down2_y] = level[x][y] + 1;
                        if(down2_x == x2 && down2_y == y2){
                           // System.out.println("got it");
                            break;
                        }
                    }
                }
            }
//            for(int i = 1;i <= 8;i++){
//                for(int j = 1;j <= 8;j++){
//                    System.out.print(level[i][j] + " ");
//                }
//                System.out.println();
//            }
            System.out.println("To get from " + s.charAt(0) + s.charAt(1) + " " + "to" + " " + s.charAt(3) + s.charAt(4) + " takes " + level[x2][y2] + " knight moves.");
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
