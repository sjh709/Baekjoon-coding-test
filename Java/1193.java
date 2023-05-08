import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int line = 0;
        
        int a = 0; // 분자
        int b = 0; // 분모
        
        while(cnt < x) {
            line++;
            cnt = line * (line + 1) / 2;
        }
        
        if(line % 2 == 0) {
            a = line - cnt + x;
            b = 1 + cnt - x;
        }else {
            a = 1 + cnt - x;
            b = line - cnt + x;
        }
        
        bw.write(String.valueOf(a) + "/" + String.valueOf(b));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
