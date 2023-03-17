import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        long[] psum = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        psum[0] = num[0];
        for(int i = 1; i < n; i++) {
            psum[i] = psum[i - 1] + num[i];
        }
        
        long answer = 0;
        for(int i = 0; i < n - 1; i++) {
            answer += (num[i] * (psum[n - 1] - psum[i]));
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
