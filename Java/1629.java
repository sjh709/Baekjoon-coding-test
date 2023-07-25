import java.io.*;
import java.util.*;
public class Main {
	public static int a, b, c;
	
	public static long pow(int base, int exponent) {
		if(base == 1 || exponent == 1) {
			return base % c;
		}
		
		long tmp = pow(base, exponent / 2);
		
		if(exponent % 2 == 1) {
			return (tmp * tmp % c) * base % c;
		}else {
			return tmp * tmp % c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		long result = pow(a, b);
		
		bw.write(String.valueOf(result));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
