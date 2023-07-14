import java.io.*;
import java.util.*;
public class Main {
	public static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int row = str1.length();
		int column = str2.length();
		
		dp = new int[row + 1][column + 1];
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= column; j++) {
				if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		bw.write(String.valueOf(dp[row][column]));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
