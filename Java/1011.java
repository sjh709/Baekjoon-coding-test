import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = y - x;
			int n = (int)Math.sqrt(d);

			if(d == n * n) {
				bw.append(String.valueOf(2 * n - 1)).append("\n");
			}else if((d > n * n) && (d <= n * n + n)) {
				bw.append(String.valueOf(2 * n)).append("\n");
			}else if((d > n * n + n) && (d < (long)(n + 1) * (n + 1))) {
				bw.append(String.valueOf(2 * n + 1)).append("\n");
			}
			
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
