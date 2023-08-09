import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int e = 0;
		int s = 0;
		int m = 0;
		int year = 0;
		
		while(true) {
			if(e == E && s == S && m == M) break;
			if(e == 15) e = 0;
			if(s == 28) s = 0;
			if(m == 19) m = 0;
			
			e++;
			s++;
			m++;
			year++;
		}
		
		bw.write(String.valueOf(year));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
