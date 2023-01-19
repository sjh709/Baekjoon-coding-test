import java.util.*;
public class Main {
    public final static int INF = 1 << 30;
    public static int[] a;
    public static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 0. 입력 받으며 중복 숫자 제거
        int n = sc.nextInt();
        int k = sc.nextInt();
        a = new int[n + 1];
        dp = new int[n + 1][n + 1];
        
        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if(a[i] == a[i - 1]) {
                n--;
                i--;
            }
        }
        
        // 1. dp 배열 초기화 : i부터 j까지의 전구를 하나로 통일하기 위한 최소 변경 수
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = INF;
            }
            dp[i][i] = 0;
        }
        
        // 2. 두 개 이상의 전구들 간의 최솟값 계산
        for(int size = 2; size <= n; size++) {
            for(int start = 1; start <= n - size + 1; start++) {
                int end = start + size - 1;
                for(int mid = start; mid < end; mid++) {
                    // ver 1
					// int newValue = dp[start][mid] + dp[mid + 1][end];
					// if(a[start] != a[mid + 1]) newValue++;
					// if(dp[start][end] > newValue) dp[start][end] = newValue;
					// ver 2
					// int newValue = dp[start][mid] + dp[mid + 1][end] + (a[start] != a[mid + 1] ? 1 : 0);
					// dp[start][end] = Math.min(dp[start][end], newValue);
					// ver 3
					dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + (a[start] != a[mid + 1] ? 1 : 0));
                }
            }
        }
        
        System.out.println(dp[1][n]);
        sc.close();
    }
}
