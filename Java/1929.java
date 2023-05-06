import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        for(int i = m; i <= n; i++) {
            if(i == 1) continue;
            boolean chk = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    chk = false;
                    break;
                }
            }
            if(chk) bw.append(String.valueOf(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
