import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if(x == 0) {
                if(pq.isEmpty()) {
                    bw.append("0\n");
                }else {
                    bw.append(pq.poll() + "\n");
                }
            }else {
                pq.offer(x);
            }
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
