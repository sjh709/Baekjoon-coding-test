import java.io.*;
import java.util.*;
public class Main {
    public static int time = 0;
    public static int hx, hy, tx, ty;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static ArrayList<int[]> snake = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        boolean[][] apple = new boolean[n][n];
        
        arr[0][0] = 1;
        snake.add(new int[]{0, 0});
        
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            apple[a - 1][b - 1] = true;
        }
        
        int l = Integer.parseInt(br.readLine());
        HashMap<Integer, String> map = new HashMap<>();
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            map.put(x, c);
        }
        
        int d = 0;
        while(true) {
            time++;
            hx += dx[d];
            hy += dy[d];
            
            if(hx < 0 || hy < 0 || hx >= n || hy >= n) break;
            if(arr[hx][hy] == 1) break;
            
            arr[hx][hy] = 1;
            snake.add(new int[]{hx, hy});
            
            if(apple[hx][hy]) {
                apple[hx][hy] = false;
            }else {
                int[] t = snake.get(0);
                arr[t[0]][t[1]] = 0;
                
                snake.remove(0);
            }
            
            if(map.containsKey(time)) {
                if(map.get(time).equals("D")) {
                    d++;
                    if(d == 4) d = 0;
                }
                
                if(map.get(time).equals("L")) {
                    d--;
                    if(d == -1) d = 3;
                }
            }
        }
        
        bw.write(String.valueOf(time));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
