import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			}else {
				stack.pop();
				
				if(s.charAt(i - 1) == '(') {
					ans += stack.size();
				}else {
					ans += 1;
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
