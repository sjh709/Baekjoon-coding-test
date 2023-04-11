import java.io.*;
import java.util.*;
class Node {
    int x = 0;
    int y = 0;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static int n, m;
    public static int[][] board;
    public static boolean[][] visit;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int cnt, area;
    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visit[x][y] = true;
        while(!q.isEmpty()) {
            Node node = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visit[nx][ny] || board[nx][ny] == 0) continue;
                q.offer(new Node(nx, ny));
                visit[nx][ny] = true;
                area++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new int[n][m];
        visit = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max_area = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visit[i][j] && board[i][j] == 1) {
                    area = 1;
                    bfs(i, j);
                    max_area = Math.max(max_area, area);
                    cnt++;
                }
            }
        }
        
        bw.write(String.valueOf(cnt) + "\n" + String.valueOf(max_area));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
