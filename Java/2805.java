import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] num = new int[n];
        st = new StringTokenizer(br.readLine());
        
        int min = 0;
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, num[i]);
        }
        
        int mid = 0;
        long result = 0;
        
        while(min <= max) {
            mid = (min + max) / 2;
            result = 0;
            
            for(int i = 0; i < n; i++) {
                if(num[i] > mid) result += (num[i] - mid);
            }
            
            if(result >= m) {
                min = mid + 1;
            }else {
                max = mid - 1;
            }
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
