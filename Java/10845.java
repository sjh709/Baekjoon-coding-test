import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        int last = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                q.offer(x);
                last = x;
            }else if(s.equals("pop")) {
                if(q.isEmpty()) {
                    bw.append("-1\n");
                }else {
                    bw.append(String.valueOf(q.poll()) + "\n");
                }
            }else if(s.equals("size")) {
                bw.append(String.valueOf(q.size()) + "\n");
            }else if(s.equals("empty")) {
                if(q.isEmpty()) {
                    bw.append("1\n");
                }else {
                    bw.append("0\n");
                }
            }else if(s.equals("front")) {
                if(q.isEmpty()) {
                    bw.append("-1\n");
                }else {
                    bw.append(String.valueOf(q.peek()) + "\n");
                }
            }else if(s.equals("back")) {
                if(q.isEmpty()) {
                    bw.append("-1\n");
                }else {
                    bw.append(String.valueOf(last) + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
