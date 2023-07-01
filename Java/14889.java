import java.io.*;
import java.util.*;
public class Main {
    public static int N;
    public static int[][] S;
    public static boolean[] visit;
    public static int ans = Integer.MAX_VALUE;
    
    public static void diff() {
        int start = 0;
        int link = 0;
        
        for(int i = 1; i <= N - 1; i++) {
            for(int j = i + 1; j <= N; j++) {
                if(visit[i] && visit[j]) {
                    start += S[i][j];
                    start += S[j][i];
                }
                if(!visit[i] && !visit[j]) {
                    link += S[i][j];
                    link += S[j][i];
                }
            }
        }
        
        int val = Math.abs(start - link);
        
        if(val == 0) {
            System.out.println(0);
            System.exit(0);
        }
        
        ans = Math.min(ans, val);
    }
    
    public static void comb(int idx, int depth) {
        if(depth == N / 2) {
            diff();
            return;
        }
        
        for(int i = idx; i <= N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                comb(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        S = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        comb(1, 0);
        
        bw.write(String.valueOf(ans));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
