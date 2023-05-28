import java.io.*;
import java.util.*;
public class Main {
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void hanoi(int n, int start, int mid, int to) throws IOException {
        if(n == 1) {
            bw.append(start + " " + to + "\n");
            return;
        }
        
        // 1. start -> mid
        hanoi(n - 1, start, to, mid);
        // 2. (start, to)
        bw.append(start + " " + to + "\n");
        // 3. mid -> to
        hanoi(n - 1, mid, start, to);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        bw.append((int)Math.pow(2, n) - 1 + "\n");
            
        hanoi(n, 1, 2, 3);
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
