import java.io.*;
import java.util.*;
public class Main {
    static int[][] board; // 지도
    static int[][] copy_board; // 복사 지도
    static List<int[]> canWall = new ArrayList<>(); // 벽으로 사용될 수 있는 칸
    static List<int[]> virus = new ArrayList<>();
    
    static int n, m;
    static int max_cnt; // 최대값 저장
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};
    
    // 안전 영역 크기 구하기 (0 세기)
    public static void solve() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(copy_board[i][j] == 0) cnt++;
            }
        }
        max_cnt = Math.max(max_cnt, cnt);
    }
    
    public static void dfs(int x, int y) {
        for(int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            // 범위 이탈
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            // 바이러스이거나 벽일때
            if(copy_board[nx][ny] == 2 || copy_board[nx][ny] == 1) continue;
            
            copy_board[nx][ny] = 2;
            dfs(nx, ny);
        }
    }
    
    // 지도를 복사하는 함수
    public static void board_init() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copy_board[i][j] = board[i][j];
            }
        }
    }
    
    public static void comb(int cnt, int start) {
        // 벽 3개
        if(cnt == 3) {
            board_init(); // 지도 복사
            for(int[] temp : virus) {
                dfs(temp[0], temp[1]);
            }
            solve(); // 안전영역 크기 구하기
            return;
        }
        
        for(int i = start; i < canWall.size(); i++) {
            board[canWall.get(i)[0]][canWall.get(i)[1]] = 1;
            comb(cnt + 1, i + 1);
            board[canWall.get(i)[0]][canWall.get(i)[1]] = 0;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        
        board = new int[n][m];
        copy_board = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
                if(board[i][j] == 0) canWall.add(new int[]{i, j});
                if(board[i][j] == 2) virus.add(new int[]{i, j});
            }
        }
        
        comb(0, 0);
        
        bw.write(String.valueOf(max_cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
