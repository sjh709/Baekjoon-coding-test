import java.io.*;
import java.util.*;
public class Main {
    public static int m, n;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(graph[nx][ny] == 0 || visited[nx][ny]) continue;
            dfs(nx, ny);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph = new int[n][m];
            visited = new boolean[n][m];
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[y][x] = 1;
            }
            
            for(int x = 0; x < n; x++) {
                for(int y = 0; y < m; y++) {
                    if(graph[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y);
                        answer++;
                    }
                }
            }
            
            System.out.println(answer);
        }
    }
}
