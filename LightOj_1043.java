import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LightOj_1043 {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        for(int c = 1;c <= t;c++){
            double ab = input.nextDouble();
            double ac = input.nextDouble();
            double bc = input.nextDouble();
            double ratio = input.nextDouble();
            System.out.print("Case " + c + ": ");
            double low = 0;
            double high = ab;
            double mid = 0;
            while (high - low >= 0.0000001){
                mid = (high + low) / 2.0;
                double ad = mid;
                double ae = (ad * ac) / ab;
                double de = (ad * bc) / ab;
                double p = (ad + ae + de) / 2.0;
                double area = Math.sqrt(p * (p-ad) * (p-ae) * (p-de));
                double bd = ab - ad; // short
                double ce = ac - ae; // short
                double s = (de + bc + bd + ce) / 2.0;
                double area2 = ((bc + de) / (bc - de)) * Math.sqrt((s - bc) * (s - de) * (s - de - bd) * (s - de - ce));
                double ratio2 = (area / area2);
                if(ratio == ratio2){
                    break;
                }
                else if(ratio2 > ratio){
                    high = mid;
                }
                else{
                    low = mid;
                }
            }
            System.out.println(mid);
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
