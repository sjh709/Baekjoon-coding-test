import java.io.*;
import java.util.*;
class graph implements Comparable<graph> {
    int x;
    int y;
    graph(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int compareTo(graph g) {
        if(x == g.x) return y - g.y;
        return x - g.x;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        ArrayList<graph> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new graph(x, y));
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < list.size(); i++) {
            bw.append(String.valueOf(list.get(i).x) + " " + String.valueOf(list.get(i).y) + "\n");
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
