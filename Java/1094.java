import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		int stick = 64;
		int cnt = 1;
		int sum = 0;
		
		while(true) {
			if(stick + sum > x) {
				stick /= 2;
			}else if(stick + sum < x) {
				sum += stick;
				cnt += 1;
			}else {
				break;
			}
		}
		
		bw.write(String.valueOf(cnt));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
