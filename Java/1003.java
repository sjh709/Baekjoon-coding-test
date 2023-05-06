import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] zero = new int[n + 1];
            int[] one = new int[n + 1];
            
            if(n == 0) {
                zero[0] = 1;
                one[0] = 0;
            }else {
                zero[0] = 1; zero[1] = 0;
                one[0] = 0; one[1] = 1;
            }
            
            if(n < 2) {
                bw.append(String.valueOf(zero[n]) + " " + String.valueOf(one[n]) + "\n");
                continue;
            }
            
            for(int j = 2; j <= n; j++) {
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = one[j - 1] + one[j - 2];
            }
            bw.append(String.valueOf(zero[n]) + " " + String.valueOf(one[n]) + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
