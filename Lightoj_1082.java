import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lightoj_1082 {

    static int nextPowerOf2(int n)
    {
        int count = 0;

        // First n in the below
        // condition is for the
        // case where n is 0
        if (n > 0 && (n & (n - 1)) == 0)
            return n;

        while(n != 0)
        {
            n = n >> 1;
            count = count + 1;
        }

        return 1 << count;
    }
    static boolean isPowerOfTwo(int n){
        return n > 0 && ((n & (n-1)) == 0);
    }

    static void constructSegmentTree(int[] input,int low,int high,int pos){
        if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high) / 2;
        constructSegmentTree(input,low,mid,2 * pos + 1);
        constructSegmentTree(input,mid+1,high,2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1],segmentTree[2 * pos + 2]);
    }
    static int rangeMinimumQuery(int low,int high,int quertLow,int queryHigh,int pos){
        // Total Overlap
        if(quertLow <= low && queryHigh >= high){
            return segmentTree[pos];
        }
        // No overlap
        else if(quertLow > high || queryHigh < low){
            return Integer.MAX_VALUE;
        }
        else{
            int mid = (low + high) / 2;
            int p1 = rangeMinimumQuery(low,mid,quertLow,queryHigh,2 * pos + 1);
            int p2 = rangeMinimumQuery(mid+1,high,quertLow,queryHigh,2 * pos + 2);
            return Math.min(p1,p2);
        }
    }
    static int[] arr = new int[100000 + 5];
    static int[] segmentTree = new int[4 * arr.length];
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        for(int cs = 1;cs <= t;cs++){
            //System.out.println();
            int n = input.nextInt();
            int q = input.nextInt();
            for(int i = 0;i < n;i++){
                arr[i] = input.nextInt();
            }

            for(int i = 0;i < 4 * n;i++){
                segmentTree[i] = Integer.MAX_VALUE;
            }
            constructSegmentTree(arr,0,n-1,0);
            System.out.println("Case " + cs + ":");
            for(int i = 0;i < q;i++){
                int queryLow = input.nextInt() - 1;
                int queryHigh = input.nextInt() - 1;
                System.out.println(rangeMinimumQuery(0,n-1,queryLow,queryHigh,0));
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
