import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] wine = new int[n + 1];
        int[] dp = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            wine[i + 1] = Integer.parseInt(br.readLine());
        }
        
        if(n == 1) dp[1] = wine[1];
        else if(n == 2) dp[2] = wine[1] + wine[2];
        else {
            dp[1] = wine[1];
            dp[2] = dp[1] + wine[2];
            for(int i = 3; i <= n; i++) {
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
            }
        }
        
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
