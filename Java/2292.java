import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int idx = 1;
        int cnt = 1;
        
        while(n != 1) {
            idx += 6 * cnt;
            cnt++;
            if(n <= idx) {
                break;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
