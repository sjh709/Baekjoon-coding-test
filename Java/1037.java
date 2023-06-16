import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        int[] num = new int[t];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < t; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(num);
        
        bw.write(String.valueOf(num[0] * num[t - 1]));
        bw.flush();
        
        bw.close();
        br.close();
    }
}
