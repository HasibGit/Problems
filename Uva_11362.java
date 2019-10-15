import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Uva_11362 {
    static class TrieNode{
        Map<Character,TrieNode> children;
        boolean endOfWord;
        TrieNode(){
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
        }
    }
    static void insert(String s){
        TrieNode current = root;
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null){
                node = new TrieNode();
                current.children.put(c,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }
    static boolean check(String s){
        TrieNode current = root;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            TrieNode node = current.children.get(c);
            current = node;
            if(i != s.length()-1 && current.endOfWord == true){
                //System.out.println(s);
                return false;
            }
        }
        return true;
    }
    static TrieNode root;
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        while (t > 0){
            int n = input.nextInt();
            if(root == null){
                root = new TrieNode();
            }
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0;i < n;i++){
                String s = input.nextLine();
                list.add(s);
                insert(s);
            }
            boolean con = true;
            for(String s : list){
                con = check(s);
                if(!con) {
                    break;
                }
            }
            if(con){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            t--;
            root = null;
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
