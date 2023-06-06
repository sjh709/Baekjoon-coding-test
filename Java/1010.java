import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int num = 1;
            for(int j = 0; j < n; j++) {
                num = num * (m - j) / (j + 1);
            }
            
            bw.append(String.valueOf(num) + "\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
