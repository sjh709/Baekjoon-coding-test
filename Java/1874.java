import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if(num > start) {
                for(int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }
                start = num;
            }else if(stack.peek() != num) {
                sb.setLength(0);
                //sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
            stack.pop();
            sb.append("-\n");
        }
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
