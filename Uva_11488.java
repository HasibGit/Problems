import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Uva_11488 {
    static class TrieNode{
        boolean endOfWord;
        Map<Character,TrieNode> children;
        int travelled;
        TrieNode(){
            children = new HashMap<Character,TrieNode>();
            endOfWord = false;
            travelled = 0;
        }
    }
    static TrieNode root;
    static int insert(String s,int max){
        TrieNode current = root;
        int count = 0;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            count++;
            TrieNode node = current.children.get(c);
            if(node != null){
                node.travelled++;
                max = Math.max(max,count);
                max = Math.max(max,count * node.travelled);
                current = node;
            }
            else{
                node = new TrieNode();
                node.travelled++;
                max = Math.max(max,count * node.travelled);
                current.children.put(c,node);
                current = node;
            }
        }
        current.endOfWord = true;
        return max;
    }
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            int max = Integer.MIN_VALUE;
            if(root == null){
                root = new TrieNode();
            }
            for(int i = 0;i < n;i++){
                String s = input.nextLine();
                max = insert(s,max);
                //System.out.println(i + " " + max);
            }
            System.out.println(max);
            root = null;
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
