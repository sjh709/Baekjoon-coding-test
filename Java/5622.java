import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] num = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        
        String s = br.readLine();
        
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            for(int j = 2; j < num.length; j++) {
                if(num[j].contains(String.valueOf(c))) {
                    answer += j + 1;
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
