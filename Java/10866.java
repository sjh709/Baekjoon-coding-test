import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> dq = new ArrayDeque<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push_front")) {
                int x = Integer.parseInt(st.nextToken());
                dq.offerFirst(x);
            }
            if(s.equals("push_back")) {
                int x = Integer.parseInt(st.nextToken());
                dq.offerLast(x);
            }
            if(s.equals("pop_front")) {
                if(dq.isEmpty()) {
                    bw.append("-1");
                }else {
                    bw.append(String.valueOf(dq.pollFirst()));
                }
                bw.append("\n");
            }
            if(s.equals("pop_back")) {
                if(dq.isEmpty()) {
                    bw.append("-1");
                }else {
                    bw.append(String.valueOf(dq.pollLast()));
                }
                bw.append("\n");
            }
            if(s.equals("size")) {
                bw.append(String.valueOf(dq.size()) + "\n");
            }
            if(s.equals("empty")) {
                if(dq.isEmpty()) {
                    bw.append("1");
                }else {
                    bw.append("0");
                }
                bw.append("\n");
            }
            if(s.equals("front")) {
                if(dq.isEmpty()) {
                    bw.append("-1");
                }else {
                    bw.append(String.valueOf(dq.peekFirst()));
                }
                bw.append("\n");
            }
            if(s.equals("back")) {
                if(dq.isEmpty()) {
                    bw.append("-1");
                }else {
                    bw.append(String.valueOf(dq.peekLast()));
                }
                bw.append("\n");
            }
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
