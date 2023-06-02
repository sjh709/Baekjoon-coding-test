import java.io.*;
import java.util.*;
public class Main {
    public static ArrayList<ArrayList<Integer>> list;
    public static boolean[] visit;
    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;
        while(!q.isEmpty()) {
            x = q.poll();
            for(int i = 0; i < list.get(x).size(); i++) {
                int y = list.get(x).get(i);
                if(!visit[y]) {
                    q.offer(y);
                    visit[y] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
        visit = new boolean[n + 1];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            list.get(u).add(v);
            list.get(v).add(u);
        }
        
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(!visit[i]) {
                bfs(i);
                cnt++;
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
