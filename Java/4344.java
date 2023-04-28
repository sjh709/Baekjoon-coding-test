import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] nums = new int[n];
            int avg = 0;
            for(int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
                avg += nums[j];
            }
            avg /= n;
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(nums[j] > avg) cnt++;
            }
            double answer = cnt / (double) n * 100;
            System.out.printf("%.3f%%\n", answer);
        }
        br.close();
    }
}
