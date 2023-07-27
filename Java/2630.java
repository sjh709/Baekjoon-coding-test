import java.io.*;
import java.util.*;
public class Main {
	public static int[][] arr;
	public static int w, b;
	
	public static boolean isSame(int r, int c, int size) {
		int first = arr[r][c];
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(first != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void solve(int r, int c, int size) {
		if(isSame(r, c, size)) {
			if(arr[r][c] == 0) {
				w++;
			}else {
				b++;
			}
			return;
		}
		
		int newSize = size / 2;
		solve(r, c, newSize);
		solve(r, c + newSize, newSize);
		solve(r + newSize, c, newSize);
		solve(r + newSize, c + newSize, newSize);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		for(int i = 0 ; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0, n);
		
		bw.append(String.valueOf(w)).append("\n");
		bw.append(String.valueOf(b));
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
