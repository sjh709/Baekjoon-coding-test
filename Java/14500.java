import java.io.*;
import java.util.*;
public class Main {
    public static int n, m, max;
    public static int[][] arr;
    public static boolean[][] visit;
    
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};
    
    public static void exception(int x, int y) {
        int wings = 4;
        int sum = arr[x][y];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                wings--;
                continue;
            }
            
            if(wings < 3) return;
            
            sum += arr[nx][ny];
            min = Math.min(min, arr[nx][ny]);
        }
        
        if(wings == 4) {
            sum -= min;
        }
        
        max = Math.max(max, sum);
    }
    
    public static void dfs(int x, int y, int sum, int depth) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(visit[nx][ny]) continue;
            
            visit[nx][ny] = true;
            dfs(nx, ny, sum + arr[nx][ny], depth + 1);
            visit[nx][ny] = false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visit = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                exception(i, j);
            }
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
