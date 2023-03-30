/*import java.io.*;
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
}*/

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n + 1][6];
        
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        boolean[][] visit = new boolean[n + 1][n + 1];
        for(int i = 1; i <= 5; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = j + 1; k <= n; k++) {
                    if(arr[j][i] == arr[k][i]) {
                        visit[j][k] = true;
                        visit[k][j] = true;
                    }
                }
            }
        }
        
        int max = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                if(visit[i][j]) cnt++;
            }
            hash.put(i, cnt);
            max = Math.max(max, cnt);
        }
        
        int answer = 3000;
        for(int key : hash.keySet()) {
            int value = hash.get(key);
            if(value == max) {
                answer = Math.min(answer, key);
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
