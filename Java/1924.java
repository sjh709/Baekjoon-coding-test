import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] date = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        
        int num = 0;
        for(int i = 0; i <= (x - 1); i++) {
            num += day[i];
        }
        
        num += (y - 1);
        bw.write(date[num % 7]);
        bw.flush();
        
        bw.close();
        br.close();
    }
}
