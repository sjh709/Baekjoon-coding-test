import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        
        int t = Integer.parseInt(br.readLine());
        
        for(int k = 0; k < t; k++) {
        	int n = Integer.parseInt(br.readLine());
        	
        	int[][] stickers = new int[2][n + 1];
        	int[][] dp = new int[2][n + 1];
        	
        	for(int i = 0; i < 2; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		for(int j = 1; j <= n; j++) {
        			stickers[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	dp[0][1] = stickers[0][1];
        	dp[1][1] = stickers[1][1];
        	
        	for(int i = 2; i <= n; i++) {
        		dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
        		dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
        	}
        	
        	bw.append(String.valueOf(Math.max(dp[0][n], dp[1][n]))).append("\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
