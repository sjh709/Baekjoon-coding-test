import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        for(int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if(i % 10 == 0) {
                bw.append(c + "\n");
            }else {
                bw.append(c);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
