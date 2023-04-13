import java.io.*;
import java.util.*;
public class Main {
    public static void solve(int n, int m, int[] arr, boolean[] visit, int depth, StringBuilder sb) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 1; i <= n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                solve(n, m, arr, visit, depth + 1, sb);
                visit[i] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[m];
        boolean[] visit = new boolean[n + 1];
        
        StringBuilder sb = new StringBuilder();
        
        solve(n, m, arr, visit, 0, sb);
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
