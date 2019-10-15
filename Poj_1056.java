import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Poj_1056 {
    static class TrieNode{
        boolean endOfWord;
        Map<Character,TrieNode> children;
        TrieNode(){
            endOfWord = false;
            children = new HashMap<Character,TrieNode>();
        }
    }
    static TrieNode  root = null;
    static boolean insert(String s,boolean con){
        TrieNode current = root;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null){
                node = new TrieNode();
                current.children.put(c,node);
            }
            current = node;
            if(i < s.length()-1 && current.endOfWord == true){
                con = false;
            }
        }
        current.endOfWord = true;
        return con;
    }
    public static void main(String[] args) {
        FastReader input = new FastReader();
        boolean con = true;
        int set = 1;
        while (true){
            if(root == null){
                root = new TrieNode();
            }
            String s = input.nextLine();
            if(s.isEmpty())
                break;
            else{
                if(Integer.parseInt(s) == 9){
                    if(con){
                        System.out.println("Set " + set + " is immediately decodable");
                    }
                    else{
                        System.out.println("Set " + set + " is not immediately decodable");
                    }
                    set++;
                    con = true;
                    root = null;
                }
                else{
                    con = insert(s,con);
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
