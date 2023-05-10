import java.io.*;
import java.util.*;
class Node {
    int x;
    int y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[][] tomato;
    public static boolean[][] visit;
    public static void bfs(int n, int m) {
        Queue<Node> q = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(tomato[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
            }
        }
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            visit[x][y] = true;
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(!visit[nx][ny] && tomato[nx][ny] == 0) {
                    tomato[nx][ny] = tomato[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        tomato = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        bfs(n, m);
        
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(tomato[i][j] == 0) {
                    answer = -1;
                    break;
                }else {
                    answer = Math.max(answer, tomato[i][j]);
                }
            }
            
            if(answer == -1) break;
        }
        
        if(answer == -1) {
            bw.write("-1");
        }else {
            bw.write(String.valueOf(answer - 1));
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
