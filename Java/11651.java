import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int compareTo(Node n) {
        if(this.y == n.y) return this.x - n.x;
        return this.y - n.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            list.add(new Node(x, y));
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < n; i++) {
            bw.append(String.valueOf(list.get(i).x) + " " + String.valueOf(list.get(i).y) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
