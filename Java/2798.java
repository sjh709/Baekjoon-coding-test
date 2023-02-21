import java.io.*;
import java.util.*;
public class Main {
    public static int answer = 0;
    public static void bruteForce(int[] arr, boolean[] visit, int[] bfa, int m, int depth) {
        if(depth == 3) {
            int sum = bfa[0] + bfa[1] + bfa[2];
            if(sum <= m) {
                answer = Math.max(answer, sum);
            }
            return;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                bfa[depth] = arr[i];
                bruteForce(arr, visit, bfa, m, depth + 1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        boolean[] visit = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] bfa = new int[3];
        bruteForce(arr, visit, bfa, m, 0);
        
        bw.write(String.valueOf(answer));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
