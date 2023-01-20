import java.io.*;
import java.util.*;
public class Main {
    public static int n, m;
    public static boolean[][] graph;
    public static boolean[] visited;
    public static int answer = -1;
    
    public static void dfs(int x) {
        visited[x] = true;
        answer++;
        for(int i = 1; i < n + 1; i++) {
            if(!visited[i] && graph[x][i]) {
                dfs(i);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        
        dfs(1);
        System.out.println(answer);
    }
}
