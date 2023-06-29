import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int k = Integer.parseInt(st1.nextToken());
        
        int[][] arr = new int[n][k + 1];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            
            if(i == 0) {
                for(int j = w; j <= k; j++) {
                    arr[i][j] = v;
                }
            }else {
                for(int j = 0; j <= k; j++) {
                    if(j - w >= 0) {
                        arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w] + v);
                    }else {
                        arr[i][j] = arr[i - 1][j];
                    }
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i <= k; i++) {
            ans = Math.max(ans, arr[n - 1][i]);
        }
        
        bw.write(String.valueOf(ans));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
