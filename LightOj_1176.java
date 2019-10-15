import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LightOj_1176 {
    static int[] arr = new int[1000];
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        for(int cs = 1;cs <= t;cs++){
            int n = input.nextInt();
            int m = input.nextInt();
            long max = Integer.MIN_VALUE;
            long total = 0;
            for(int i = 0;i < n;i++){
                arr[i] = input.nextInt();
                total += arr[i];
                max = Math.max(max,arr[i]);
            }
            System.out.print("Case " + cs + ": ");
            if(m >= n){
                System.out.println(max);
            }
            else{
                long low = max;
                long high = total;
                long mid = 0;
                long ans = 0;
                while (low <= high){
                   // System.out.println("Going");
                    mid = (low + high) / 2;
                   // System.out.println("Mid : " + mid);
                    int count = 1;
                    long capacity = mid;
                    long temp = 0;
                    for(int i = 0;i < n;i++){
                        if(temp + arr[i] <= capacity){
                            temp = temp + arr[i];
                        }
                        else {
                            temp = arr[i];
                            count++;
                        }
                    }
                    if(count > m){
                        low = mid + 1;
                    }
                    else{
                        ans = mid;
                        high = mid - 1;
                    }
                }
                System.out.println(ans);
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
