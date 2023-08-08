import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> dq = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) dq.offerLast(i);
		
		st = new StringTokenizer(br.readLine());
		
		int[] seq = new int[m];
		for(int i = 0; i < m; i++) seq[i] = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for(int i = 0; i < m; i++) {
			int target_idx = dq.indexOf(seq[i]);
			int half_idx = dq.size() / 2;
			
			if(target_idx <= half_idx) {
				for(int j = 0; j < target_idx; j++) {
					int temp = dq.pollFirst();
					dq.offerLast(temp);
					count++;
				}
			}else {
				for(int j = 0; j < dq.size() - target_idx; j++) {
					int temp = dq.pollLast();
					dq.offerFirst(temp);
					count++;
				}
			}
			
			dq.pollFirst();
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
