import java.io.*;
import java.util.*;
public class Main {
	public static int r, c, result;
	public static Character[][] board;
	public static boolean[] visit;
	
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};
	
	public static void dfs(int x, int y, int cnt) {
		visit[board[x][y] - 'A'] = true;
		result = Math.max(result, cnt);
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
			if(visit[board[nx][ny] - 'A']) continue;
			dfs(nx, ny, cnt + 1);
		}
		visit[board[x][y] - 'A'] = false;
	}
	
	public static void main(String[] srgs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new Character[r][c];
		visit = new boolean[26];
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		dfs(0, 0, 1);
		
		bw.write(String.valueOf(result));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
