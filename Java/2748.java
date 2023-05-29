import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        long[] fibo = new long[n + 1];
        
        if(n == 0) fibo[n] = 0;
        else if(n == 1) fibo[n] = 1;
        else {
            fibo[0] = 0;
            fibo[1] = 1;
            for(int i = 2; i <= n; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
        }
        
        bw.write(String.valueOf(fibo[n]));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
