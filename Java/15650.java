import java.io.*;
import java.util.*;
public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static void solve(int n, boolean[] visit, int[] arr, int depth, int m) {
        if(depth == m) {
            for(int i = 0; i < arr.length; i++) {
                sb.append(String.valueOf(arr[i]) + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!visit[i]) {
                if(depth > 0 && arr[depth - 1] > i) continue;
                visit[i] = true;
                arr[depth] = i;
                solve(n, visit, arr, depth + 1, m);
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
        
        boolean[] visit = new boolean[n + 1];
        int[] arr = new int[m];
        
        solve(n, visit, arr, 0, m);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
