import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LightOj_1112 {
    static int[] arr = new int[100005];
    static int[] segmentTree = new int[4 * 100005];

    static int construct(int low,int high,int pos){
        if(low == high){
            segmentTree[pos] = arr[low];
            return segmentTree[pos];
        }
        int mid = (low + high) / 2;
        segmentTree[pos] = construct(low,mid,2 * pos + 1) +  construct(mid+1,high,2 * pos + 2);
        return segmentTree[pos];
    }

    static void update(int low,int high,int index,int value,int pos){
        if(low > index  || high < index){
            return;
        }
        if(low == high){
            segmentTree[pos] += value;
            return;
        }
        int mid = (low + high) / 2;
        update(low,mid,index,value,2 * pos + 1);
        update(mid+1,high,index,value,2 * pos + 2);
        segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];
    }

    static int rangeSumQuery(int low,int high,int queryLow,int queryHigh,int pos){
        if(queryLow > high || queryHigh < low){
            return 0;
        }
        if(queryLow <= low && queryHigh >= high){
            return segmentTree[pos];
        }
        int mid = (low + high) / 2;
        int p1 = rangeSumQuery(low,mid,queryLow,queryHigh,2 * pos + 1);
        int p2 = rangeSumQuery(mid+1,high,queryLow,queryHigh,2 * pos + 2);
        return p1 + p2;
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int  t = input.nextInt();
        for(int cs = 1;cs <= t;cs++){
            int n = input.nextInt();
            int q = input.nextInt();
            for(int i = 0;i < n;i++){
                arr[i] = input.nextInt();
                segmentTree[i] = 0;
            }
            construct(0,n-1,0);

            System.out.println("Case " + cs + ":");

            for(int i = 0;i < q;i++){
                int type = input.nextInt();
                if(type == 1){
                    int index = input.nextInt();
                    int value = arr[index];
                    arr[index] = 0;
                    update(0,n-1,index,-value,0);
                    System.out.println(value);
                }
                if(type == 2){
                    int index = input.nextInt();
                    int value = input.nextInt();
                    arr[index] += value;
                    update(0,n-1,index,value,0);
                }
                if(type == 3){
                    int queryLow = input.nextInt();
                    int queryHigh = input.nextInt();
                    System.out.println(rangeSumQuery(0,n-1,queryLow,queryHigh,0));
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
