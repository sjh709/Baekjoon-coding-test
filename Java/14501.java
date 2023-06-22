import java.io.*;
import java.util.*;
public class Main {
    public static int n;
    public static int[][] arr;
    public static int ans = 0;
    public static void dfs(int day, int sum) {
        if(day >= n + 1) {
            ans = Math.max(ans, sum);
            return;
        }
        // 상담 가능
        if(arr[day][0] + day <= n + 1) {
            dfs(arr[day][0] + day, arr[day][1] + sum);
        }
        // 상담 불가능
        dfs(day + 1, sum);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n + 1][2];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, 0);
        
        bw.write(String.valueOf(ans));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
