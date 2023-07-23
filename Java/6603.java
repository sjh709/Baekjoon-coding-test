import java.io.*;
import java.util.*;
public class Main {
	public static int k;
	public static int[] nums, lotto;
	public static boolean[] visit;
	public static StringBuilder sb = new StringBuilder();
	
	public static void comb(int cnt, int start) {
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(lotto[i] + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < k; i++) {
			if(!visit[i]) {
				visit[i] = true;
				lotto[cnt] = nums[i];
				comb(cnt + 1, i + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			
			nums = new int[k];
			visit = new boolean[k];
			for(int i = 0; i < k; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			lotto = new int[6];
			comb(0, 0);
			
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
		
	}
}
