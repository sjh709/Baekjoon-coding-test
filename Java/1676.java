import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int ans = (n / 5) + (n / 25) + (n / 125);
        
        bw.write(String.valueOf(ans));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
