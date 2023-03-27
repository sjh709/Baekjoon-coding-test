import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = st.countTokens();
        
        String AB = "", CD = "";
        String[] s = new String[n];
        for(int i = 0; i < n; i++) {
            s[i] = st.nextToken();
        }
        
        AB += s[0] + s[1];
        CD += s[2] + s[3];
        
        BigInteger b1 = new BigInteger(AB);
        BigInteger b2 = new BigInteger(CD);
        
        bw.write(String.valueOf(b1.add(b2)));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
