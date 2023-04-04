import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int idx = Integer.parseInt(br.readLine());
        long num = Long.parseLong(br.readLine());
        
        long answer = 0;
        if(idx == 1) {
            answer = 8 * num;
        }else if(idx == 5) {
            answer = 8 * num + 4;
        }else {
            if(num % 2 == 0) {
                answer = 4 * num + 1 + (idx - 2);
            }else {
                answer = 4 * num + 1 + (4 - idx);
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
