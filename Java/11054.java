import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		int[] adp = new int[n];
		int[] ddp = new int[n];
		
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			adp[i] = 1;
			ddp[i] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(arr[i] < arr[j]) {
					adp[j] = Math.max(adp[j], adp[i] + 1);
				}
			}
		}
		
		for(int i = n - 1; i >= 0; i--) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[i] < arr[j]) {
					ddp[j] = Math.max(ddp[j], ddp[i] + 1);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			max = Math.max(max, adp[i] + ddp[i] - 1);
		}
		
		bw.write(String.valueOf(max));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
