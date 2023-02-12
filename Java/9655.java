import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int turn = 0;
        
        while(n > 0) {
            if(n >= 3) {
                n -= 3;
            }else {
                n -= 1;
            }
            turn++;
        }
        
        if(turn % 2 == 0) {
            bw.write("CY");
        }else {
            bw.write("SK");
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}
