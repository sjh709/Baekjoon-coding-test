import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Character[][] arr = new Character[5][15];
		int max_length = 0;
		
		for(int i = 0; i < 5; i++) {
			String str = br.readLine();
			max_length = Math.max(max_length, str.length());
			for(int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < max_length; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[j][i] == null) continue;
				bw.append(arr[j][i]);
			}
		}
		
		bw.flush();
		
		bw.close();
		br.close();
	}
}
