import java.io.*;
import java.util.*;
public class Main {
    public static int n, m;
    public static int[] num, ans;
    public static StringBuilder sb;
    
    public static void solve(int depth) {
        if(depth == m) {
            boolean chk = true;
            for(int i = 1; i < m; i++) {
                if(ans[i - 1] > ans[i]) {
                    chk = false;
                    break;
                }
            }
            
            if(chk) {
                for(int i = 0; i < m; i++) {
                    sb.append(String.valueOf(ans[i]) + " ");
                }
                sb.append("\n");
            }
            
            return;
        }
        
        for(int i = 1; i <= n; i++) {
            ans[depth] = num[i];
            solve(depth + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        num = new int[n + 1];
        ans = new int[m];
        for(int i = 1; i <= n; i++) num[i] = i;
        
        sb = new StringBuilder();
        
        solve(0);
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
