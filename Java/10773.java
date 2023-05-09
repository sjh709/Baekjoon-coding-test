import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < k; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                stack.pop();
            }else {
                stack.add(n);
            }
        }
        
        int sum = 0;
        while(stack.size() > 0) {
            sum += stack.pop();
        }
        
        bw.write(String.valueOf(sum));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
