import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int height = (h - 1) / (n + 1) + 1;
        int width = (w - 1) / (m + 1) + 1;
        
        bw.write(String.valueOf(height * width));
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
