/*
1. 아이디어
- 모든점 -> 모든점 : 플로이드
- 비용배열 INF 초기화
- 간선의 비용 대입
- 거쳐서 비용 줄어들경우, 갱신(for문 3번)

2. 시간복잡도
- 플로이드 : O(V^3)
- 1e6 : 가능

3. 변수
- 비용 배열, int[][]
*/
import java.io.*;
import java.util.*;
public class Main {
    static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[][] map = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                map[i][j] = INF;
                if(i == j) map[i][j] = 0;
            }
        }
        
        StringTokenizer st ;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            map[a][b] = Math.min(map[a][b], c);
        }
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(map[i][j] == INF) sb.append(0 + " ");
                else sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
