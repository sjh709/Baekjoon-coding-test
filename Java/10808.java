import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = br.readLine();
        
        int[] c = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            c[n]++;
        }
        
        for(int i = 0; i < c.length; i++) {
            bw.write(c[i] + " ");
            bw.flush();
        }
        
        bw.close();
        br.close();
    }
}
