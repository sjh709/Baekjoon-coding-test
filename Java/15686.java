import java.io.*;
import java.util.*;
public class Main {
    public static int n, m;
    public static int[][] map;
    public static List<int[]> temp = new ArrayList<>();
    public static List<int[]> chic, home;
    public static int answer = Integer.MAX_VALUE;
    
    public static void solve() {
        int sum = 0;
        for(int i = 0; i < home.size(); i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < chic.size(); j++) {
                int value = Math.abs(home.get(i)[0] - chic.get(j)[0]) 
                    + Math.abs(home.get(i)[1] - chic.get(j)[1]);
                min = Math.min(min, value);
            }
            sum += min;
        }
        answer = Math.min(answer, sum);
    }
    
    public static void init() {
        chic = new ArrayList<>();
        home = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 1) home.add(new int[] {i, j});
                if(map[i][j] == 2) chic.add(new int[] {i, j});
            }
        }
        solve();
    }
    
    public static void comb(int cnt, int start) {
        if(cnt == (temp.size() - m)) {
            init();
            return;
        }
        for(int i = start; i < temp.size(); i++) {
            map[temp.get(i)[0]][temp.get(i)[1]] = 0;
            comb(cnt + 1, i + 1);
            map[temp.get(i)[0]][temp.get(i)[1]] = 2;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) temp.add(new int[] {i, j});
            }
        }
        
        if(temp.size() == m) init();
        else comb(0, 0);
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
