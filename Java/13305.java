import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		long[] dist = new long[n - 1];
		for(int i = 0; i < n - 1; i++) dist[i] = Long.parseLong(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		long[] cost = new long[n];
		for(int i = 0; i < n; i++) cost[i] = Long.parseLong(st2.nextToken());
		
		long minCost = cost[0];
		long answer = minCost * dist[0];
		
		for(int i = 1; i < n - 1; i++) {
			if(minCost > cost[i]) minCost = cost[i];
			
			answer += minCost * dist[i];
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
