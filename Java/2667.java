import java.io.*;
import java.util.*;
public class Main {
    public static int n, cnt;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            if(graph[nx][ny] == 0 || visited[nx][ny]) continue;
            dfs(nx, ny);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 1 && !visited[i][j]) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        
        System.out.println(list.size());
        for(int l : list) {
            System.out.println(l);
        }
    }
}
