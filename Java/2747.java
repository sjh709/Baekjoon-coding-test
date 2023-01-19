import java.util.*;

public class Main {
	public static int[] dp;
	public static int fibo(int n) {
		// 2. 탈출 조건
		if(dp[n] == -1) // 한번도 연산된 적이 없다면
			dp[n] = fibo(n - 1) + fibo(n - 2);
		
		// 1. 기본 동작
		return dp[n];
	}
	
	public static void main(String[] args) {
		// 재귀 함수
		// 1. 재귀 함수의 기본 동작
		// 2. 재귀 함수의 탈출 조건
		
		Scanner sc = new Scanner(System.in);
		
		// ver 2
//		int n = sc.nextInt();
//		dp = new int[100];
//		Arrays.fill(dp, -1);
//		dp[0] = 0;
//		dp[1] = 1;
//		System.out.println(fibo(n));
		
		// ver 3
		int n = sc.nextInt();
		dp = new int[100];
		dp[1] = 1;
		for(int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[n]);
		
	}
}
