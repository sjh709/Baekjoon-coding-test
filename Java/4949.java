import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true) {
            Stack<Character> stack = new Stack<>();
            boolean chk = true;
            
            String s = br.readLine();
            // 종료조건
            if(s.equals(".")) break;
            
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 문자 제거
                if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) continue;
                if(c == ' ' || c == '.') continue;
                // 괄호
                if(c == '[' || c == '(') {
                    stack.push(c);
                }
                if(c == ']' || c == ')') {
                    if(stack.isEmpty()) {
                        chk = false;
                        break;
                    }else {
                        if(stack.peek() == '[' && c == ']') {
                            stack.pop();
                        }else if(stack.peek() == '(' && c == ')') {
                            stack.pop();
                        }else {
                            chk = false;
                            break;
                        }
                    }
                }
            }
            
            if(chk && stack.isEmpty()) {
                bw.append("yes\n");
            }else {
                bw.append("no\n");
            }
        }
        
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
