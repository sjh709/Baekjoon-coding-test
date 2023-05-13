import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int count = 0;
        int value = 666;
        while(n > count) {
            String s = String.valueOf(value);
            if(s.contains("666")) {
                count++;
                value++;
            }else {
                value++;
            }
        }
        
        bw.write(String.valueOf(value - 1));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
