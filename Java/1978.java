import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int result = 0;
        
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean chk = true;
            
            if(num == 1) continue;
            
            for(int j = 2; j <= Math.sqrt(num); j++) {
                if(num % j == 0) {
                    chk = false;
                    break;
                }
            }
            
            if(chk) result++;
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
