import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean[][] arr = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if(c == 'B') arr[i][j] = true;
            }
        }
        
        int answer = 64;
        for(int r = 0; r < n - 7; r++) {
            for(int c = 0; c < m - 7; c++) {
                boolean first = arr[r][c];
                int count = 0;
                for(int i = r; i < r + 8; i++) {
                    for(int j = c; j < c + 8; j++) {
                        if(arr[i][j] != first) {
                            count++;
                        }
                        first = (!first);
                    }
                    first = (!first);
                }
                count = Math.min(count, 64 - count);
                answer = Math.min(answer, count);
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
