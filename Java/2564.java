import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][2];
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        if(x == 1) {
            for(int i = 0; i < t; i++) {
                int a = arr[i][0];
                int b = arr[i][1];
                
                if(a == 1) {
                    answer += Math.abs(y - b);
                }else if(a == 2) {
                    int t1 = (n - y) + m + (n - b);
        			int t2 = y + m + b;
        			answer += Math.min(t1, t2);
                }else if(a == 3) {
                    int t1 = (n - y) + m + n + (m - b);
        			int t2 = y + b;
        			answer += Math.min(t1, t2);
                }else {
                    int t1 = (n - y) + b;
        			int t2 = y + m + n + (m - b);
        			answer += Math.min(t1, t2);
                }
            }
        }else if(x == 2) {
            for(int i = 0; i < t; i++) {
                int a = arr[i][0];
                int b = arr[i][1];
                
                if(a == 1) {
                    int t1 = y + m + b;
        			int t2 = (n - y) + m + (n - b);
        			answer += Math.min(t1, t2);
                }else if(a == 2) {
                    answer += Math.abs(y - b);
                }else if(a == 3) {
                    int t1 = y + (m - b);
        			int t2 = (n - y) + m + n + b;
        			answer += Math.min(t1, t2);
                }else {
                    int t1 = y + m + n +  b;
        			int t2 = (n - y) + (m - b);
        			answer += Math.min(t1, t2);
                }
            }
        }else if(x == 3) {
            for(int i = 0; i < t; i++) {
                int a = arr[i][0];
                int b = arr[i][1];
                
                if(a == 1) {
                    int t1 = y + b;
        			int t2 = (m - y) + n + m + (n - b);
        			answer += Math.min(t1, t2);
                }else if(a == 2) {
                    int t1 = y + n + m + (n - b);
        			int t2 = (m - y) + b;
        			answer += Math.min(t1, t2);
                }else if(a == 3) {
                    answer += Math.abs(y - b);
                }else {
                    int t1 = y + n + b;
        			int t2 = (m - y) + n + (m - b);
        			answer += Math.min(t1, t2);
                }
            }
        }else {
            for(int i = 0; i < t; i++) {
                int a = arr[i][0];
                int b = arr[i][1];
                
                if(a == 1) {
                    int t1 = (m - y) + n + m + b;
        			int t2 = y + (n - b);
        			answer += Math.min(t1, t2);
                }else if(a == 2) {
                    int t1 = (m - y) + (n - b);
        			int t2 = y + n + m + b;
        			answer += Math.min(t1, t2);
                }else if(a == 3) {
                    int t1 = (m - y) + n + (m - b);
        			int t2 = y + n + b;
        			answer += Math.min(t1, t2);
                }else {
                    answer += Math.abs(y - b);
                }
            }
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
