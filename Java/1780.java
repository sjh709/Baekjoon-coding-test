import java.io.*;
import java.util.*;
public class Main {
	public static int[][] arr;
	public static int[] result = new int[3];
	
	public static boolean isSame(int x, int y, int size) {
		int first = arr[x][y];
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(first != arr[i][j]) return false;
			}
		}
		return true;
	}
	
	public static void solve(int x, int y, int size) {
		if(isSame(x, y, size)) {
			result[arr[x][y] + 1]++;
		}else {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					solve(x + i * size / 3, y + j * size / 3, size / 3);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, n);
		
		bw.append(String.valueOf(result[0])).append("\n");
		bw.append(String.valueOf(result[1])).append("\n");
		bw.append(String.valueOf(result[2])).append("\n");
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
