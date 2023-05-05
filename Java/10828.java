import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        Stack<Integer> stack = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            if(s.equals("pop")) {
                if(stack.empty()) {
                    bw.append(-1 + "\n");
                }else {
                    bw.append(String.valueOf(stack.pop()) + "\n");
                }
            }
            if(s.equals("size")) {
                bw.append(String.valueOf(stack.size()) + "\n");
            }
            if(s.equals("empty")) {
                if(stack.empty()) {
                    bw.append(1 + "\n");
                }else {
                    bw.append(0 + "\n");
                }
            }
            if(s.equals("top")) {
                if(stack.empty()) {
                    bw.append(-1 + "\n");
                }else {
                    bw.append(String.valueOf(stack.peek()) + "\n");
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
