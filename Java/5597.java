import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        boolean[] student = new boolean[31];
        for(int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());
            student[n] = true;
        }
        
        for(int i = 1; i <= 30; i++) {
            if(!student[i]) {
                bw.append(String.valueOf(i) + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
