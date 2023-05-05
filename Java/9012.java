import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean chk = true;
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == '(') {
                    stack.add(c);
                }else {
                    if(stack.size() == 0) {
                        chk = false;
                        break;
                    }else {
                        stack.pop();
                    }
                }
            }
            
            if(!chk) {
                bw.append("NO\n");
            }else {
                if(stack.size() == 0) {
                    bw.append("YES\n");
                }else {
                    bw.append("NO\n");
                }
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
