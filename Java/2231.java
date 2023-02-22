import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        
        for(int i = 1; i < n; i++) {
            int number = i;
            int sum = i;
            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }
            
            if(sum == n) {
                result = i;
                break;
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
