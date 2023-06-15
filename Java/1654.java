import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        
        int[] num = new int[k];
        for(int i = 0; i < k; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(num);
        
        long start = 1;
        long end = num[k - 1];
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            long result = 0;
            for(int i = 0; i < k; i++) {
                result += num[i] / mid;
            }
            
            if(result < n) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        
        bw.write(String.valueOf(end));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
