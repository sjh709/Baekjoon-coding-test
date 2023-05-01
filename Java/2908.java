import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String A = st.nextToken();
        String B = st.nextToken();
        
        String chk = "";
        String answer = "";
        for(int i = 2; i >= 0; i--) {
            int a = A.charAt(i) - '0';
            int b = B.charAt(i) - '0';
            
            if(a > b) {
                chk = "A";
                break;
            }else if(a < b) {
                chk = "B";
                break;
            }else {
                continue;
            }
        }
        
        for(int i = 2; i >= 0; i--) {
            if(chk.equals("A")) {
                answer += A.charAt(i);
            }else {
                answer += B.charAt(i);
            }
        }
        
        bw.write(answer);
        bw.flush();
        
        bw.close();
        br.close();
    }
}
