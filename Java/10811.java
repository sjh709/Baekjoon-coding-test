import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int j = x; j <= y; j++, y--) {
				int num = arr[j];
				arr[j] = arr[y];
				arr[y] = num;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			bw.append(arr[i] + " ");
		}
		
		bw.append("\n");
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
