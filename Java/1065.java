import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        if(n <= 99) {
            result = n;
        }else {
            result = 99;
            
            for(int i = 100; i <= n; i++) {
                String s = String.valueOf(i);
                
                int gap = 0;
                boolean chk = true;
                
                for(int j = 1; j < s.length(); j++) {
                    int a = s.charAt(j) - '0';
                    int b = s.charAt(j - 1) - '0';
                    
                    if(j == 1) {
                        gap = a - b;
                    }else {
                        if(gap != (a - b)) {
                            chk = false;
                            break;
                        }
                    }
                }
                
                if(chk) result++;
            }
        }
        
        bw.write(String.valueOf(result));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
