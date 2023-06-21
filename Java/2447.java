import java.io.*;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    
    public static void solve(int x, int y) {
        while(true) {
            if(x == 0 || y == 0) break;
            if(x % 3 == 1 && y % 3 == 1) {
                sb.append(" ");
                return;
            }
            x /= 3;
            y /= 3;
        }
        sb.append("*");
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                solve(i, j);
            }
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
