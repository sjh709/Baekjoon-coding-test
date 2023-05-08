import java.io.*;
import java.util.*;
public class Main {
    public static int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int gcd = getGCD(a, b);
        int lcm = a * b / gcd;
        bw.write(String.valueOf(gcd) + "\n" + String.valueOf(lcm));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
