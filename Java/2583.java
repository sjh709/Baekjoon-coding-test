import java.io.*;
import java.util.*;
public class Main {
	public static int m, n, area;
	public static int[][] arr;
	public static boolean[][] visit;
	public static int[] dx = {0, 0, -1, 1};
	public static int[] dy = {-1, 1, 0, 0};
	
	public static void dfs(int x, int y) {
		area++;
		visit[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
			if(visit[nx][ny] || arr[nx][ny] == 1) continue;
			
			dfs(nx, ny);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		arr = new int[m][n];
		visit = new boolean[m][n];
		ArrayList<Integer> areaList = new ArrayList<>();
		
		for(int z = 0; z < k; z++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i = m - y2; i < m - y1; i++) {
				for(int j = x1; j < x2; j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit[i][j] && arr[i][j] == 0) {
					area = 0;
					cnt++;
					dfs(i, j);
					areaList.add(area);
					
				}
			}
		}
		
		Collections.sort(areaList);
		
		sb.append(cnt).append("\n");
		for(int num : areaList) {
			sb.append(num + " ");
		}
		
		bw.write(sb.toString());
		bw.flush();

		bw.close();
		br.close();
	}
}
