import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long s = Long.parseLong(br.readLine());
		int n = 0;
		while(s > 0) {
			s -= ++n;
		}
		
		if(s == 0) {
			bw.write(String.valueOf(n));
		}else {
			bw.write(String.valueOf(n - 1));
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
