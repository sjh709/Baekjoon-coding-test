import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] board = new int[n + 1][6];
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();
        for(int i = 0; i <= n; i++) {
            hash.put(i, new ArrayList<Integer>());
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= 5; j++) {
                //solve(i, j);
                for(int k = 1; k <= n; k++) {
                    if(i == k) continue;
                    if(board[i][j] == board[k][j]) {
                        ArrayList<Integer> list = hash.get(i);
                        if(!list.contains(k)) {
                            cnt++;
                            list.add(k);
                        }
                        hash.put(i, list);
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        
        int answer = 1000;
        for(int i = 1; i <= n; i++) {
            ArrayList<Integer> list = hash.get(i);
            if(list.size() == max) {
                answer = Math.min(answer, i);
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
