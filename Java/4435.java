import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringBuilder sb = new StringBuilder();
        
        int[] scoreA = {1, 2, 3, 3, 4, 10};
        int[] scoreB = {1, 2, 2, 2, 3, 5, 10};
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int totalA = 0;
            int totalB = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 6; j++) {
                totalA += scoreA[j] * Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 7; j++) {
                totalB += scoreB[j] * Integer.parseInt(st.nextToken());
            }
            
            sb.append("Battle " + (i + 1) + ": ");
            if(totalA > totalB) {
                sb.append("Good triumphs over Evil");
            }else if(totalA < totalB) {
                sb.append("Evil eradicates all trace of Good");
            }else {
                sb.append("No victor on this battle field");
            }
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
        
    }
}
