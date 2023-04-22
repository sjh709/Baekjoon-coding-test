import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        
        String result = String.valueOf(a * b * c);
        
        int[] num = new int[10];
        
        for(int i = 0; i < result.length(); i++) {
            int n = result.charAt(i) - '0';
            num[n]++;
        }
        
        for(int i = 0; i < 10; i++) {
            bw.append(String.valueOf(num[i]));
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
