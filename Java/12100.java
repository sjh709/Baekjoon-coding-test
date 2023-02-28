import java.io.*;
import java.util.*;
public class Main {
    public static int n;
    public static int[][] board;
    public static int max = 0;
    public static void move(int dir) {
        switch(dir) {
            case 0 : // 위
                for(int i = 0; i < n; i++) {
                    int block = 0;
                    int emptyIndex = 0;
                    for(int j = 0; j < n; j++) {
                        if(board[j][i] != 0) {
                            if(board[j][i] == block) {
                                board[emptyIndex - 1][i] = block * 2;
                                board[j][i] = 0;
                                block = 0;
                            }else {
                                block = board[j][i];
                                if(emptyIndex != j) {
                                    board[emptyIndex][i] = block;
                                    board[j][i] = 0;
                                }
                                emptyIndex++;
                            }
                        }
                    }
                }
                break;
            case 1 : // 아래
                for(int i = 0; i < n; i++) {
                    int block = 0;
                    int emptyIndex = n - 1;
                    for(int j = n - 1; j >= 0; j--) {
                        if(board[j][i] != 0) {
                            if(board[j][i] == block) {
                                board[emptyIndex + 1][i] = block * 2;
                                board[j][i] = 0;
                                block = 0;
                            }else {
                                block = board[j][i];
                                if(emptyIndex != j) {
                                    board[emptyIndex][i] = block;
                                    board[j][i] = 0;
                                }
                                emptyIndex--;
                            }
                        }
                    }
                }
                break;
            case 2 : // 왼쪽
                for(int i = 0; i < n; i++) {
                    int block = 0;
                    int emptyIndex = 0;
                    for(int j = 0; j < n; j++) {
                        if(board[i][j] != 0) {
                            if(board[i][j] == block) {
                                board[i][emptyIndex - 1] = block * 2;
                                board[i][j] = 0;
                                block = 0;
                            }else {
                                block = board[i][j];
                                if(emptyIndex != j) {
                                    board[i][emptyIndex] = block;
                                    board[i][j] = 0;
                                }
                                emptyIndex++;
                            }
                        }
                    }
                }
                break;
            case 3 : // 오른쪽
                for(int i = 0; i < n; i++) {
                    int block = 0;
                    int emptyIndex = n - 1;
                    for(int j = n - 1; j >= 0; j--) {
                        if(board[i][j] != 0) {
                            if(board[i][j] == block) {
                                board[i][emptyIndex + 1] = block * 2;
                                board[i][j] = 0;
                                block = 0;
                            }else {
                                block = board[i][j];
                                if(emptyIndex != j) {
                                    board[i][emptyIndex] = block;
                                    board[i][j] = 0;
                                }
                                emptyIndex--;
                            }
                        }
                    }
                }
                break;
        }
    }
    
    public static void solve(int cnt) {
        if(cnt == 5) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(board[i][j] > max) {
                        max = board[i][j];
                    }
                }
            }
            return;
        }
        
        // 백트래킹 위한 복사본
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        
        for(int dir = 0; dir < 4; dir++) {
            move(dir);
            solve(cnt + 1);
            // 백트래킹
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    board[i][j] = copy[i][j];
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        
        board = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve(0);
        
        bw.write(String.valueOf(max));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
