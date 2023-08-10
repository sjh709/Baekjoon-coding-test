import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();

		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) left.push(str.charAt(i));
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ins = st.nextToken();
			
			if(ins.equals("L")) {
				if(left.isEmpty()) continue;
				char c = left.pop();
				right.push(c);
			}else if(ins.equals("D")) {
				if(right.isEmpty()) continue;
				char c = right.pop();
				left.push(c);
			}else if(ins.equals("B")) {
				if(left.isEmpty()) continue;
				left.pop();
			}else if(ins.equals("P")) {
				char x = st.nextToken().charAt(0);
				left.push(x);
			}
		}
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		while(!right.isEmpty()) {
			bw.write(right.pop());
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
