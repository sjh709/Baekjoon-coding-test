import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] basket = new int[n + 1];
		for(int i = 1; i <= n; i++) basket[i] = i;
		
		for(int k = 0; k < m; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int temp = basket[i];
			basket[i] = basket[j];
			basket[j] = temp;
		}
		
		for(int i = 1; i <= n; i++) {
			bw.append(basket[i] + " ");
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
