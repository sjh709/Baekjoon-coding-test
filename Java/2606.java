import java.io.*;
import java.util.*;
public class Main {
    public static int n, m;
    public static boolean[][] graph;
    public static boolean[] visited;
    public static int answer;
    
    public static void dfs(int x) {
        answer++;
        visited[x] = true;
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && graph[x][i]) {
                dfs(i);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 0. 입력 및 초기화
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        
        // 1. 그래프 정보 입력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = true;
        }
        
        // 2. dfs 및 결과 출력
        dfs(1);
        
        System.out.println(answer - 1);
        
    }
}
