import java.io.*;
import java.util.*;
public class Main {
	public static int n;
	public static int[] dp;
	
	public static void solve() {
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n + 1];
		
		solve();
		
		bw.write(dp[n] + "\n");
		bw.flush();
		
		bw.close();
		br.close();
	}
}
