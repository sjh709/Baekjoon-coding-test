import java.io.*;
import java.util.*;
public class Main {
	public static int N, M;
	public static int[] num;
	public static boolean[] visit;
	public static int s = 0;
	public static int answer = 0;
	
	public static void solve(int cnt, int start, int depth) {
		if(cnt == depth) {
			if(s == M) answer++;
			return;
		}
		for(int i = start; i < num.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				s += num[i];
				solve(cnt + 1, i + 1, depth);
				s -= num[i];
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		M = Integer.parseInt(st1.nextToken());
		
		num = new int[N];
		visit = new boolean[N];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st2.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			solve(0, 0, i);
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
