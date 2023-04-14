/*
1. 아이디어
- while문으로, 특정조건 종료될때까지 반복
- 4방향을 for문으로 탐색
- 더이상 탐색이 불가능해질 경우, 뒤로 한칸 후진
- 후진이 불가능하면 종료

2. 시간복잡도
- O(NM) : 50^2 = 2500 < 2억
- 가능

3. 자료구조
- map : int[][]
- 로봇청소기 위치, 방향, 전체 청소한 곳 수
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int cnt = 0;
        while(true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(map[y][x] == 0) {
                map[y][x] = 2;
                cnt++;
            }
            
            boolean check = false;
            
            // 현재 칸의 주변 4칸 탐색
            int[] dy = {-1, 0, 1, 0};
            int[] dx = {0, 1, 0, -1};
            for(int i = 1; i <= 4; i++) {
                int ny = y + dy[(d - i + 4) % 4];
                int nx = x + dx[(d - i + 4) % 4];
                // 범위 안에 있어야 함
                if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    // 청소되지 않은 빈 칸이 있는 경우
                    if(map[ny][nx] == 0) {
                        y = ny;
                        x = nx;
                        d = (d - i + 4) % 4;
                        check = true;
                        break;
                    }
                }
            }
            
            // 청소되지 않은 빈 칸이 없는 경우
            if(!check) {
                int ny = y - dy[d];
                int nx = x - dx[d];
                // 범위 안에 있어야 함
                if(ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if(map[ny][nx] == 1) {
                        break;
                    }else {
                        y = ny;
                        x = nx;
                    }
                }else {
                    break;
                }
            }   
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
