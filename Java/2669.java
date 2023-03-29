import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[][] map = new boolean[101][101];
        for(int k = 0; k < 4; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for(int i = y1; i < y2; i++) {
                for(int j = x1; j < x2; j++) {
                    map[i][j] = true;
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                if(map[i][j]) cnt++;
            }
        }
        
        bw.write(String.valueOf(cnt));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
