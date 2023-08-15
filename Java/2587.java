import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] nums = new int[5];
        int sum = 0;
        
        for(int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }
        
        Arrays.sort(nums);
        
        bw.append(String.valueOf(sum / 5)).append("\n");
        bw.append(String.valueOf(nums[2]));
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
