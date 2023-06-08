import java.io.*;
import java.util.*;
public class Main {
    public static int n;
    public static int ans = 0;
    public static boolean[] check1 = new boolean[15]; // 상하
    public static boolean[] check2 = new boolean[28]; // 왼쪽대각선 | 14 - 1 + 14 = 27
    public static boolean[] check3 = new boolean[29]; // 오른쪽대각선 | 14 + 14 = 28
    
    public static void dfs(int i) {
        if(i == n + 1) {
            ans++;
            return;
        }
        
        for(int j = 1; j <= n; j++) {
            if(!check1[j] && !check2[i - j + 14] & !check3[i + j]) {
                check1[j] = check2[i - j + 14] = check3[i + j] = true;
                dfs(i + 1);
                check1[j] = check2[i - j + 14] = check3[i + j] = false;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        dfs(1);
        
        bw.write(String.valueOf(ans));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
