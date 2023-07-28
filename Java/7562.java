import java.io.*;
import java.util.*;
class Node {
	int x;
	int y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static int n;
	public static int[][] arr;
	public static boolean[][] visit;
	
	public static int[] dx = {-2, -1, -2, -1, 1, 2, 2, 1};
	public static int[] dy = {-1, -2, 1, 2, 2, 1, -1, -2};
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		while(!q.isEmpty()) {
			Node node = q.poll();
			x = node.x;
			y = node.y;
			visit[x][y] = true;
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if(visit[nx][ny]) continue;
				arr[nx][ny] = arr[x][y] + 1;
				visit[nx][ny] = true;
				q.offer(new Node(nx, ny));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n][n];
			visit = new boolean[n][n];
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int start_x = Integer.parseInt(st1.nextToken());
			int start_y = Integer.parseInt(st1.nextToken());
			
			int end_x = Integer.parseInt(st2.nextToken());
			int end_y = Integer.parseInt(st2.nextToken());
			
			bfs(start_x, start_y);
			
			bw.append(String.valueOf(arr[end_x][end_y])).append("\n");
			
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
