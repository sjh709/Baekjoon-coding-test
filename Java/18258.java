import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			
			if(s.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				dq.offerLast(x);
			}else if(s.equals("pop")) {
				if(dq.isEmpty()) {
					bw.append("-1");
				}else {
					bw.append(String.valueOf(dq.pollFirst()));
				}
				bw.append("\n");
			}else if(s.equals("size")) {
				bw.append(String.valueOf(dq.size())).append("\n");
			}else if(s.equals("empty")) {
				if(dq.isEmpty()) {
					bw.append("1");
				}else {
					bw.append("0");
				}
				bw.append("\n");
			}else if(s.equals("front")) {
				if(dq.isEmpty()) {
					bw.append("-1");
				}else {
					bw.append(String.valueOf(dq.peekFirst()));
				}
				bw.append("\n");
			}else if(s.equals("back")) {
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
