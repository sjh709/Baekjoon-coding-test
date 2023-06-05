import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            
            int cnt = 0;
            for(int i = n + 1; i <= 2 * n; i++) {
                boolean chk = true;
                if(i == 1) continue;
                for(int j = 2; j <= Math.sqrt(i); j++) {
                    if(i % j == 0) {
                        chk = false;
                        break;
                    }
                }
                
                if(chk) cnt++; 
            }
            
            bw.append(String.valueOf(cnt) + "\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
