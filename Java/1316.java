import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            String arr = "";
            boolean chk = true;
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                if(j == 0) {
                    arr += c;
                }else {
                    if(c == s.charAt(j - 1)) {
                        continue;
                    }else {
                        if(arr.contains(String.valueOf(c))) {
                            chk = false;
                        }else {
                            arr += c;
                        }
                    }
                }
            }
            
            if(chk) answer++;
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
