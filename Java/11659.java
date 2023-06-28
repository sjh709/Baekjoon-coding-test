import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        
        int[] num = new int[n + 1];
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            num[i] = num[i - 1] + Integer.parseInt(st2.nextToken());
            
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            
            int ans = num[b] - num[a - 1];
            bw.append(String.valueOf(ans) + "\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
