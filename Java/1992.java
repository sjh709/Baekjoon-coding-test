import java.io.*;
public class Main {
	public static int n;
	public static int[][] video;
	public static StringBuilder sb = new StringBuilder();
	
	public static boolean isSame(int r, int c, int size) {
		int color = video[r][c];
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(video[i][j] != color) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void solve(int r, int c, int size) {
		if(isSame(r, c, size)) {
			sb.append(video[r][c]);
			return;
		}
		
		int newSize = size / 2;
		sb.append("(");
		solve(r, c, newSize); // 왼쪽 위
		solve(r, c + newSize, newSize); // 오른쪽 위
		solve(r + newSize, c, newSize); // 왼쪽 아래
		solve(r + newSize, c + newSize, newSize); // 오른쪽 아래
		sb.append(")");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		
		video = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}
		
		solve(0, 0, n);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
}
