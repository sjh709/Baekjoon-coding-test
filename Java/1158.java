import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList();
        for(int i = 1; i <= n; i++) q.offer(i);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(!q.isEmpty()) {
            for(int i = 1; i <= k; i++) {
                int num = q.poll();
                if(i == k) {
                    sb.append(String.valueOf(num) + ", ");
                }else {
                    q.offer(num);
                }
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
