import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hash = new HashMap<>();
            
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                hash.put(type, hash.getOrDefault(type, 0) + 1);
            }
            
            int answer = 1;
            for(int val : hash.values()) {
                answer *= val + 1;
            }
            
            bw.write(String.valueOf(answer - 1));
            bw.newLine();
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}
