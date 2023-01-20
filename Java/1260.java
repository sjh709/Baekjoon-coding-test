import java.io.*;
import java.util.*;
public class Main {
    public static int n, m, v;
    public static boolean[][] graph;
    public static boolean[] visited;
    
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");
            for(int i = 1; i < n + 1; i++) {
                if(!visited[i] && graph[x][i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for(int i = 1; i < n + 1; i++) {
            if(!visited[i] && graph[x][i]) {
                dfs(i);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 0. 입력 및 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        // 1. graph 정보 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        
        // 2. dfs
        dfs(v);
        System.out.println();
        
        // 3. bfs
        visited = new boolean[n + 1];
        bfs(v);
        
    }
}
