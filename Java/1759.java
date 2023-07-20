import java.io.*;
import java.util.*;
public class Main {
	public static int L, C;
	public static char[] arr;
	public static boolean[] visit;
	public static char[] answer;
	public static StringBuilder sb = new StringBuilder();
	
	public static void check(String s) {
		int cnt_a = 0;
		int cnt_b = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 모음
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt_a++;
			// 자음
			else cnt_b++;
		}

		if(cnt_a >= 1 && cnt_b >= 2) {
			sb.append(s).append("\n");
		}
	}
	
	public static void comb(int depth, int start) {
		String s = "";
		if(depth == L) {
			for(char c : answer) {
				s += c;
			}
			check(s);
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			if(!visit[i]) {
				visit[i] = true;
				answer[depth] = arr[i];
				comb(depth + 1, i + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st1.nextToken());
		C = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		arr = new char[C];
		visit = new boolean[C];
		answer = new char[L];
		for(int i = 0; i < C; i++) {
			arr[i] = st2.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		
		comb(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		
		bw.close();
		br.close();
	}
}
