import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double m = 0;
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            m = Math.max(m, nums[i]);
        }
        
        double sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i] / m * 100;
        }
        
        bw.write(String.valueOf(sum / n));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
