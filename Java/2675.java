import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String p = "";
            
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                for(int k = 0; k < r; k++) {
                    p += c;
                }
            }
            
            bw.append(p + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
