import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        char[][] arr = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        
        int w_cnt = 0, w_answer = 0;
        int h_cnt = 0, h_answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == '.') w_cnt++;
                if(arr[j][i] == '.') h_cnt++;
                
                if(arr[i][j] == 'X' || j == n - 1) {
                    if(w_cnt >= 2) w_answer++;
                    w_cnt = 0;
                }
                if(arr[j][i] == 'X' || j == n - 1) {
                    if(h_cnt >= 2) h_answer++;
                    h_cnt = 0;
                }
             }
        }
        
        bw.write(String.valueOf(w_answer) + " " + String.valueOf(h_answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
