import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String p = br.readLine(); // "RDD"
			int n = Integer.parseInt(br.readLine()); // 4
			String s = br.readLine(); // "[1,2,3,4]"
			String[] str = s.substring(1, s.length() - 1).split("\\,"); // 1,2,3,4
			
			Deque<Integer> dq = new ArrayDeque<>();
			for(int j = 0; j < n; j++) {
				dq.offerLast(Integer.parseInt(str[j]));
			}
			
			boolean reverse = false;
			boolean error = false;
			for(int j = 0; j < p.length(); j++) {
				char c = p.charAt(j);
				
				if(c == 'R') {
					reverse = !reverse;
				}else if(c == 'D') {
					if(dq.isEmpty()) {
						error = true;
						break;
					}else {
						if(reverse) {
							dq.pollLast();
						}else {
							dq.pollFirst();
						}
					}
				}
			}
			
			if(error) {
				sb.append("error").append("\n");
			}else {
				sb.append("[");
				while(!dq.isEmpty()) {
					if(reverse) {
						sb.append(String.valueOf(dq.pollLast()));
					}else {
						sb.append(String.valueOf(dq.pollFirst()));
					}
					
					if(!dq.isEmpty()) sb.append(",");
				}
				sb.append("]").append("\n");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
}
