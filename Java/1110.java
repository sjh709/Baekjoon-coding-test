import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String s = "";
        if(n < 10) s = "0" + String.valueOf(n);
        else s = String.valueOf(n);
        
        int cnt = 0;
        while(true) {
            cnt++;
            String ss = String.valueOf(n % 10) + String.valueOf(((n / 10) + (n % 10)) % 10);
            if(s.equals(ss)) break;
            n = Integer.parseInt(ss);
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
