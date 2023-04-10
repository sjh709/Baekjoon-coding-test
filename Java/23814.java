import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long D = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        
        long maxMandu = (N + M + K) / D;
        
        long answer = 0;
        
        // K명 -> 전부 볶음밥
        long max = (N / D) + (M / D) + (K / D);
        if(max == maxMandu) answer = Math.max(answer, K);
        
        // K명 -> 짜장면 + 볶음밥
        long a = D - (N % D);
        max = ((N + a) / D) + (M / D) + ((K - a) / D);
        if(max == maxMandu) answer = Math.max(answer, (K - a));
        
        // K명 -> 짬뽕 + 볶음밥
        long b = D - (M % D);
        max = (N / D) + ((M + b) / D) + ((K - b) / D);
        if(max == maxMandu) answer = Math.max(answer, (K - b));
        
        // K명 -> 짜장면 + 짬뽕 + 볶음밥
        a = D - (N % D);
        b = D - (M % D);
        max = ((N + a) / D) + ((M + b) / D) + ((K - a - b) / D);
        if(max == maxMandu) answer = Math.max(answer, (K - a - b));
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
