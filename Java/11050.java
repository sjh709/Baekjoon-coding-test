import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // (nk) = nCk = n! / k! * (n - k)!
        
        int[] f = new int[11];
        
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < 11; i++) f[i] = f[i - 1] * i;
        
        int ans = f[n] / (f[k] * f[n - k]);
        
        bw.write(String.valueOf(ans));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
