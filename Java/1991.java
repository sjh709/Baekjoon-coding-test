import java.io.*;
import java.util.*;
public class Main {
    public static HashMap<String, List<String>> map;
    public static StringBuilder sb1 = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();
    public static StringBuilder sb3 = new StringBuilder();
    
    public static void postOrder(String s) {
        if(s.equals(".")) return;
        
        postOrder(map.get(s).get(0));
        postOrder(map.get(s).get(1));
        sb3.append(s);
    }
    
    public static void inOrder(String s) {
        if(s.equals(".")) return;
        
        inOrder(map.get(s).get(0));
        sb2.append(s);
        inOrder(map.get(s).get(1));
    }
    
    public static void preOrder(String s) {
        if(s.equals(".")) return;
        
        sb1.append(s);
        preOrder(map.get(s).get(0));
        preOrder(map.get(s).get(1));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            
            List<String> list = new ArrayList<>();
            list.add(left);
            list.add(right);
            
            map.put(root, list);
        }
        
        preOrder("A");
        inOrder("A");
        postOrder("A");
        
        bw.write(sb1.toString() + "\n");
        bw.write(sb2.toString() + "\n");
        bw.write(sb3.toString() + "\n");
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
