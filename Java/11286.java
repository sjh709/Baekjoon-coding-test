import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }else {
                    // 절대값 기준으로 오름차순
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            
            if(x == 0) {
                if(pq.isEmpty()) {
                    bw.append("0").append("\n");
                }else {
                    bw.append(String.valueOf(pq.poll())).append("\n");
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
