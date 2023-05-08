import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        for(int l = 0; l < t; l++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[k + 1][n + 1];
            for(int i = 0; i <= k; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == 0) {
                        arr[i][j] = j;
                    }else {
                        arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                    }
                }
            }
            bw.append(arr[k][n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
