import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            String ans = "";
            String s = br.readLine();
            
            ans += s.charAt(0);
            ans += s.charAt(s.length() - 1);
            
            bw.append(ans + "\n");
        }
        
        bw.flush();
    
        bw.close();
        br.close();
    }
}
