import java.io.*;
import java.util.*;
public class Main {
	public static int answer = 0;
	
	public static void solve(int r, int c, int size) {
		if(size == 1) return;
		
		// 1사분면
		if((r >= 0 && r < size / 2) && (c >= 0 && c < size / 2)) {
			solve(r, c, size / 2);
		}
		// 2사분면
		else if((r >= 0 && r < size / 2) && (c >= size / 2 && c < size)) {
			answer += (size * size) / 4;
			solve(r, c - size / 2, size / 2);
		}
		// 3사분면
		else if((r >= size / 2 && r < size) && (c >= 0 && c < size / 2)) {
			answer += (size * size) / 4 * 2;
			solve(r - size / 2, c, size / 2);
		}
		// 4사분면
		else if((r >= size / 2 && r < size) && (c >= size / 2 && c < size)) {
			answer += (size * size) / 4 * 3;
			solve(r - size / 2, c - size / 2, size / 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int m = (int)Math.pow(2, n);
		
		solve(r, c, m);
		
		bw.write(String.valueOf(answer));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
