import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Poj_2001 {

    static class TrieNode{
        boolean endOfWord;
        Map<Character,TrieNode> children;
        int[] arr = new int[26];
        TrieNode(){
            children = new HashMap<Character,TrieNode>();
            endOfWord = false;
        }
    }

    static TrieNode root;

    static void insert(String s){
        TrieNode current = root;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            current.arr[c - 'a']++;
            TrieNode node = current.children.get(c);
            if(node == null){
                node = new TrieNode();
                current.children.put(c,node);
            }
            current = node;
        }
        current.endOfWord = true;
    }
    static void check(String s){
        TrieNode current = root;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            System.out.print(c);
            if(current.arr[c - 'a'] == 1){
                return;
            }
            TrieNode node = current.children.get(c);
            current = node;
        }
    }
    public static void main(String[] args) {
        FastReader input = new FastReader();
        root = new TrieNode();
        ArrayList<String> list = new ArrayList<String>();
        while (true){
            String s = input.nextLine();
            if(s.isEmpty())
                break;
            else{
                insert(s);
                list.add(s);
            }
        }
        for(String s : list){
            System.out.print(s + " ");
            check(s);
            System.out.println();
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
