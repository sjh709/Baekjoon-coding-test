import java.io.*;
import java.util.*;
class Point {
    int rx, ry, bx, by, cnt;
    Point(int rx, int ry, int bx, int by, int cnt) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.cnt = cnt;
    }
    
    Point() {
        
    }
}

public class Main {
    public static int n, m;
    public static char[][] board;
    public static boolean[][][][] visited;
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};
    public static void bfs(Point point) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        while(!q.isEmpty()) {
            Point p = q.poll();
            visited[p.rx][p.ry][p.bx][p.by] = true;
            
            if(p.cnt == 10) {
                System.out.println(-1);
                return;
            }
            
            for(int i = 0; i < 4; i++) {
                int bx = p.bx;
                int by = p.by;
                while(board[bx + dx[i]][by + dy[i]] != '#') {
                    bx += dx[i];
                    by += dy[i];
                    if(board[bx][by] == 'O') break;
                }
                
                int rx = p.rx;
                int ry = p.ry;
                while(board[rx + dx[i]][ry + dy[i]] != '#') {
                    rx += dx[i];
                    ry += dy[i];
                    if(board[rx][ry] == 'O') break;
                }
                
                if(board[bx][by] == 'O') continue;
                if(board[rx][ry] == 'O') {
                    System.out.println(p.cnt + 1);
                    return;
                }
                
                if(rx == bx && ry == by) {
                    switch(i) {
                        case 0 : if(p.ry < p.by) by++;
                            else ry++;
                            break;
                        case 1 : if(p.ry < p.by) ry--;
                            else by--;
                            break;
                        case 2 : if(p.rx < p.bx) bx++;
                            else rx++;
                            break;
                        case 3 : if(p.rx < p.bx) rx--;
                            else bx--;
                            break;
                    }
                }
                
                if(!visited[rx][ry][bx][by]) {
                    q.offer(new Point(rx, ry, bx, by, p.cnt + 1));
                }
            }
        }
        
        System.out.print(-1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        board = new char[n][m];
        visited = new boolean[n][m][n][m];
        
        Point point = new Point();
        point.cnt = 0;
        
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
                if(board[i][j] == 'R') {
                    point.rx = i;
                    point.ry = j;
                }
                if(board[i][j] == 'B') {
                    point.bx = i;
                    point.by = j;
                }
            }
        }
        
        bfs(point);
    }
}
