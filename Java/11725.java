import java.io.*;
import java.util.*;
public class Main {
	public static ArrayList<ArrayList<Integer>> list;
	public static boolean[] visit;
	public static int[] answer;
	
	public static void dfs(int x) {
		visit[x] = true;
		for(int i = 0; i < list.get(x).size(); i++) {
			int y = list.get(x).get(i);
			if(!visit[y]) {
				answer[y] = x;
				dfs(y);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= n; i++) list.add(new ArrayList<Integer>());
		
		visit = new boolean[n + 1];
		answer = new int[n + 1];
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		dfs(1);
		
		for(int i = 2; i <= n; i++) {
			bw.append(String.valueOf(answer[i])).append("\n");
		}
		bw.flush();
		
		bw.close();
		br.close();
	}
}
