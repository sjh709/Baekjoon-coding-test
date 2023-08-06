import java.io.*;
import java.util.*;
class Point {
    int x;
    int y;
    int wall;
    int cnt;
    Point(int x, int y, int wall, int cnt) {
        this.x = x;
        this.y = y;
        this.wall = wall;
        this.cnt = cnt;
    }
}

public class Main {
    public static int n, m;
    public static int[][] map;
    public static boolean[][][] visit;
    
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    
    public static StringBuilder sb = new StringBuilder();
    
    public static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0, 1));
        
        visit[x][y][0] = true; // 안부숨
        visit[x][y][1] = true; // 1부숨
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;
            
            if(x == n - 1 && y == m - 1) {
                sb.append(String.valueOf(p.cnt));
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int wall = p.wall;
                int cnt = p.cnt;
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if(map[nx][ny] == 0 && !visit[nx][ny][wall]) { // 벽X && 방문X
                    visit[nx][ny][wall] = true;
                    q.offer(new Point(nx, ny, wall, cnt + 1));
                }else if(map[nx][ny] == 1 && wall == 0 && !visit[nx][ny][0]) { // 벽O && 아직 안부숨 && 방문X
                    visit[nx][ny][1] = true;
                    q.offer(new Point(nx, ny, 1, cnt + 1));
                }
            }
        }
        
        sb.append("-1");
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        visit = new boolean[n][m][2];
        
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        bfs(0, 0);
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
