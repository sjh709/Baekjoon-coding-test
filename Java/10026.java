import java.io.*;
import java.util.*;
public class Main {
	public static int n, cnt1, cnt2;
	public static String[][] arr1, arr2;
	public static boolean[][] visit1, visit2;
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {-1, 0, 1, 0};
	
	public static void dfs2(int x, int y) {
		visit2[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			if(visit2[nx][ny]) continue;
			if(!arr2[x][y].equals(arr2[nx][ny])) continue;
			
			dfs2(nx, ny);
		}
	}
	
	public static void dfs1(int x, int y) {
		visit1[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			if(visit1[nx][ny]) continue;
			if(!arr1[x][y].equals(arr1[nx][ny])) continue;
			
			dfs1(nx, ny);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr1 = new String[n][n];
		arr2 = new String[n][n];
		visit1 = new boolean[n][n];
		visit2 = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				arr1[i][j] = String.valueOf(s.charAt(j));
				if(arr1[i][j].equals("G")) {
					arr2[i][j] = "R";
				}else {
					arr2[i][j] = arr1[i][j];
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visit1[i][j]) {
					cnt1++;
					dfs1(i, j);
				}
				if(!visit2[i][j]) {
					cnt2++;
					dfs2(i, j);
				}
			}
		}
		
		bw.write(cnt1 + " " + cnt2);
		bw.flush();
		
		bw.close();
		br.close();
	}
}
