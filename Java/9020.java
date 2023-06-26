import java.io.*;
import java.util.*;
public class Main {
    public static boolean pnum(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine());
            
            int a = 0, b = 0;
            for(int i = 2; i <= n / 2; i++) {
                boolean chk = pnum(i);
                
                if(chk) {
                    chk = pnum(n - i);
                    
                    if(chk) {
                        a = i;
                        b = n - i;
                    }
                }
            }
            
            bw.append(a + " " + b + "\n");
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
