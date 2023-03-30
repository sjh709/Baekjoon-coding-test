import java.io.*;
import java.util.*;
public class Main {
    public static int getClockNum(String s) {
        int min = 9999;
        for(int i = 0; i < 4; i++) {
            String number = "";
            number += s.substring(i, 4) + s.substring(0, i);
            min = Math.min(min, Integer.parseInt(number));
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String s = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            s += st.nextToken();
        }
        
        int clockNum = getClockNum(s);
        
        int cnt = 0;
        for(int i = 1111; i <= 9999; i++) {
            if(String.valueOf(i).contains("0")) continue; 
            int num = getClockNum(String.valueOf(i));
            if(num != i) continue;
            if(num < clockNum) cnt++;
            if(num == clockNum) {
                cnt++;
                break;
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
