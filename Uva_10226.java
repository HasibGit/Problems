import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Uva_10226 {
    static class TrieNode{
        boolean endOfWord;
        Map<Character,TrieNode> children = new HashMap<Character,TrieNode>();
        int encounter;
        TrieNode(){
            endOfWord = false;
            encounter = 0;
        }
    }
    static TrieNode root;
    static void insert(String s){
        TrieNode current = root;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            TrieNode node = current.children.get(c);
            if(node == null){
                node = new TrieNode();
                current.children.put(c,node);
            }
            current = node;
        }
        current.endOfWord = true;
        current.encounter++;
    }
    static int check(String s){
        TrieNode current = root;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            TrieNode node = current.children.get(c);
            current = node;
        }
        return current.encounter;
    }
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();
        input.nextLine();
        while (t > 0){
            Set<String> set = new TreeSet<String>();
            if(root == null){
                root = new TrieNode();
            }
            int count = 0;
            while (true){
                String s = input.nextLine();
                if(s.isEmpty()){
                    break;
                }
                else{
                    count++;
                    insert(s);
                    set.add(s);
                }
            }
            for(String s : set){
                int encounter = check(s);
               // System.out.println(encounter);
                float val = ((float) encounter / (float)count) * 100;
                System.out.print(s + " ");
                System.out.println(String.format("%.4f",val));
            }
            if(t > 1)
            System.out.println();
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
