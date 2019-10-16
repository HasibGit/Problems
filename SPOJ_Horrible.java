import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SPOJ_Horrible {
    static int[] arr = new int[100005];
    static long[] segmentTree = new long[4 * arr.length];
    static long[] lazy = new long[segmentTree.length];

    static void construct(int low, int high,int pos){
        if(low == high){
            segmentTree[pos] = arr[low];
            return;
        }
        int mid = (low + high) / 2;
        construct(low,mid,2 * pos + 1);
        construct(mid+1,high,2 * pos + 2);
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }

    static void update(long low,long high,long queryLow,long queryHigh,long value,int pos){
        if(lazy[pos] != 0){
            segmentTree[pos] += (high - low + 1) * lazy[pos];
            if(low != high){
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }

        if(queryLow > high || queryHigh < low){
            return;
        }
        if(queryLow <= low && queryHigh >= high){
            segmentTree[pos] += (high - low + 1) * value;
            if(low != high){
                lazy[2 * pos + 1] += value;
                lazy[2 * pos + 2] += value;
            }
            return;
        }
        long mid = (low + high) / 2;
        update(low,mid,queryLow,queryHigh,value,2 * pos + 1);
        update(mid+1,high,queryLow,queryHigh,value,2 * pos + 2);
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }

    static long query(long low,long high,long queryLow,long queryHigh,int pos){
        if(lazy[pos] != 0){
            segmentTree[pos] += (high - low + 1) * lazy[pos];
            if(low != high){
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }
            lazy[pos] = 0;
        }

        if(queryLow > high || queryHigh < low){
            return 0;
        }
        if(queryLow <= low && queryHigh >= high){
            return segmentTree[pos];
        }
        long mid = (low + high) / 2;
        long p1 = query(low,mid,queryLow,queryHigh,2 * pos + 1);
        long p2 = query(mid+1,high,queryLow,queryHigh,2 * pos + 2);
        return p1 + p2;
    }


    public static void main(String[] args) {
        FastReader input = new FastReader();
        long t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            int q = input.nextInt();
            construct(0,n-1,0);
            for(int i = 0;i < q;i++){
                long type = input.nextLong();
                if(type == 0){
                    long start = input.nextLong();
                    start = start - 1;
                    long end = input.nextLong();
                    end = end - 1;
                    long value = input.nextLong();
                    update(0,n-1,start,end,value,0);
                }
                else if(type == 1){
                    long start = input.nextLong();
                    start = start - 1;
                    long end = input.nextLong();
                    end = end - 1;
                    long ans = query(0,n-1,start,end,0);
                    System.out.println(ans);
                }
            }
            for(int i = 0;i < 4 * n;i++){
                segmentTree[i] = 0;
                lazy[i] = 0;
            }
            t--;
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
