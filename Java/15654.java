import java.io.*;
import java.util.*;
public class Main {
	public static int n, m;
	public static int[] arr, answer;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void solve(int depth) {
		if(depth == m) {
			for(int i = 0; i < m; i++) {
				sb.append(answer[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				answer[depth] = arr[i];
				solve(depth + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		visit = new boolean[n];
		answer = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		solve(0);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
}
