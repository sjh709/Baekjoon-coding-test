import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long[] p = new long[101];
        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;
        for(int i = 6; i < 101; i++) {
            p[i] = p[i - 5] + p[i - 1];
        }
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(p[n]) + "\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
