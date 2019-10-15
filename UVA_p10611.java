import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_p10611 {
    static int upperBound(int[] arr,int height){
        int index = -1;
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == height){
                high = mid-1;
            }
            else if(arr[mid] > height){
                high = mid-1;
            }
            else {
                index = mid;
                low = mid+1;
            }
        }
        return index;
    }
    static int lowerBound(int[] arr,int height){
        int index = -1;
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == height){
                low = mid+1;
            }
            else if(arr[mid] > height){
                index = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return index;
    }
    public static void main(String[] args) {
       FastReader input = new FastReader();
       int n = input.nextInt();
       int[] arr = new int[n];
       for(int i = 0;i < n;i++){
           arr[i] = input.nextInt();
       }
       int q = input.nextInt();
       int[] heights = new int[q];
       for(int i = 0;i < q;i++){
           heights[i] = input.nextInt();
       }
       for(int i = 0;i < q;i++){
           int height = heights[i];
           int up = upperBound(arr,height);
           int down = lowerBound(arr,height);
           if(up == -1){
               System.out.print("X ");
           }
           else
               System.out.print(arr[up] + " ");
           if(down == -1)
               System.out.println("X");
           else
               System.out.println(arr[down]);
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
