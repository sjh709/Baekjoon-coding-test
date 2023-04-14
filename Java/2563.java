/*
- (100 * 100) map에 각 색종이 좌표를 체크한다
- map[][]이 1이상인 곳의 개수를 센다
*/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[][] map = new int[101][101];
        
        int n = Integer.parseInt(br.readLine());
        for(int k = 0; k < n; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int i = a; i < a + 10; i++) {
                for(int j = b; j < b + 10; j++) {
                    map[i][j]++;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                if(map[i][j] > 0) cnt++;
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
