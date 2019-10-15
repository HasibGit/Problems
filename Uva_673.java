import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Uva_673 {
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int q = input.nextInt();
        while (q > 0){
            String s = input.nextLine();
            Stack<Character> stack = new Stack<Character>();
            boolean con = true;
            for(int i = 0; i < s.length();i++){
                stack.add(s.charAt(i));
                if(s.charAt(i) == ')' || s.charAt(i) == ']'){
                    if(stack.size() >= 2){
                        char one  = stack.pop();
                        char two = stack.pop();
                        if(one == ')'){
                            if(two != '('){
                                con = false;
                                break;
                            }
                        }
                        else if(one == ']'){
                            if(two != '['){
                                con = false;
                                break;
                            }
                        }
                    }
                    else{
                        con = false;
                        break;
                    }
                }
            }

            if(stack.size() > 0){
                con = false;
            }
            if(con){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            q--;
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
