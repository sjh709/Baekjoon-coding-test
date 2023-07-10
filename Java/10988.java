import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String rs = "";
		
		for(int i = s.length() - 1; i >= 0; i--) {
			rs += s.charAt(i);
		}
		
		if(s.equals(rs)) {
			bw.write("1");
		}else {
			bw.write("0");
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
