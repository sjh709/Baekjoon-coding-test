import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String N = br.readLine();
		
		int[] nums = new int[9];
		for(int i = 0; i < N.length(); i++) {
			int idx = N.charAt(i) - '0';
			if(idx == 9) {
				nums[6]++;
			}else {
				nums[idx]++;
			}
		}

		if(nums[6] % 2 == 0) {
			nums[6] = nums[6] / 2;
		}else {
			nums[6] = (nums[6] / 2) + 1;
		}
		
		Arrays.sort(nums);
		
		bw.write(String.valueOf(nums[8]));
		bw.flush();
		
		bw.close();
		br.close();
	}
}
