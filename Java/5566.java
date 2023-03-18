import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] move = new int[n];
        for(int i = 0; i < n; i++) {
            move[i] = Integer.parseInt(br.readLine());
        }
        
        int score = 1;
        for(int i = 0; i < m; i++) {
            int dice = Integer.parseInt(br.readLine());
            score += dice;
            if(score >= n) {
                bw.write(String.valueOf(i + 1));
                break;
            }
            score += move[score - 1];
            if(score >= n) {
                bw.write(String.valueOf(i + 1));
                break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
