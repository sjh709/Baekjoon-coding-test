import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            String s = br.readLine();
            if(s.equals("0")) break;
            if(s.length() == 1) {
                bw.append("yes\n");
                continue;
            }
            
            boolean chk = true;
            for(int i = 0;  i < s.length() / 2; i++) {
                if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    chk = false;
                    break;
                }
            }
            
            if(chk) {
                bw.append("yes\n");
            }else {
                bw.append("no\n");
            }
                
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
