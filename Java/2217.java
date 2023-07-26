import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] lope = new int[n];
		
		for(int i = 0; i < n; i++) {
			lope[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(lope);
		
		int maxWeight = 0;
		for(int i = 0; i < n; i++) {
			int w = lope[i] * (n - i);
			maxWeight = Math.max(maxWeight, w);
		}
		
		bw.write(String.valueOf(maxWeight));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
