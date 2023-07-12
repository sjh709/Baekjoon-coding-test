import java.io.*;
import java.util.*;
public class Main {
	public static int w, h;
	public static int[][] arr;
	public static boolean[][] visit;
	public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void solve(int x, int y) {
		visit[x][y] = true;
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
			if(visit[nx][ny]) continue;
			if(arr[nx][ny] == 0) continue;
			solve(nx, ny);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) break;
			
			arr = new int[h][w];
			visit = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visit[i][j] && arr[i][j] == 1) {
						cnt++;
						solve(i, j);
					}
				}
			}
			
			bw.append(cnt + "\n");
		}
		
		bw.flush();
		
		bw.close();
		br.close();
		
	}
}
